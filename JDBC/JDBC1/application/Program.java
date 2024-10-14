package JDBC.JDBC1.application;

import java.sql.Connection;
import JDBC.JDBC1.db.DB;

public class Program {
    public static void main(String[] args) {
        
        Connection conn = DB.getConnection();
        DB.closeConnection();
    }
}