
package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Bill {
    //properties
    private String id;
    private String customerID;
    private Date date;
    private float value;
    private float moneyReceive;
    private float moneyChange;
    private String bookID;
    private int count;
    private float price;
    private float moneyBook;
    
    //get Method
    public String id(){return id;}
    public String customerID(){return customerID;}
    public Date date(){return date;}
    public float value(){return value;}
    public float moneyReceive(){return moneyReceive;}
    public float moneyChange(){return moneyChange;}
    public String bookID(){return bookID;}
    public int count(){return count;}
    public float price(){return price;}
    public float moneyBook(){return moneyBook;}
    
    //constructor
    public Bill(){}
    public Bill(String id, String customerID, Date date,
            float value,float moneyReceive, float moneyChange,String bookID,int count,float price,float moneyBook){
        this.id=id;
        this.customerID=customerID;
        this.value=value;
        this.date=date;
        this.moneyChange=moneyChange;
        this.moneyReceive=moneyReceive;
        this.moneyBook=moneyBook;
        this.bookID=bookID;
        this.count=count;
        this.price=price;
    }
    public boolean AddBill(Date date, float value, float moneyReceive, float moneyChange, String customerID) {
        SimpleDateFormat df=new SimpleDateFormat("yyyy/MM/dd");
        String SQL="call USP_AddBill(\""+df.format(date)+"\",\""+value+"\",\""+moneyReceive+"\",\""+moneyChange+"\",\""+Integer.parseInt(customerID)+"\")";
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
    public boolean AddBillInfo(String id, int count, float price, float total) {
        String SQL="call USP_AddBillInfo(\""+id+"\",\""+count+"\",\""+price+"\",\""+total+"\")";
        try{
            DataAccessHelper.getInstance().getConnect();
            Statement statement =DataAccessHelper.getInstance().connection.createStatement();
            int rs=statement.executeUpdate(SQL);
            if(rs>0)
            {
                DataAccessHelper.getInstance().getClose();
                return true;
            }
            {
                DataAccessHelper.getInstance().getClose();
                return false;
            }
        } catch (ClassNotFoundException | SQLException e) {return false;}
    }
    public ArrayList<Bill> getBillByCustomerID(String customer) {
        String SQL="call USP_GetBillByCustomerID(\""+customer+"\")";
        ArrayList<Bill> list=new ArrayList<Bill>();
        try{
            DataAccessHelper.getInstance().getConnect();
            Statement statement =DataAccessHelper.getInstance().connection.createStatement();
            ResultSet rs=statement.executeQuery(SQL);
            while(rs.next())
            {
                String id=rs.getString("SoHoaDon");
                String customerID=rs.getString("MaKhachHang");
                Date date=(new SimpleDateFormat("yyyy-MM-dd")).parse(rs.getString("NgayLap"));
                float value=Math.round(Float.parseFloat(rs.getString("TongTien"))*10)/10;
                float moneyReceive=Math.round(Float.parseFloat(rs.getString("ThanhToan"))*10)/10;
                float moneyChange=Math.round(Float.parseFloat(rs.getString("ConLai"))*10)/10;
                String bookID=rs.getString("MaSach");
                int count=Integer.parseInt(rs.getString("SoLuong"));
                float price=Math.round(Float.parseFloat(rs.getString("DonGiaBan"))*10)/10;
                float moneyBook=Math.round(Float.parseFloat(rs.getString("ThanhTien"))*10)/10;
                
                list.add(new Bill(id, customerID, date, value, moneyReceive,  moneyChange, bookID, count, price, moneyBook));
            }
            DataAccessHelper.getInstance().getClose();
        } catch (ClassNotFoundException | NumberFormatException | SQLException | ParseException e) {}
        return list;
    }
    public ArrayList<Bill> getBillByBillID(String billID) {
        String SQL="call USP_GetBillByBillID(\""+billID+"\")";
        ArrayList<Bill> list=new ArrayList<Bill>();
        try{
            DataAccessHelper.getInstance().getConnect();
            Statement statement =DataAccessHelper.getInstance().connection.createStatement();
            ResultSet rs=statement.executeQuery(SQL);
            while(rs.next())
            {
                String id=rs.getString("SoHoaDon");
                String customerID=rs.getString("MaKhachHang");
                Date date=(new SimpleDateFormat("yyyy-MM-dd")).parse(rs.getString("NgayLap"));
                float value=Math.round(Float.parseFloat(rs.getString("TongTien"))*10)/10;
                float moneyReceive=Math.round(Float.parseFloat(rs.getString("ThanhToan"))*10)/10;
                float moneyChange=Math.round(Float.parseFloat(rs.getString("ConLai"))*10)/10;
                String bookID=rs.getString("MaSach");
                int count=Integer.parseInt(rs.getString("SoLuong"));
                float price=Math.round(Float.parseFloat(rs.getString("DonGiaBan"))*10)/10;
                float moneyBook=Math.round(Float.parseFloat(rs.getString("ThanhTien"))*10)/10;
                
                list.add(new Bill(id, customerID, date, value, moneyReceive,  moneyChange, bookID, count, price, moneyBook));
            }
            DataAccessHelper.getInstance().getClose();
        } catch (ClassNotFoundException | NumberFormatException | SQLException | ParseException e) {}
        return list;
    }
}
