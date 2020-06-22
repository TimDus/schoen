package Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Bestelling {
    private Integer id;
    private Integer accountId;
    private Date besteldatum;
    private Date leverdatum;
    private String totaalPrijs;
    private String postcode;
    private String huisnummer;
    private Account accountByAccountId;
    private Collection<BestellingProduct> bestellingProductsById;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "AccountId", nullable = false)
    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    @Basic
    @Column(name = "Besteldatum", nullable = false)
    public Date getBesteldatum() {
        return besteldatum;
    }

    public void setBesteldatum(Date besteldatum) {
        this.besteldatum = besteldatum;
    }

    @Basic
    @Column(name = "Leverdatum", nullable = false)
    public Date getLeverdatum() {
        return leverdatum;
    }

    public void setLeverdatum(Date leverdatum) {
        this.leverdatum = leverdatum;
    }

    @Basic
    @Column(name = "TotaalPrijs", nullable = false, length = 10)
    public String getTotaalPrijs() {
        return totaalPrijs;
    }

    public void setTotaalPrijs(String totaalPrijs) {
        this.totaalPrijs = totaalPrijs;
    }

    @Basic
    @Column(name = "Postcode", nullable = false, length = 6)
    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Basic
    @Column(name = "Huisnummer", nullable = false, length = 10)
    public String getHuisnummer() {
        return huisnummer;
    }

    public void setHuisnummer(String huisnummer) {
        this.huisnummer = huisnummer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bestelling that = (Bestelling) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(accountId, that.accountId) &&
                Objects.equals(besteldatum, that.besteldatum) &&
                Objects.equals(leverdatum, that.leverdatum) &&
                Objects.equals(totaalPrijs, that.totaalPrijs) &&
                Objects.equals(postcode, that.postcode) &&
                Objects.equals(huisnummer, that.huisnummer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountId, besteldatum, leverdatum, totaalPrijs, postcode, huisnummer);
    }

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AccountId", referencedColumnName = "Id", nullable = false, insertable = false, updatable = false)
    public Account getAccountByAccountId()
    {
        return accountByAccountId;
    }

    public void setAccountByAccountId(Account accountByAccountId)
    {
        this.accountByAccountId = accountByAccountId;
    }

    @JsonManagedReference
    @OneToMany(mappedBy = "bestellingByBestellingId", fetch = FetchType.EAGER)
    public Collection<BestellingProduct> getBestellingProductsById()
    {
        return bestellingProductsById;
    }

    public void setBestellingProductsById(Collection<BestellingProduct> bestellingProductsById)
    {
        this.bestellingProductsById = bestellingProductsById;
    }
}
