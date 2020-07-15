
package Model;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class Category {
    private String id;
    private String name;
    
    public Category(){}
    public Category(String id,String name)
    {
        this.id=id;
        this.name=name;
    }
    public String id(){return id;}
    public String name(){return name;}
    
    public boolean AddCategory(String categoryName) {
        String SQL="call USP_AddCategory('"+categoryName+"')";
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
        } catch (Exception e) {return false;}
    }

    public ArrayList<Category> getCategory() {
        String SQL="call USP_GetCategory()";
        ArrayList<Category> list=new ArrayList<Category>();
        try{
            DataAccessHelper.getInstance().getConnect();
            Statement statement =DataAccessHelper.getInstance().connection.createStatement();
            ResultSet rs=statement.executeQuery(SQL);
            while(rs.next())
            {
                list.add(new Category(rs.getString("MaTheLoai"),rs.getString("TenTheLoai")));
            }
            DataAccessHelper.getInstance().getClose();
        } catch (Exception e) {}
        return list;
    }

     public Category getCategoryByBook(String bookID) {
        String SQL="call USP_GetCategoryByBook('"+bookID+"')";
        Category category=null;
        try{
            DataAccessHelper.getInstance().getConnect();
            Statement statement =DataAccessHelper.getInstance().connection.createStatement();
            ResultSet rs=statement.executeQuery(SQL);
            while(rs.next())
            {
                category=new Category(rs.getString("MaTheLoai"),rs.getString("TenTheLoai"));
            }
            DataAccessHelper.getInstance().getClose();
        } catch (Exception e) {}
        return category;
    }

    public Category getCategoryByID(String id) {
        String SQL="call USP_GetCategoryByID('"+id+"')";
        Category category=null;
        try{
            DataAccessHelper.getInstance().getConnect();
            Statement statement =DataAccessHelper.getInstance().connection.createStatement();
            ResultSet rs=statement.executeQuery(SQL);
            while(rs.next())
            {
                category=new Category(rs.getString("MaTheLoai"),rs.getString("TenTheLoai"));
            }
            DataAccessHelper.getInstance().getClose();
        } catch (Exception e) {}
        return category;
    }
}
