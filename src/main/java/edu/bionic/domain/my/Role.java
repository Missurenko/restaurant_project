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
@Table(name = "role")
public class Role {

    @Id
    @Access(AccessType.PROPERTY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
}
