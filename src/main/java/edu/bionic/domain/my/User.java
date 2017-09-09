package edu.bionic.domain.my;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by bm on 25.08.17.
 */
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @Access(AccessType.PROPERTY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    private Role role;
//
//    @Column(name = "salary")
//    private BigDecimal salary;
//
//    @Column(name = "date_start_work")
//    private LocalDateTime dateStartWork;
//
//    @Column(name = "sex")
//    private Sex sex;

}
