package com.study.homework2.entity;


import com.fasterxml.jackson.databind.ser.Serializers;
import com.study.homework2.gen.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Address")
@Getter
@Setter
public class Address extends BaseEntity {
    @Id
    @GeneratedValue(generator = "Address")
    @SequenceGenerator(name = "Address",sequenceName = "ADD_ID_SEQ")
    private Long id;


    @Column(name = "Address Name",unique = true)
    @NotNull(message = "Address name cannot be empty")
    private String addressName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id",referencedColumnName = "id")
    private Country country;







}
