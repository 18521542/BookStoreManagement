
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
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        // jdbc:sqlserver://[servername]:port;user=;password=;
        String url = "jdbc:sqlserver://localhost:1433;databaseName=CNPM2020;user=sa;password=123456789";
        connection = DriverManager.getConnection(url);
    }
    public void getClose() throws SQLException{
        connection.close();
    }
}
