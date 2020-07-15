
package Model;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class ReportRevenue {
    private int month;
    private int year;
    private String bookID;
    private int count;
    private float money;
    
    public int month(){return month;}
    public int year(){return year;}
    public String bookID(){return bookID;}
    public int count(){return count;}
    public float money(){return money;}
    
    public ReportRevenue(){}
    public ReportRevenue(int month,int year,String bookID,int count,float money){
        this.month=month;
        this.year=year;
        this.bookID=bookID;
        this.count=count;
        this.money=money;
    }

    public ArrayList<ReportRevenue> getReportReportRevenue(int month, int year) {
        String SQL;
        ArrayList<ReportRevenue> list=new ArrayList<>();
        try{
            DataAccessHelper.getInstance().getConnect();
            Statement statement =DataAccessHelper.getInstance().connection.createStatement();
            ResultSet rs;
            
            SQL="call USP_FreshReportRevenue(\""+month+"\",\""+year+"\")";
                rs=statement.executeQuery(SQL);
            
            ArrayList<Book>listBook=new ArrayList<>();
            listBook=(new Book()).getBook();
            for(Book temp:listBook){
                SQL="call USP_ImportReportRevenue(\""+month+"\",\""+year+"\",\""+temp.id()+"\")";
                rs=statement.executeQuery(SQL);
            }
            
            SQL="call USP_GetReportRevenue(\""+month+"\",\""+year+"\")";
            rs=statement.executeQuery(SQL);
            while(rs.next())
            {
                list.add(new ReportRevenue(
                        Integer.parseInt(rs.getString("Thang")),
                        Integer.parseInt(rs.getString("Nam")),
                        rs.getString("MaSach"),
                        Integer.parseInt(rs.getString("SoLuongBan")),
                        Float.parseFloat(rs.getString("TongTien"))
                ));
            }
            DataAccessHelper.getInstance().getClose();
            
        } catch (Exception e) {}
        return list;
    }
    
    
}
