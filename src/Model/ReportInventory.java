
package Model;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class ReportInventory {
    //properties
    private int month;
    private int year;
    private String bookID;
    private int firstInventory;
    private int incurredInventory;
    private int lastInventory;
    
    //get Methods
    public int month(){return month;}
    public int year(){return year;}
    public int firstInventory(){return firstInventory;}
    public int incurredInventory(){return incurredInventory;}
    public int lastInventory(){return lastInventory;}
    public String bookID(){return bookID;}
    
    //constructors
    public ReportInventory(){}
    public ReportInventory(int month,int year,String bookID,int firstInventory,
            int incurredInventory,int lastInventory){
        this.month=month;
        this.year=year;
        this.bookID=bookID;
        this.firstInventory=firstInventory;
        this.incurredInventory=incurredInventory;
        this.lastInventory=lastInventory;
    }
    
    //Method
    public ArrayList<ReportInventory> getReportInventory(int month, int year) {
        String SQL;
        ArrayList<ReportInventory> list=new ArrayList<>();
        try{
            DataAccessHelper.getInstance().getConnect();
            Statement statement =DataAccessHelper.getInstance().connection.createStatement();      
            SQL="call USP_FreshReportInventory(\""+month+"\",\""+year+"\")";
            ResultSet rs=statement.executeQuery(SQL);
            
            ArrayList<Book>listBook=new ArrayList<>();
            listBook=(new Book()).getBook();
            for(Book temp:listBook){
                SQL="call USP_ImportReportInventory(\""+month+"\",\""+year+"\",\""+temp.id()+"\")";
                rs=statement.executeQuery(SQL);
            }
            
            SQL="call USP_GetReportInventory(\""+month+"\",\""+year+"\")";
            rs=statement.executeQuery(SQL);
            while(rs.next()){
                list.add(new ReportInventory(
                        Integer.parseInt(rs.getString("Thang")),
                        Integer.parseInt(rs.getString("Nam")),
                        rs.getString("MaSach"),
                        Integer.parseInt(rs.getString("TonDau")),
                        Integer.parseInt(rs.getString("PhatSinh")),
                        Integer.parseInt(rs.getString("TonCuoi"))
                ));
            }
            DataAccessHelper.getInstance().getClose();
        } catch (Exception e) {}
        return list;
    }
}
