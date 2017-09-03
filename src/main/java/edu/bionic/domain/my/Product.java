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
public class Product {


    private Integer id;

    private String name;

    private BigDecimal priceForSale;


    private List<Material> materials;
}
