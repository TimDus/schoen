package Services;

import Models.Account;
import Repositories.LoginTestRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class LoginServiceTest {
    @Test
    void succeslogin()
    {
        LoginTestRepository loginService = new LoginTestRepository();
        Account account = new Account();
        account.setUsername("Jan");
        account.setEmail("admin@admin.nl");
        account.setPassword("Test123!");
        Assert.assertEquals(account.getUsername(), loginService.Login(account).getUsername());
    }

    @Test
    void failedlogin()
    {
        LoginTestRepository loginService = new LoginTestRepository();
        Account account = new Account();
        account.setUsername("Jan");
        account.setEmail("admin@admin.nl");
        account.setPassword("Test12");
        Assert.assertNotEquals(account.getUsername(), loginService.Login(account).getUsername());
    }

    @Test
    void registreer()
    {
        LoginTestRepository loginService = new LoginTestRepository();
        Account account = new Account();
        account.setEmail("admin@admin.nl");
        account.setPassword("Test12");
        account.setUsername("Jan");
        Account registreer = loginService.Registreer(account);
        Assert.assertSame("Jan", registreer.getUsername());
    }
}
