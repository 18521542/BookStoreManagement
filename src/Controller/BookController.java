
package Controller;

import Model.Author;
import Model.Book;
import Model.Category;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.ImportBook;


public class BookController {
    Book Model = new Book();
    public void loadTable(JTable table){
        String[] head=new String[]{"STT","Mã sách","Tên sách","Thể loại","Tác giả","Nhà xuất bản","Năm xuất bản","Số lượng tồn"};
        ArrayList<Book> list= Model.getBook();
        Object[][] body=new Object[list.size()][8];
        for(int i=0;i<list.size();i++)
        {
            body[i][0]=i;
            body[i][1]=list.get(i).id();
            body[i][2]=list.get(i).name();
            body[i][3]=list.get(i).category().name();
            String authors="";
            for(int j=0;j<list.get(i).authors().size();j++)
                authors+=list.get(i).authors().get(j).name() +"-";
            body[i][4]=authors;
            body[i][5]=list.get(i).publishCompany();
            body[i][6]=list.get(i).publishYear();
            body[i][7]=list.get(i).count();
        }
        DefaultTableModel dtm = new DefaultTableModel(body,head){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        table.setModel(dtm);
    }
    
    public void loadCBBCategory(JComboBox<String> cbbCategory){
        cbbCategory.removeAllItems();
        ArrayList<Category>list= (new Category()).getCategory();
        for(int i=0;i<list.size();i++){
            cbbCategory.addItem(list.get(i).name()+"-"+list.get(i).id());
        }
    }
    
    public void loadCBBAuthor(JComboBox<String> cbAuthor){
        cbAuthor.removeAllItems();
        ArrayList<Author>list= (new Author()).getAuthor();
        for(int i=0;i<list.size();i++)
        {
            cbAuthor.addItem(list.get(i).name()+":"+list.get(i).id());
        }
    }
    
    public boolean addBook(String name, String category, String authors, String publishCompany, int publishYear){
        String categoryID=category.split("-")[1];
        ArrayList<String> authorsID=new ArrayList<String>();
        for(String temp:authors.split("-"))
        {
            authorsID.add(temp.split(":")[1]);
        }
        return Model.AddBook(name, authorsID, categoryID, publishCompany, publishYear);
    }
    
    public void searchBook(String text,JTable table){
        String[] head=new String[]{"STT","Mã sách","Tên sách","Thể loại","Tác giả","Nhà xuất bản","Năm xuất bản","Số lượng tồn"};
        ArrayList<Book> list= Model.getBook();
        for(int i=0;i<list.size();i++)
        {
            String authors="";
            for(int j=0;j<list.get(i).authors().size();j++)
            {
                authors+=list.get(i).authors().get(j).name();
            }
            if(!((Book)list.get(i)).name().contains(text) && !((Book)list.get(i)).id().equals(text)
                    && !((Book)list.get(i)).category().name().contains(text)
                    && !authors.contains(text)
                    && !((Book)list.get(i)).publishCompany().contains(text)  )
            {
                list.remove(i);
                i--;
            }
        }

       Object[][] body=new Object[list.size()][8];
       for(int i=0;i<list.size();i++)
        {
            body[i][0]=i;
            body[i][1]=((Book)list.get(i)).id();
            body[i][2]=((Book)list.get(i)).name();
            body[i][3]=((Book)list.get(i)).category().name();
            String authors="";
            for(int j=0;j<((Book)list.get(i)).authors().size();j++)
                authors+=((Book)list.get(i)).authors().get(j).name() +"-";
            body[i][4]=authors;
            body[i][5]=((Book)list.get(i)).publishCompany();
            body[i][6]=((Book)list.get(i)).publishYear();
            body[i][7]=((Book)list.get(i)).count();
            //body[i][8]=Math.round(((Book)list.get(i)).price()*10)/10;
        }
        DefaultTableModel dtm = new DefaultTableModel(body,head){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        table.setModel(dtm);
    }
    
    public Book getBookByID(String id){
        return Model.getBookByID(id);
    }
    
    public boolean  updateBook(String id, String name, String category, String authors, String publishCompany, int publishYear){
        String categoryID=category.split("-")[1];
        ArrayList<String> authorsID=new ArrayList<String>();
        for(String temp:authors.split("-"))
        {
            authorsID.add(temp.split(":")[1]);
        }
        return Model.UpdateBook(id, name, categoryID, authorsID, publishCompany, publishYear);
    }

    public void loadImportByBookID(JTable table,String id){
        String[] head=new String[]{"STT","Số phiếu nhập","Ngày lập","Số lượng","Đơn giá","Thành tiền"};
        ArrayList<ImportBook> list= (new ImportBook()).getImporByBookID(id);
        Object[][] body=new Object[list.size()][6];
        for(int i=0;i<list.size();i++)
        {
            body[i][0]=i;
            body[i][1]=list.get(i).id();
            body[i][2]=(new SimpleDateFormat("dd/MM/yyyy")).format(list.get(i).date());
            body[i][3]=list.get(i).count();
            body[i][4]=list.get(i).price();
            body[i][5]=list.get(i).total();
        }
        DefaultTableModel dtm = new DefaultTableModel(body,head){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        table.setModel(dtm);        
    }
}
