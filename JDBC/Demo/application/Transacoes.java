package JDBC.Demo.application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import JDBC.DBConnection.src.JDBC.DbException;
import JDBC.Demo.db.DB;

/*
 *  - As transações devem ser ACID - Atomicas, Consistêntes, Isoladas e Duráveis.
 *  
 *  - Para implementar traqnsações usando JDBC, usamos 3 funções:
 *      - setAutoCommit(false)  - Cada operação isolada será confirmada automaticamente se TRUE
 *      - commit()              -   Confirmar a transação.
 *      - rollback()            - Desfazer tudo que foi feito até o momento. 
 *  
 */

public class Transacoes {
    public static void main(String[] args) {
        
        Connection conn = null;
        Statement st = null;
        
        try{
            conn = DB.getConnection();
            
            conn.setAutoCommit(false); //protegendo as transações

            st = conn.createStatement();
            int rows1 = st.executeUpdate(
                                        "UPDATE seller SET BaseSalary = 200 "
                                        + "WHERE DepartmentID = 1"
                                        );

            //int x = 1; //simulando uma falha
            //if(x<2) throw new SQLException("Fake Error");
            //Com essa simulação de erro, quem é do Dep1 teve o salario atualizado, já do Dep2 não.
            //para evitar isso, devemos proteger o try com setAutoCommit
            int rows2 = st.executeUpdate(
                                        "UPDATE seller SET BaseSalary = 200 "
                                        + "WHERE DepartmentID = 1"
                                        );
        
            System.out.println("rows1: " + rows1);
            System.out.println("rows2: " + rows2);

            conn.commit(); //confirmando as transações se tudo ocorreu bem até aqui
        }
        catch(SQLException e){
            //e.printStackTrace();
            try {
                conn.rollback();
                throw new DbException("Transaction rolled back! Caused by: " + e.getMessage());
            }
            catch (SQLException e1){
               throw new DbException("Error trying to rollback! Caused by: " + e1.getMessage());
            }
        }
        finally{
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
