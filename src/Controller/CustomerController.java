
package Controller;

import Model.Bill;
import Model.Customer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CustomerController {
    Customer Model=new Customer();
    
    //Methods
    public boolean AddCustomer(String name, String phone, String email, String address) {
        return Model.AddCustomer(name,phone,email,address);
    }
    
    public void loadCustomer(JTable table) {
        String[] head=new String[]{"STT", "Mã khách hàng", "Tên khách hàng"}; 
        ArrayList<Customer> list= Model.getCustomer();
        Object[][] body=new Object[list.size()][3];
        for(int i=0;i<list.size();i++)
        {
            body[i][0]=i;
            body[i][1]=list.get(i).id();
            body[i][2]=list.get(i).name();
        }
        DefaultTableModel dtm = new DefaultTableModel(body,head){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        table.setModel(dtm);
    }
    
    public void SearchCustomer(JTable table, String text) {
        String[] head=new String[]{"STT", "Mã khách hàng", "Tên khách hàng"};
        ArrayList<Customer> list= Model.getCustomer();
        for(int i=0;i<list.size();i++)
        {
            if(!list.get(i).name().contains(text) && !list.get(i).id().equals(text))
            {
                list.remove(i);
                i--;
            }
        }
        Object[][] body=new Object[list.size()][7];
        for(int i=0;i<list.size();i++)
        {
            body[i][0]=i;
            body[i][1]=list.get(i).id();
            body[i][2]=list.get(i).name();
        }
        DefaultTableModel dtm = new DefaultTableModel(body,head){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        table.setModel(dtm);
    }
    
    public Customer getCustomerByID(String id) {
        return Model.getCustomerByID(id);
    }
    
    public boolean UpdateCustomer(String id, String name, String phone, String email, String address) {
        return Model.UpdateCustomer(id,name,phone,email,address);
    }
    
    public void loadBillByCustomerID(JTable table,String id) {
        String[] head=new String[]{"STT","Số hóa đơn","Ngày lập","Trị giá hóa đơn"};
        ArrayList<Bill> list= (new Bill()).getBillByCustomerID(id);
        for(int i=0;i<list.size();i++)
        {
            for(int j=i+1;j<list.size();j++)
            {
                if(list.get(i).id().equals(list.get(j).id()))
                    list.remove(j);
            }
        }
        Object[][] body=new Object[list.size()][4];
        for(int i=0;i<list.size();i++)
        {
            body[i][0]=i;
            body[i][1]=list.get(i).id();
            body[i][2]=(new SimpleDateFormat("dd/MM/yyyy")).format(list.get(i).date());
            body[i][3]=list.get(i).value();
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
        table.getColumnModel().getColumn(3).setPreferredWidth(200);
    }
   
}
