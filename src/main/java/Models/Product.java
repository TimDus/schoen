package Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Product {
    private Integer id;
    private String naam;
    private String prijs;
    private String schoenmaat;
    private String kleur;
    private String beschrijving;
    private Integer categorieId;
    private Boolean actief;
    private Collection<BestellingProduct> bestellingProductsById;
    private Categorie categorieByCategorieId;

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
    @Column(name = "Naam", nullable = false, length = 50)
    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    @Basic
    @Column(name = "Prijs", nullable = false, length = 50)
    public String getPrijs() {
        return prijs;
    }

    public void setPrijs(String prijs) {
        this.prijs = prijs;
    }

    @Basic
    @Column(name = "Schoenmaat", nullable = false, length = 5)
    public String getSchoenmaat() {
        return schoenmaat;
    }

    public void setSchoenmaat(String schoenmaat) {
        this.schoenmaat = schoenmaat;
    }

    @Basic
    @Column(name = "Kleur", nullable = false, length = 50)
    public String getKleur() {
        return kleur;
    }

    public void setKleur(String kleur) {
        this.kleur = kleur;
    }

    @Basic
    @Column(name = "Beschrijving", nullable = false, length = 50)
    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    @Basic
    @Column(name = "CategorieId", nullable = false)
    public Integer getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(Integer categorieId) {
        this.categorieId = categorieId;
    }

    @Basic
    @Column(name = "Actief", nullable = false)
    public Boolean getActief() {
        return actief;
    }

    public void setActief(Boolean actief) {
        this.actief = actief;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(naam, product.naam) &&
                Objects.equals(prijs, product.prijs) &&
                Objects.equals(schoenmaat, product.schoenmaat) &&
                Objects.equals(kleur, product.kleur) &&
                Objects.equals(beschrijving, product.beschrijving) &&
                Objects.equals(categorieId, product.categorieId) &&
                Objects.equals(actief, product.actief);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, naam, prijs, schoenmaat, kleur, beschrijving, categorieId, actief);
    }

    @JsonBackReference
    @OneToMany(mappedBy = "productByProductId", fetch = FetchType.LAZY)
    public Collection<BestellingProduct> getBestellingProductsById() {
        return bestellingProductsById;
    }

    public void setBestellingProductsById(Collection<BestellingProduct> bestellingProductsById) {
        this.bestellingProductsById = bestellingProductsById;
    }

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CategorieId", referencedColumnName = "Id", nullable = false, insertable = false, updatable = false)
    public Categorie getCategorieByCategorieId() {
        return categorieByCategorieId;
    }

    public void setCategorieByCategorieId(Categorie categorieByCategorieId) {
        this.categorieByCategorieId = categorieByCategorieId;
    }
}
