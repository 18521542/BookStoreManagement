
package Controller;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Model.Book;
import Model.ReportRevenue;


public class ReportRevenueController {
    ReportRevenue Model=new ReportRevenue();

    public void loadRevenue(JTable table, int month, int year) {
        String[] head=new String[]{"STT", "Mã sách", "Tên sách", "Số lượng bán","Tổng tiền"};
        ArrayList<ReportRevenue> list= Model.getReportReportRevenue(month,year);
        Object[][] body=new Object[list.size()][5];
        for(int i=0;i<list.size();i++)
        {
            body[i][0]=i;
            body[i][1]=list.get(i).bookID();
            body[i][2]=(new Book()).getBookByID(list.get(i).bookID()).name();
            body[i][3]=list.get(i).count();
            body[i][4]=list.get(i).money();
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
