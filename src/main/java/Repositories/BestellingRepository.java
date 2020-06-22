package Repositories;

import Models.Bestelling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BestellingRepository extends JpaRepository<Bestelling, Integer>
{
    @Query("select b from Bestelling b where b.id = :id")
    List<Bestelling> GetBestelling(@Param("id") int id);

    @Query("select b from Bestelling b where b.accountId = :accountid")
    List<Bestelling> GetAllByAccountId(@Param("accountid") int id);
}
