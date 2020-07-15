
package Model;

import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Payment {
    private String id;
    private String customerID;
    private Date date;
    private float value;
    
    public String id(){return id;}
    public String customerID(){return customerID;}
    public Date date(){return date;}
    public float value(){return value;}
    
    
    public Payment(){
        
    }
    public Payment(String idString, String customeridString, Date date, float money){
        this.id=idString;
        this.customerID= customeridString;
        this.date=date;
        this.value=money;
    }
    public boolean AddPayment(Date date, float money, String customerID) {
        SimpleDateFormat df=new SimpleDateFormat("yyyy/MM/dd");
        String SQL="call USP_AddPayment(\""+df.format(date)+"\",\""+money+"\",\""+Integer.parseInt(customerID)+"\")";
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
}
