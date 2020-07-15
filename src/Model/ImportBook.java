
package model;

import Model.DataAccessHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;



public class ImportBook {
    private String id;
    private String bookID;
    private int count;
    private float price;
    private float total;
    private Date date;
    private float valueImport;
    
    public ImportBook(){}
    public ImportBook(String id,String bookID,int count, float price, float total, Date date, float valueImport)
    {
        this.id=id;
        this.bookID=bookID;
        this.count=count;
        this.price=price;
        this.total=total;
        this.date=date;
        this.valueImport=valueImport;
    }
    public String id(){return id;}
    public String bookID(){return bookID;}
    public int count(){return count;}
    public float price(){return price;}
    public float total(){return total;}
    public Date date(){return date;}
    public float valueImport(){return valueImport;}

    public boolean AddImportBook(Date date, float value) throws ClassNotFoundException {
        SimpleDateFormat df=new SimpleDateFormat("yyyy/MM/dd");
        String SQL="call USP_AddImportBook(\""+df.format(date)+"\",\""+value+"\")";
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
        } catch (SQLException e) {return false;}
    }

    public boolean AddImportBookInfo(String bookID, int count, float price, float total) throws ClassNotFoundException {
        String SQL="call USP_AddImportBookInfo(\""+bookID+"\",\""+count+"\",\""+price+"\",\""+total+"\")";
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
        } catch (SQLException e) {return false;}
    }

    public ArrayList<ImportBook> getImporByBookID(String bookID) {
        String SQL="call USP_GetImporByBookID(\""+bookID+"\")";
        ArrayList<ImportBook> list=new ArrayList<>();
        try{
            DataAccessHelper.getInstance().getConnect();
            Statement statement =DataAccessHelper.getInstance().connection.createStatement();
            ResultSet rs=statement.executeQuery(SQL);
            while(rs.next())
            {
                String id=rs.getString("SoPhieuNhap");
                String bkID=rs.getString("MaSach");
                int count=Integer.parseInt(rs.getString("SoLuongNhap"));
                float price=Math.round(Float.parseFloat(rs.getString("DonGiaNhap"))*10)/10;
                float total=Math.round(Float.parseFloat(rs.getString("ThanhTien"))*10)/10;
                Date date=(new SimpleDateFormat("yyyy-MM-dd")).parse(rs.getString("NgayLap"));
                float valueImport=Math.round(Float.parseFloat(rs.getString("TongTien"))*10)/10;
                list.add(new ImportBook(id,bkID,count,price,total,date,valueImport));
            }
            DataAccessHelper.getInstance().getClose();
        } catch (Exception e) {}
        return list;
    }
    
}
