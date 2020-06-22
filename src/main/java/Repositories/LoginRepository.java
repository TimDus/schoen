package Repositories;

import Models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LoginRepository extends JpaRepository<Account, Integer>
{
    @Query("select a from Account a where a.email = :em and a.password = :pw")
    Account getUser(@Param("em") String em, @Param("pw") String pw);
}
