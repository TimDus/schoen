package Repositories;

import Models.Account;

public class LoginTestRepository
{
    public Account Login(Account account)
    {
        if(account.getEmail() == "admin@admin.nl" && account.getPassword() == "Test123!")
        {
            return account;
        }
        account.setUsername("fout");
        return account;
    }

    public Account Registreer(Account account)
    {
        return account;
    }
}
