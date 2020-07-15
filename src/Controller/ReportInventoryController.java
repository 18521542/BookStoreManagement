
package controller;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Model.Book;
import Model.ReportInventory;


public class ReportInventoryController {
    ReportInventory Model=new ReportInventory();

    public void loadInventory(JTable table,int month, int year) {
        String[] head=new String[]{"STT", "Mã sách", "Tên sách", "Tồn đầu","Phát sinh","Tồn cuối"};
        ArrayList<ReportInventory> list= Model.getReportInventory(month,year);
        Object[][] body=new Object[list.size()][6];
        for(int i=0;i<list.size();i++)
        {
            body[i][0]=i;
            body[i][1]=list.get(i).bookID();
            body[i][2]=(new Book()).getBookByID(list.get(i).bookID()).name();
            body[i][3]=list.get(i).firstInventory();
            body[i][4]=list.get(i).incurredInventory();
            body[i][5]=list.get(i).lastInventory();
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
