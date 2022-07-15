package com.study.homework2.dto;


import com.study.homework2.entity.City;
import com.study.homework2.entity.Country;
import com.study.homework2.entity.Street;
import com.study.homework2.entity.Town;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class AddressUpdateRequestDto {

    private Long id;
    private String addressName;
    private Country country;

}
