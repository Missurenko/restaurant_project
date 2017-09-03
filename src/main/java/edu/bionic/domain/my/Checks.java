package edu.bionic.domain.my;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
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


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "product_in_check",
            joinColumns = @JoinColumn(name = "check_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
            private List<Product> productList;
}
