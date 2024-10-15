package JDBC.DBConnection.src.application;

import java.sql.Connection;
import JDBC.DBConnection.src.JDBC.DB;

public class Program {
    public static void main(String[] args){
        
        Connection conn = DB.getConnection();
        DB.closeConnection();

    }
}