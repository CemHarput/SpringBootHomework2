package com.study.homework2.dto;


import com.study.homework2.entity.Country;
import lombok.Data;

@Data
public class AddressDto {


    private Long id;
    private String addressName;
    private Country country;

}
