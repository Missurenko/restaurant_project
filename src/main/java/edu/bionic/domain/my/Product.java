package edu.bionic.domain.my;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by bm on 25.08.17.
 */
@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {

    @Id
    @Access(AccessType.PROPERTY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "price_for_sale")
    private BigDecimal priceForSale;
    @Column(name = "category")
    private Category category;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "material_for_product",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "material_id"))
    private List<Material> materials;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", priceForSale=" + priceForSale +
                ", category=" + category +
                ", materials=" + materials +
                '}';
    }
}
