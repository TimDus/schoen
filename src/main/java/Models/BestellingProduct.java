package Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Objects;

@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class BestellingProduct {
    private Integer id;
    private Integer productId;
    private Integer bestellingId;
    private Integer aantal;
    private Product productByProductId;
    private Bestelling bestellingByBestellingId;

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
    @Column(name = "ProductId", nullable = false)
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "BestellingId", nullable = false)
    public Integer getBestellingId() {
        return bestellingId;
    }

    public void setBestellingId(Integer bestellingId) {
        this.bestellingId = bestellingId;
    }

    @Basic
    @Column(name = "Aantal", nullable = false)
    public Integer getAantal() {
        return aantal;
    }

    public void setAantal(Integer aantal) {
        this.aantal = aantal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BestellingProduct that = (BestellingProduct) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(productId, that.productId) &&
                Objects.equals(bestellingId, that.bestellingId) &&
                Objects.equals(aantal, that.aantal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productId, bestellingId, aantal);
    }

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ProductId", referencedColumnName = "Id", nullable = false, insertable = false, updatable = false)
    public Product getProductByProductId()
    {
        return productByProductId;
    }

    public void setProductByProductId(Product productByProductId) {
        this.productByProductId = productByProductId;
    }

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BestellingId", referencedColumnName = "Id", nullable = false, insertable = false, updatable = false)
    public Bestelling getBestellingByBestellingId() {
        return bestellingByBestellingId;
    }

    public void setBestellingByBestellingId(Bestelling bestellingByBestellingId)
    {
        this.bestellingByBestellingId = bestellingByBestellingId;
    }
}
