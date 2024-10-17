package JDBC.ProjetoDAO.src.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;

import JDBC.ProjetoDAO.src.db.DB;
import JDBC.ProjetoDAO.src.db.DbException;
import JDBC.ProjetoDAO.src.model.dao.SellerDao;
import JDBC.ProjetoDAO.src.model.entities.Department;
import JDBC.ProjetoDAO.src.model.entities.Seller;

public class SellerDaoJDBC implements SellerDao {

    private Connection conn; //conexão ativa no DAO
    public SellerDaoJDBC(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insert(Seller obj) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement(
                                        "INSERT INTO seller "
                                        + "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
                                        + "VALUES "
                                        + "(?, ?, ?, ?, ?)",
                                        Statement.RETURN_GENERATED_KEYS
                                        );

            st.setString(1, obj.getName());
            st.setString(2, obj.getEmail());
            st.setDate(3, new java.sql.Date(obj.getBirthDate().getTime()));
            st.setDouble(4, obj.getBaseSalary());
            st.setInt(5, obj.getDepartment().getId());

            int rowsAffected = st.executeUpdate();

            if(rowsAffected > 0){
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){
                    int id = rs.getInt(1); //recupera o valor de ID que o objeto terá
                    obj.setId(id); //atribui esse novo ID do objeto na tabela, para o objeto
                }
                DB.closeResultSet(rs);
            }
            else{
                throw new DbException("Unexpected error! No rows affected!");
            }

        }
        catch(SQLException e){
            throw new DbException(e.getMessage());
        }
        finally{
            DB.closeStatement(st);
        }
    }

    @Override
    public void update(Seller obj) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement(
                                        "UPDATE seller "
                                        + "SET Name=?, Email=?, BirthDate=?, BaseSalary=?, DepartmentId=? "
                                        + "WHERE Id = ?"
                                        );

            st.setString(1, obj.getName());
            st.setString(2, obj.getEmail());
            st.setDate(3, new java.sql.Date(obj.getBirthDate().getTime()));
            st.setDouble(4, obj.getBaseSalary());
            st.setInt(5, obj.getDepartment().getId());
            st.setInt(6, obj.getId());

            st.executeUpdate();
        }
        catch(SQLException e){
            throw new DbException(e.getMessage());
        }
        finally{
            DB.closeStatement(st);
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("DELETE FROM seller WHERE Id = ?");
        } 
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally{
            DB.closeStatement(st);
        }
    }

    @Override
    public Seller findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                                        "SELECT seller.*, department.Name as DepName "
                                        + "FROM seller INNER JOIN department "
                                        + "ON seller.DepartmentId = department.Id "
                                        + "WHERE seller.Id = ?"
                                      );
            st.setInt(1, id);
            /*se retornou um valor da tabela, devemos navegar através dele e capturar
             as informações e criar 2 objetos, um seller e um department*/
            rs = st.executeQuery();
            if(rs.next()){//Se existe um next, há resultado!
                Department dep = instantiateDepartment(rs);
                Seller sel = instantiateSeller(rs, dep);
                return sel;
            }            
            return null;            
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally{
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Seller> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                                        "SELECT seller.*, department.Name as DepName "
                                        + "FROM seller INNER JOIN department "
                                        + "ON seller.DepartmentId = department.Id "
                                        + "ORDER BY Name"
                                      );

            rs = st.executeQuery();

            List<Seller> list = new ArrayList<>();
            Map<Integer, Department> map = new HashMap<>();

            while(rs.next()){//Se existe um next, há resultado!
                /*Buscando evitar instanciar vários departamentos para cada vendedor, nos
                criamos um map o qual guarda os departamentos lidos. Sempre que percorremos
                o while nos verificamos se aquele departamento já não foi instanciado.
                SE NÃO FOI, ele recebe uma instância e é armazenado no map.*/
                Department dep = map.get(rs.getInt("DepartmentId"));
                if(dep == null){
                    dep = instantiateDepartment(rs);
                    map.put(rs.getInt("DepartmentId"), dep);
                }

                Seller sel = instantiateSeller(rs, dep);
                list.add(sel);
            }            
            return list;            
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally{
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Seller> findByDepartment(Department department) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                                        "SELECT seller.*, department.Name as DepName "
                                        + "FROM seller INNER JOIN department "
                                        + "ON seller.DepartmentId = department.Id "
                                        + "WHERE DepartmentId = ? "
                                        + "ORDER BY Name"
                                      );
            st.setInt(1, department.getId());
            /*se retornou um valor da tabela, devemos navegar atraves dele enquanto
             houver um próximo */
            rs = st.executeQuery();

            List<Seller> list = new ArrayList<>();
            Map<Integer, Department> map = new HashMap<>();

            while(rs.next()){//Se existe um next, há resultado!
                /*Buscando evitar instanciar vários departamentos para cada vendedor, nos
                criamos um map o qual guarda os departamentos lidos. Sempre que percorremos
                o while nos verificamos se aquele departamento já não foi instanciado.
                SE NÃO FOI, ele recebe uma instância e é armazenado no map.*/
                Department dep = map.get(rs.getInt("DepartmentId"));
                if(dep == null){
                    dep = instantiateDepartment(rs);
                    map.put(rs.getInt("DepartmentId"), dep);
                }

                Seller sel = instantiateSeller(rs, dep);
                list.add(sel);
            }            
            return list;            
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally{
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    } 

    private Department instantiateDepartment(ResultSet rs) throws SQLException {
        Department dep = new Department();
        dep.setId(rs.getInt("DepartmentId"));
        dep.setName(rs.getString("DepName"));
        return dep;
    }

    private Seller instantiateSeller(ResultSet rs, Department dep) throws SQLException{
        Seller sel = new Seller();
        sel.setId(rs.getInt("Id"));
        sel.setName(rs.getString("Name"));
        sel.setEmail(rs.getString("Email"));
        sel.setBaseSalary(rs.getDouble("BaseSalary"));
        sel.setBirthDate(rs.getDate("BirthDate"));
        sel.setDepartment(dep);
        return sel;
    }  
}
