package Services;

import Models.Bestelling;

import java.util.List;

public interface iBestellingService
{
    List<Bestelling> GetBestelling(int id);
    void Register(Bestelling bestelling);
    List<Bestelling> GetAllByAccountId(int id);
}
