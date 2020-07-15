
package Controller;

import Model.Author;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class AuthorController {
    Author Model = new Author();
    public boolean AddAuthor(String author) {
        if(author.equals(""))
            return false;
        return Model.AddAuthor(author);
    }

    public void getAuthor(JTable table) {
        String[] head=new String[]{"STT","Mã tác giả","Tên tác giả"};
        ArrayList<Author> list= Model.getAuthor();
        Object[][] body=new Object[list.size()][3];
        for(int i=0;i<list.size();i++)
        {
            body[i][0]=i;
            body[i][1]=((Author)list.get(i)).id();
            body[i][2]=((Author)list.get(i)).name();
        }
        DefaultTableModel dtm = new DefaultTableModel(body,head){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        table.setModel(dtm);
        table.getColumnModel().getColumn(0).setPreferredWidth(70);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
    }

    public void SearchAuthor(JTable table, String text) {
        String[] head=new String[]{"STT","Mã tác giả","Tên tác giả"};
        ArrayList<Author> list= Model.getAuthor();
        for(int i=0;i<list.size();i++)
        {
            if(!list.get(i).name().contains(text) && !list.get(i).id().equals(text))
            {
                list.remove(i);
                i--;
            }
        }
        Object[][] body=new Object[list.size()][3];
        for(int i=0;i<list.size();i++)
        {
            body[i][0]=i;
            body[i][1]=((Author)list.get(i)).id();
            body[i][2]=((Author)list.get(i)).name();
        }
        DefaultTableModel dtm = new DefaultTableModel(body,head){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        table.setModel(dtm);
        table.getColumnModel().getColumn(0).setPreferredWidth(70);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
    }    
}
