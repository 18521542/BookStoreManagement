
package Controller;
import Model.Account;

public class AccountController {
    Account model = new Account();
    public boolean Login(String username, String password ) {
        return model.Login(username, password);
    }
    public Account getAccountByUsername(String p_username){
        return model.getAccountByUserName(p_username);
    }
}
