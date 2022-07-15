package com.study.homework2.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Street")
@Getter
@Setter
public class Street {

    @Id
    @GeneratedValue(generator = "Street")
    @SequenceGenerator(name = "Street",sequenceName = "STREET_ID_SEQ")
    private Long id;


    @Column(name="Street_Name",unique = true)
    @NotNull(message = "Street name should not be null")
    private String name;

    @OneToMany
    @JoinColumn(name = "TOWN_ID")
    private Set<Town> townSet = new HashSet<>();
}
