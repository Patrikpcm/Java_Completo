package JDBC.Demo.application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import JDBC.Demo.db.DB;

/*
 *  API:
 *  - PreparedStatement
 *  - executeUpdate
 *  - Statement.RETURN_GENERATED_KEYS
 *  - getGeneratedKeys
 */

public class InserirDados {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Connection conn = null;
        PreparedStatement st = null;

        //cadastrando um novo vendedor
        try{
            conn = DB.getConnection();
            st = conn.prepareStatement(
                 "INSERT INTO seller "
                + "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
                + "VALUES "
                + "(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS
            
            );
        
            //substituindo as interrogações pelos dados a seguir. 
            // *O primeiro valor representa a posição da interrogação
            st.setString(1, "Carlos José");
            st.setString(2, "Carlos@josejose.com");
            st.setDate(3, new java.sql.Date(sdf.parse("22/04/1985").getTime()));
            st.setDouble(4, 3000.00);
            st.setInt(5, 4); //código do departamento
            
            
            /*st = conn.prepareStatement(
                "INSERT INTO department (Name) VALUES ('D1'),('D2')", Statement.RETURN_GENERATED_KEYS
            );*/

            //O resultado dessa operação é um INT informando quantas linhas foram alteradas
            int rowsAffected = st.executeUpdate(); 

            if(rowsAffected < 0){
               ResultSet rs =  st.getGeneratedKeys();
               while (rs.next()){
                int id = rs.getInt(1);
                System.out.println("Done! Id = " + id);
               }
            }
            else{
                System.out.println("No rows affected!");
            }

            System.out.println("Done! Rows affected:" + rowsAffected);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        catch(ParseException e){
            e.printStackTrace();
        }
        finally{
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
