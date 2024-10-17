package JDBC.Demo.application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import JDBC.Demo.db.DB;

/*
 *  API:
 *  - Statement
 *  - ResultSet
 *      - first()       = Move para a posição 1, se houver
 *      - beforeFirst() = Move para a posição zero
 *      - next()        = Move para o próximo, retorna false se estiver no último
 *      - absolute(int) = Move para uma posição dada (dados válidos começam em 1).
 */

public class RecuperarDados {
    public static void main(String[] args){
        
        Connection conn = null; //conectar no banco
        Statement st = null; //consulta sql
        ResultSet rs = null; //resultado armazenado na variável

        try{
            conn = DB.getConnection(); //conectando no banco
            st = conn.createStatement(); //instânciando uma consulta
            rs = st.executeQuery("SELECT * FROM department"); //realizando a consulta
            
            while(rs.next()){
                System.out.println(rs.getInt("Id") + " | " + rs.getString("Name"));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            /* Exceções tratadas no arquivo DB. É importante tratarmos manualmente
               o fechamento dessas instâncias pois a JVM do Java não as trata. Logo,
               fazemos isso para evitar vazamento de memória.*/

            //rs.close(); // gera exceção
            //st.close(); // gera exceção.
            DB.closeResultSet(rs);
            DB.closeStatement(st);
            DB.closeConnection();    
        }

        

    }
}