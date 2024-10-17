package JDBC.Demo.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 * - Por que mesmo o SQL lançando exceções estou lançando uma exceção personalizada?
 *  Isso é feito pois o SQLException é derivado a classe Exception e nos OBRIGA a tratar
 *  a exceção.
 *  Já a nossa DBException é derivada(extends) da classe RunTimeException, o que não nos
 *  obriga a ficar toda hora tratando exceções, apenas quando necessário. Além disso tenho
 *  a minha própria exceção personalizada.
 */

public class DB {    
    //MÉTODO PARA ABRIR A CONEXÃO
    private static Connection conn = null;
    public static Connection getConnection(){ 
        if(conn == null){ //se nulo...
            try{//tenta a conexão
                Properties props = loadProperties(); //pega as propriedades do banco
                String url = props.getProperty("dburl"); //pega a linha dburl do arquivo
                //System.out.println("String do banco: " + url);
                conn = DriverManager.getConnection(url, props); //obtem a conexão com o banco e atribui a conn
                //basicamente instanciamos um objeto que é a conexão com o banco
            }
            catch(SQLException e){ //lança um erro sql se não conseguir conexão
                throw new DbException((e.getMessage())); //exceção personalizada
            }
        }
        return conn;
    }

    //MÉTODO PARA FECHAR A CONEXÃO
    public static void closeConnection(){
        if(conn != null){
            try{
               conn.close(); //se a conexão não for nula, fecha a mesma
            }
            catch(SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }

    //MÉTODO PARA CARREGAR AS CONFIGURAÇÕES DA CONEXÃO
    private static Properties loadProperties(){ //carrega as propriedades do arquivo de conexão
        try(FileInputStream fs = new FileInputStream("JDBC/Demo/db.properties")){ //tenta a conexão
            Properties prop = new Properties();
            prop.load(fs);
            return prop;
        }
        catch(IOException e){ //caso não consiga conectar, lança a exceção personalizada
            throw new DbException(e.getMessage());
        }
    }

    //MÉTODO PARA TRATAR EXCEÇÕES DE STATEMENT
    public static void closeStatement(Statement st){
        if (st != null){
            try {
                st.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs){
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }
}
