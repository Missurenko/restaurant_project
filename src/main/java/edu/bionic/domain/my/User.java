package edu.bionic.domain.my;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by bm on 25.08.17.
 */
@Getter
@Setter
public class User {


    private Integer id;

    private String email;

    private String password;

    private String name;

    private BigDecimal salary;

    private LocalDateTime dateStartWork;

    private Sex sex;

    private Role role;



}
