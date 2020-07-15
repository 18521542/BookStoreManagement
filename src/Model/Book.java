
package Model;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Book {
    private String id;
    private String name;
    private ArrayList<Author> authors;
    private Category category;
    private String publishCompany;
    private int publishYear;
    private int count;
    private float price;    
    
    //constructor
    public Book(){}
    public Book(String id, String name,ArrayList<Author>  authors, Category category,
            String publishCompany,int publishYear,int count,float price){
        this.id=id;
        this.name=name;
        this.category=category;
        this.authors=authors;
        this.price=price;
        this.count=count;
        this.publishCompany=publishCompany;
        this.publishYear=publishYear;
    }
    
    //get 
    public String id(){
        return id;
    }
    public String name(){
        return name;
    }
    public ArrayList<Author> authors(){
        return authors;
    }
    public Category category(){
        return category;
    }
    public String publishCompany(){
        return publishCompany;
    }
    public int publishYear(){
        return publishYear;
    }
    public int count(){
        return count;
    }
    public float price(){
        return price;
    }
    
    //Action with db
    public ArrayList<Book> getBook() {
        String SQL="call USP_GetBook()";
        ArrayList<Book> list=new ArrayList<>();
        try{
            DataAccessHelper.getInstance().getConnect();
            Statement statement =DataAccessHelper.getInstance().connection.createStatement();
            ResultSet rs=statement.executeQuery(SQL);
            while(rs.next())
            {
                String id=rs.getString("MaSach");
                String name=rs.getString("TenSach");
                ArrayList<Author> authors=(new Author()).getAuthorByBook(rs.getString("MaSach"));
                Category category=(new Category()).getCategoryByBook(rs.getString("MaSach"));
                String publishCompany=rs.getString("NhaXuatBan");
                int publishYear=Integer.parseInt(rs.getString("NamXuatBan"));
                int count=Integer.parseInt(rs.getString("SoLuongTon"));
                float price=(float)Math.round(Float.parseFloat(rs.getString("DonGiaNhap"))*10)/10;
                Book book=new Book(id, name, authors, category, publishCompany, publishYear, count, price);
                list.add(book);
            }
            DataAccessHelper.getInstance().getClose();
        } catch (Exception e) {}
        return list;
    }
    public Book getBookByID(String bookID) {
        String SQL="call USP_GetBookByID(\""+bookID+"\")";
        Book book=null;
        try{
            DataAccessHelper.getInstance().getConnect();
            Statement statement =DataAccessHelper.getInstance().connection.createStatement();
            ResultSet rs=statement.executeQuery(SQL);
            while(rs.next())
            {
                String id=rs.getString("MaSach");
                String name=rs.getString("TenSach");
                ArrayList<Author> authors=(new Author()).getAuthorByBook(rs.getString("MaSach"));
                Category category=(new Category()).getCategoryByBook(rs.getString("MaSach"));
                String publishCompany=rs.getString("NhaXuatBan");
                int publishYear=Integer.parseInt(rs.getString("NamXuatBan"));
                int count=Integer.parseInt(rs.getString("SoLuongTon"));
                float price=(float)Math.round(Float.parseFloat(rs.getString("DonGiaNhap"))*10)/10;
                book=new Book(id, name, authors, category, publishCompany, publishYear, count, price);
            }
            DataAccessHelper.getInstance().getClose();
        } catch (Exception e) {}
        return book;
    }
    public boolean UpdateBook(String id, String name, String categoryID, ArrayList<String> authorsID, String publishCompany, int publishYear) {
        String SQL="call USP_UpdateBook('"+id+"','"+name+"','"+categoryID+"','"+publishCompany+"','"+publishYear+"')";
        try{
            DataAccessHelper.getInstance().getConnect();
            Statement statement =DataAccessHelper.getInstance().connection.createStatement();
            int rs1=statement.executeUpdate(SQL);
            int rs2=0;
            for(int i=0;i<authorsID.size();i++)
            {
                rs2=statement.executeUpdate("call USP_UpdateBookAuthor('"+id+"','"+authorsID.get(i)+"')");
                if(rs2<=0)
                {
                    DataAccessHelper.getInstance().getClose();
                    return false;
                }
            }
            if(rs1 >0)
            {
                DataAccessHelper.getInstance().getClose();
                return true;
            }
            else
            {
                DataAccessHelper.getInstance().getClose();
                return false;
            }
        } catch (Exception e) {return false;}
    }
    public boolean AddBook(String name,ArrayList<String> authorsID, String categoryID,String publishCompany,int publishYear) {
        String SQL="call USP_AddBook(\""+name+"\",\""+categoryID+"\",\""+publishCompany+"\",\""+publishYear+"\")";
        try{
            DataAccessHelper.getInstance().getConnect();
            Statement statement =DataAccessHelper.getInstance().connection.createStatement();
            int rs1=statement.executeUpdate(SQL);
            int rs2=0;
            for(int i=0;i<authorsID.size();i++)
            {
                rs2=statement.executeUpdate("call USP_AddBookAuthor('"+authorsID.get(i)+"')");
                if(rs2<=0)
                {
                    DataAccessHelper.getInstance().getClose();
                    return false;
                }
            }
            if(rs1 >0)
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
