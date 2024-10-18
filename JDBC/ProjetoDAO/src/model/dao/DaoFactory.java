package JDBC.ProjetoDAO.src.model.dao;

import JDBC.ProjetoDAO.src.db.DB;
import JDBC.ProjetoDAO.src.model.dao.impl.DepartmentDaoJDBC;
import JDBC.ProjetoDAO.src.model.dao.impl.SellerDaoJDBC;

public class DaoFactory {

    public static SellerDao createSellerDao(){
        return new SellerDaoJDBC(DB.getConnection());
    }
    
    public static DepartmentDao createDepartmentDao() {
		return new DepartmentDaoJDBC(DB.getConnection());
	}
}
