
package Model;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import java.sql.*;


import java.sql.ResultSet;


public class Account {
    String username;
    String password;
    int type;
    String RealName;
    String PhoneNumber;
    String Email;
    String Address;
    private static Account instance=null;
    public static Account getInstance(){
        if(Account.instance==null)
            instance = new Account();
        return instance;
    }
    public Account(){};
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }
    public int getType(){
        return this.type;
    }
    public String getRealName(){
        return this.RealName;
    }
    public String getPhoneNumber(){
        return this.PhoneNumber;
    }
    public String getEmail(){
        return this.Email;
    }
    public String getAddress(){
        return this.Address;
    }
    public Account(String p_username, String p_password, int p_type, 
                   String p_RealName, String p_PhoneNumber, String p_Email,String p_Address){
        this.username=p_username;
        this.password=p_password;
        this.type= p_type;
        this.RealName= p_RealName;
        this.PhoneNumber=p_PhoneNumber;
        this.Email=p_Email;
        this.Address= p_Address;
    };
    public boolean Login(String p_username, String p_password){    
        String sqlString = "EXEC USP_Login @p_username="+p_username+", @p_password="+p_password;
        //USP_Login là 1 procedure trong csdl
        try {
            DataAccessHelper.getInstance().getConnect();
            Statement statement = DataAccessHelper.getInstance().connection.createStatement();
            ResultSet rs = statement.executeQuery(sqlString);
            if(rs.next())
            {
                DataAccessHelper.getInstance().getClose();
                return true;
            }
            DataAccessHelper.getInstance().getClose();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Lỗi");
        }
        return false;
    } 
    public Account getAccountByUserName(String p_username){
        String sqlString= "EXEC USP_GetAccountByUsername @p_username= "+p_username;
        Account account_rs = null;
        try {
            DataAccessHelper.getInstance().getConnect();
            Statement statement = DataAccessHelper.getInstance().connection.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = statement.executeQuery(sqlString);     
            while(rs.next()){
                account_rs= new Account(rs.getString(1), 
                                        rs.getString(2),
                                        rs.getInt(3),
                                        rs.getString(4),   
                                        rs.getString(5), 
                                        rs.getString(6),
                                        rs.getString(7));
            }
            DataAccessHelper.getInstance().getClose();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Lỗi");
        }
        return account_rs;
    }
    
}
