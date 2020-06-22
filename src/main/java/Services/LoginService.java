package Services;

import Models.Account;
import Repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements iLoginService
{
    @Autowired
    private LoginRepository loginRepository;

    public Account getUser(String em, String pw) {
        return loginRepository.getUser(em, pw);
    }

    public Account RegisterUser(Account account)
    {
        return loginRepository.save(account);
    }
}
