
package Model;

import java.sql.SQLException;
import java.sql.*;


import java.sql.ResultSet;
import java.util.ArrayList;


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
        //Sql_Server
        String sqlString = "EXEC USP_Login @p_username="+p_username+", @p_password="+p_password;
        //MySQL
        //String sqlString = "Call USP_Login('"+p_username+"','"+p_password+"')";
        //Oracle
        //String sqlString="Chua biet";
        //USP_Login là 1 procedure trong csdl
//        String sqlString = ""
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
            System.out.println(ex);
        }
        return false;
    } 
    public Account getAccountByUserName(String p_username){
        //sql server
        String sqlString= "EXEC USP_GetAccountByUsername @p_username= "+p_username;
        //my sql
        //String sqlString= "Call USP_GetAccountByUsername ('"+p_username+"')";
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
    public ArrayList<Account> getAccount() {
        //SQL SERVER
        String SQL="EXEC USP_GetAccount";
        //MySQL
        //String SQL= "Call USP_GetAccount()";
        ArrayList<Account> list=new ArrayList<Account>();
        try{
            DataAccessHelper.getInstance().getConnect();
            Statement statement =DataAccessHelper.getInstance().connection.createStatement();
            ResultSet rs=statement.executeQuery(SQL);
            while(rs.next())
            {
                list.add(new Account(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4),   
                                     rs.getString(5),rs.getString(6),rs.getString(7)));
            }
            DataAccessHelper.getInstance().getClose();
        } catch (Exception e) {}
        return list;
    }
    public boolean AddAccount(String p_username, String p_password, int p_type, 
                   String p_RealName, String p_PhoneNumber, String p_Email,String p_Address) {
        //SQL SERVER
        String SQL="EXEC USP_AddAccount @p_username="   +p_username   +","+
                                        "@p_password="   +p_password   +","+
                                        "@p_type="       +p_type       +","+
                                        "@p_RealName=N'"   +p_RealName   +"',"+
                                        "@p_PhoneNumber="+p_PhoneNumber+","+
                                        "@p_Email='"      +p_Email      +"',"+
                                        "@p_Address=N'"    +p_Address    +"'";
        //MySQL
//        String SQL="Call USP_AddAccount ('"   +p_username   +"','"+
//                                        p_password   +"','"+
//                                        p_type       +"','"+
//                                        p_RealName   +"','"+
//                                        p_PhoneNumber+"','"+
//                                        p_Email      +"','"+
//                                        p_Address    +"')";
        try{
            DataAccessHelper.getInstance().getConnect();
            Statement statement =DataAccessHelper.getInstance().connection.createStatement();
            int rs=statement.executeUpdate(SQL);
            if(rs>0)
            {
                DataAccessHelper.getInstance().getClose();
                return true;
            }
            else
            {
                DataAccessHelper.getInstance().getClose();
                return false;
            }
        } catch (ClassNotFoundException | SQLException e) {return false;}
    }
    public boolean DeleteAccountByUsername(String p_username){
        //sql server
        String SQL="EXEC USP_DeleteAccountByUsername @p_username="+p_username;
        //mysql
        //String SQL="Call USP_DeleteAccountByUsername('"+p_username+"')";
        try{
            DataAccessHelper.getInstance().getConnect();
            Statement statement =DataAccessHelper.getInstance().connection.createStatement();
            int rs=statement.executeUpdate(SQL);
            if(rs>0)
            {
                DataAccessHelper.getInstance().getClose();
                return true;
            }
            else
            {
                DataAccessHelper.getInstance().getClose();
                return false;
            }
        } catch (ClassNotFoundException | SQLException e) {return false;}
    }
    public boolean UpdateAccountByUsername(String p_username, String p_password, int p_type, 
                   String p_RealName, String p_PhoneNumber, String p_Email,String p_Address){
        //SQL SERVER
         String SQL="EXEC USP_UpdateAccountByUsername @p_username='"   +p_username   +"', "+
                                        "@p_password='"   +p_password   +"', "+
                                        "@p_type="       +p_type       +", "+
                                        "@p_RealName=N'"   +p_RealName   +"', "+
                                        "@p_PhoneNumber='"+p_PhoneNumber+"', "+
                                        "@p_Email='"      +p_Email      +"', "+
                                        "@p_Address=N'"    +p_Address    +"'";
         //MySQL
//        String SQL="Call USP_AddAccount ('"   +p_username   +"','"+
//                                        p_password   +"','"+
//                                        p_type       +"','"+
//                                        p_RealName   +"','"+
//                                        p_PhoneNumber+"','"+
//                                        p_Email      +"','"+
//                                        p_Address    +"')";
        try{
            DataAccessHelper.getInstance().getConnect();
            Statement statement =DataAccessHelper.getInstance().connection.createStatement();
            int rs=statement.executeUpdate(SQL);
            if(rs>0)
            {
                DataAccessHelper.getInstance().getClose();
                return true;
            }
            else
            {
                DataAccessHelper.getInstance().getClose();
                return false;
            }
        } catch (ClassNotFoundException | SQLException e) {return false;}
    }
}
