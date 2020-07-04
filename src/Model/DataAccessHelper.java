
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


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
//      sql_server
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url      = "jdbc:sqlserver://localhost:1433;databaseName=BookStoreData;";
        String user     = "sa";
        String password = "123456789";
        
//        mysql
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        String url = "jdbc:mysql://localhost:3306/cnpm2020?useLegacyDatetimeCode=false&serverTimezone=Asia/Ho_Chi_Minh";
//        String user ="root";
//        String password ="";
       
//        mysql online     
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        String url = "jdbc:mysql://db4free.net:3306/cnpm2020?useLegacyDatetimeCode=false&serverTimezone=Asia/Ho_Chi_Minh";
//        String user ="hoangtucodon2000";
//        String password ="Trong2000";

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
