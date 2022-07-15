package com.study.homework2.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "City")
@Getter
@Setter
public class City {

    @Id
    @GeneratedValue(generator = "City")
    @SequenceGenerator(name = "City",sequenceName = "CITY_ID_SEQ")
    private Long id;

    @Column(name = "City_Name",unique = true)
    @NotNull(message = "City name cannot be empty")
    private String name;


    @Column(name = "LicensePlate",unique = true)
    @NotNull(message = "License Plate cannot be empty")
    private String licensePlate;

    @OneToMany
    @JoinColumn(name = "STREET_ID")
    private Set<Street> streetSet = new HashSet<>();
}
