package Services;

import Models.Bestelling;
import Repositories.BestellingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BestellingService implements iBestellingService
{
    @Autowired
    private BestellingRepository bestellingRepository;

    public List<Bestelling> GetBestelling(int id)
    {
        return bestellingRepository.GetBestelling(id);
    }

    public void Register(Bestelling bestelling)
    {
        bestellingRepository.save(bestelling);
    }

    @Override
    public List<Bestelling> GetAllByAccountId(int id)
    {
        return bestellingRepository.GetAllByAccountId(id);
    }
}
