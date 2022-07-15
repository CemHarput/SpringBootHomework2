package com.study.homework2.converter;

import com.study.homework2.dto.AddressDto;
import com.study.homework2.dto.AddressSaveRequestDto;
import com.study.homework2.dto.AddressUpdateRequestDto;
import com.study.homework2.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    Address convertToAddress(AddressUpdateRequestDto addressUpdateRequestDto);//update

    AddressDto convertToAddressDto(Address address);

    List<AddressDto> convertToAddressDtoList(List<Address> addressList);

    Address convertToAddress(AddressSaveRequestDto addressSaveRequestDto); // save
}
