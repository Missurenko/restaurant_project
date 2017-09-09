package edu.bionic.domain.my;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bm on 26.08.17.
 */
@Getter
@Setter
@Entity
@Table(name = "checks")
public class Checks {

    @Id
    @Access(AccessType.PROPERTY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date_pay")
    private LocalDateTime datePay;
    @Column(name = "position")
    private Integer position;
    @Column(name = "summa")
    private BigDecimal summa;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "product_in_check",
            joinColumns = @JoinColumn(name = "check_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> productList;

    @NotBlank(message = "Имя не должно быть пустым")
    private String name;

    @NotBlank(message = "Это поле должно быть заполнено")
    @Email(message = "Поле должно содержать правильный email")
    private String email;
    @NotBlank(message = "Это поле должно быть заполнено")
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Checks() {
        this.productList = new ArrayList<>();
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.datePay = dateTime;
    }

    public void addProduct(Product newProduct) {
        productList.add(newProduct);
    }

    public void removeProduct(int indexOfProduct) {
        productList.remove(indexOfProduct);
    }
}
