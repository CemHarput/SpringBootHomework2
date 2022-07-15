package com.study.homework2.converter;

import com.study.homework2.dto.AddressDto;
import com.study.homework2.dto.AddressSaveRequestDto;
import com.study.homework2.entity.Address;

import java.util.ArrayList;
import java.util.List;

public class AddressCustomConverter {


    public Address saveReqConvertToAddress(AddressSaveRequestDto addressSaveRequestDto){
        Address address = new Address();

        address.setAddressName(addressSaveRequestDto.getAddressName());
        address.setCountry(addressSaveRequestDto.getCountry());

        return address;
    }

    public Address convertToAddress(AddressDto addressDto){
        Address address = new Address();

        address.setAddressName(addressDto.getAddressName());
        address.setCountry(addressDto.getCountry());
        return address;

    }
    public AddressDto convertToAddressDto(Address address){
        AddressDto addressDto = new AddressDto();
        addressDto.setAddressName(address.getAddressName());
        addressDto.setCountry(address.getCountry());
        return addressDto;
    }

    public List<AddressDto> convertToAddressDtoList(List<Address> addressList){
        List<AddressDto> addressDtoList = new ArrayList<>();
        for(Address address:addressList){
            AddressDto addressDto = convertToAddressDto(address);
            addressDtoList.add(addressDto);
        }

        return addressDtoList;
    }

}
