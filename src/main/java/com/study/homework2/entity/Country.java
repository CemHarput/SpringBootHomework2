package com.study.homework2.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Country")
@Getter
@Setter
public class Country {

    @Id
    @GeneratedValue(generator = "Country")
    @SequenceGenerator(name = "Country",sequenceName = "COUNTRY_ID_SEQ")
    private Long id;


    @Column(name = "Country_Name",unique = true)
    @NotNull(message = "Country name cannot be empty")
    private String name;

    @Column(name = "Countrycode",unique = true)
    @NotNull(message = "Country code cannot be empty")
    private String countryCode;

    @OneToMany
    @JoinColumn(name = "CITY_ID")
    private Set<City> citySet = new HashSet<>();


}
