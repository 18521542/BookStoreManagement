
package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Customer {
    //properties
    private String id;
    private String name;
    private String phoneNumber;
    private String email;
    private String address;
    private float owe;
    
    //get Methods
    public String id(){return id;}
    public String name(){return name;}
    public String phoneNumber(){return phoneNumber;}
    public String email(){return email;}
    public String address(){return address;}
    public float owe(){return owe;}
    
    //Constructor
    public Customer(){}
    public Customer(String id, String name, String phoneNumber, String email, String address, float owe){
        this.id=id;
        this.name=name;
        this.phoneNumber=phoneNumber;
        this.email=email;
        this.address=address;
        this.owe=owe;
    }
    
    //Method
    public boolean AddCustomer(String name, String phone, String email, String address) {
        String SQL="call USP_AddCusTomer(\""+name+"\",\""+phone+"\",\""+email+"\",\""+address+"\")";
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
    public ArrayList<Customer> getCustomer() {
        String SQL="CALL USP_GetCustomer()";
        ArrayList<Customer> list=new ArrayList<Customer>();
        try{
            DataAccessHelper.getInstance().getConnect();
            Statement statement =DataAccessHelper.getInstance().connection.createStatement();
            ResultSet rs=statement.executeQuery(SQL);
            while(rs.next())
            {
                String id=rs.getString("MaKhachHang");
                String name=rs.getString("TenKhachHang");
                String phone=rs.getString("SoDienThoai");
                String email=rs.getString("Email");
                String address=rs.getString("DiaChi");
                Float owe=(float)Math.round(Float.parseFloat(rs.getString("SoTienNo")));
                list.add(new Customer(id,name,phone,email,address,owe));
            }
            DataAccessHelper.getInstance().getClose();
        } catch (Exception e) {}
        return list;
    }
    public Customer getCustomerByID(String customerID) {
        String SQL="CALL USP_GetCustomerByID(\""+customerID+"\")";
        Customer customer=null;
        try{
            DataAccessHelper.getInstance().getConnect();
            Statement statement =DataAccessHelper.getInstance().connection.createStatement();
            ResultSet rs=statement.executeQuery(SQL);
            while(rs.next())
            {
                String id=rs.getString("MaKhachHang");
                String name=rs.getString("TenKhachHang");
                String phone=rs.getString("SoDienThoai");
                String email=rs.getString("Email");
                String address=rs.getString("DiaChi");
                Float owe=(float)Math.round(Float.parseFloat(rs.getString("SoTienNo")));
                customer=new Customer(id,name,phone,email,address,owe);
            }
            DataAccessHelper.getInstance().getClose();
        } catch (Exception e) {}
        return customer;
    }
    public boolean UpdateCustomer(String id, String name, String phone, String email, String address) {
        String SQL="call USP_UpdateCusTomer(\""+id+"\",\""+name+"\",\""+phone+"\",\""+email+"\",\""+address+"\")";
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
