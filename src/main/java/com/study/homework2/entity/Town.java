package com.study.homework2.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Town",uniqueConstraints = {@UniqueConstraint(name = "UniqueName",columnNames = {"Town_Name"})})
@Getter
@Setter
public class Town {

    @Id
    @GeneratedValue(generator = "Town")
    @SequenceGenerator(name = "Town",sequenceName = "TOWN_ID_SEQ")
    private Long id;

    @Column(name = "Town_Name",unique = true)
    @NotNull(message = "Town name should not be null")
    private String name;
}
