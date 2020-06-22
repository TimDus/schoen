package Controllers;

import Models.Bestelling;
import Services.iBestellingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@CrossOrigin
@RestController
public class BestellingController
{
    @Autowired
    iBestellingService ibestellingService;

    @GetMapping("/getbestelling")
    public List<Bestelling> GetBestelling(int bestellingid)
    {
        return ibestellingService.GetBestelling(bestellingid);
    }

    @GetMapping("/getallbestelling")
    public List<Bestelling> GetAllByAccountId(int userid)
    {
        return ibestellingService.GetAllByAccountId(userid);
    }

    @PostMapping("/bestel")
    public void Register(int id, String postcode, String huisnummer, Date leverdatum)
    {
        java.sql.Date besteldatum = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        Bestelling bestelling = new Bestelling();
        bestelling.setAccountId(id);
        bestelling.setBesteldatum(besteldatum);
        bestelling.setLeverdatum(leverdatum);
        bestelling.setTotaalPrijs("0");
        bestelling.setPostcode(postcode);
        bestelling.setHuisnummer(huisnummer);

        ibestellingService.Register(bestelling);
    }
}
