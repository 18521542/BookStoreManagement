
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DataAccessHelper {
    public Connection connection = null;
    private static DataAccessHelper instance = null;
    public static DataAccessHelper getInstance()
    {
        if(instance==null)
            instance=new DataAccessHelper();
        return instance;
    }
    public void getConnect () throws SQLException, ClassNotFoundException{
        //sql_server
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=CNPM2020;";
        String user="sa";
        String password="123456789";
        
//        mysql
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        String url = "jdbc:mysql://localhost:8080/cnpm2020";
//        String user ="root";
//        String password ="";

//        oracle
//        Class.forName("oracle.jdbc.driver.OracleDriver");
//        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
//        String user ="test";
//        String password = "admin";

        connection = DriverManager.getConnection(url, user, password);
    }
    public void getClose() throws SQLException{
        connection.close();
    }
}
