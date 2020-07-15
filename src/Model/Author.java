
package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Author {
        private String id;
    private String name;
    
    public Author(){}
    public Author(String id, String name){
        this.id=id;
        this.name=name;
    }
    public String id(){
        return id;
    }
    public String name(){
        return name;
    }
    public ArrayList<Author> getAuthor(){
        String SQL="call USP_GetAuthor()";
        ArrayList<Author> list=new ArrayList<>();
        try{
            DataAccessHelper.getInstance().getConnect();
            Statement statement =DataAccessHelper.getInstance().connection.createStatement();
            ResultSet rs=statement.executeQuery(SQL);
            while(rs.next())
            {
                list.add(new Author(rs.getString("MaTacGia"),rs.getString("TenTacGia")));
            }
            DataAccessHelper.getInstance().getClose();
        } catch (ClassNotFoundException | SQLException e) {}
        return list;        
    }
    public boolean AddAuthor(String author){
        String SQL="call USP_AddAuthor('"+author+"')";
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
    public ArrayList<Author> getAuthorByBook(String bookID) {
        String SQL="call USP_GetAuthorByBook('"+bookID+"')";
        ArrayList<Author> list=new ArrayList<>();
        try{
            DataAccessHelper.getInstance().getConnect();
            Statement statement =DataAccessHelper.getInstance().connection.createStatement();
            ResultSet rs=statement.executeQuery(SQL);
            while(rs.next())
            {
                list.add(new Author(rs.getString("MaTacGia"),rs.getString("TenTacGia")));
            }
            DataAccessHelper.getInstance().getClose();
        } catch (ClassNotFoundException | SQLException e) {}
        return list;
    }
}
