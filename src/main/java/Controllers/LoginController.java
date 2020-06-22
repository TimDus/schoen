package Controllers;

import Models.Account;
import Services.iLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class LoginController
{
    @Autowired
    iLoginService iloginService;

    @GetMapping("/login")
    public Account GetAccount(String em, String pw)
    {
        return iloginService.getUser(em, pw);
    }

    @PostMapping("/register")
    public Account RegisterUser(String em, String un, String pw)
    {
        Account account = new Account();
        account.setUsername(un);
        account.setEmail(em);
        account.setPassword(pw);

        return iloginService.RegisterUser(account);
    }
}
