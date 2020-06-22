package Services;

import Models.Account;

public interface iLoginService
{
    Account getUser (String em, String pw);
    Account RegisterUser (Account account);
}
