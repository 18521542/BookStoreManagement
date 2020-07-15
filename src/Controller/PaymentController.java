
package Controller;

import Model.Payment;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PaymentController {
    Payment Model = new Payment();
    public boolean AddPayment(String date, String money, String customerID) throws ParseException
    {
        if(!Model.AddPayment(new SimpleDateFormat("dd/MM/yyyy").parse(date),
                Float.parseFloat(money),customerID))
            return false;
        return true;
    }
}
