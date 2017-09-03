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
public class Checks {


    private Integer id;

    private BigDecimal price;

    private String codeCardVisitor;

    private LocalDateTime dateCame;
    private LocalDateTime datePay;

    private Integer position;


    private List<Product> productList;


    private User user;


}
