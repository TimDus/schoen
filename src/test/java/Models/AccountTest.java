package Models;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class AccountTest{

    @Test
    void AccountKlasse()
    {
        String Testnaam = "Jan";
        String Testww = "Test123";

        Account account = new Account();
        account.setUsername(Testnaam);
        account.setPassword(Testww);

        Assert.assertSame("Jan", account.getUsername());
        Assert.assertSame("Test123", account.getPassword());
    }
}
