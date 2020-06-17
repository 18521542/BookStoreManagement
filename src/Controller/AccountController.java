
package Controller;
import Model.Account;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AccountController {
    Account model = new Account();
    public boolean Login(String username, String password ) {
        return model.Login(username, password);
    }
    public Account getAccountByUsername(String p_username){
        return model.getAccountByUserName(p_username);
    }
    public JTable getAccount(JTable table) {
        String[] head=new String[]{"STT","Tên người sử dụng","Tên tài khoản","Loại tài khoản"};
        ArrayList<Account> list= model.getAccount();
        Object[][] body=new Object[list.size()][4];
        for(int i=0;i<list.size();i++)
        {
            body[i][0]=i;
            body[i][1]=((Account)list.get(i)).getRealName();
            body[i][2]=((Account)list.get(i)).getUsername();
            body[i][3]=((Account)list.get(i)).getType();
        }
        DefaultTableModel dtm = new DefaultTableModel(body,head){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        table.setModel(dtm);
        return table;
    }
    public boolean AddAccount(String p_username, String p_password, int p_type, 
                   String p_RealName, String p_PhoneNumber, String p_Email,String p_Address){
          if(!checkAdd(p_username, p_password, p_type, p_RealName, p_PhoneNumber, p_Email, p_Address))
              return false;
          return model.AddAccount(p_username, p_password, p_type, p_RealName, p_PhoneNumber, p_Email, p_Address);
    }
    public boolean checkAdd(String p_username, String p_password, int p_type, 
                   String p_RealName, String p_PhoneNumber, String p_Email,String p_Address){
        if(p_username.equals("")
                ||p_password.equals("")
                ||p_type==-1
                ||p_RealName.equals("")
                ||p_PhoneNumber.equals("")
                ||p_Email.equals("")
                ||p_Address.equals(""))
            return false;
        return true;
    }
    public boolean DeleteAccountByUsername(String p_username){
        return model.DeleteAccountByUsername(p_username);
    }
    public boolean UpdateAccountByUsername(String p_username, String p_password, int p_type, 
                   String p_RealName, String p_PhoneNumber, String p_Email,String p_Address){
        //if(!checkupdate(p_username, p_password, p_type, p_RealName, p_PhoneNumber, p_Email, p_Address))
        //return false;
        return model.UpdateAccountByUsername(p_username, p_password, p_type, p_RealName, p_PhoneNumber, p_Email, p_Address);
    }
    //public boolean checkUpdate(){}
}
