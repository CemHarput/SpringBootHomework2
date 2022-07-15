package com.study.homework2.service;

import com.study.homework2.converter.AddressMapper;
import com.study.homework2.dto.AddressDto;
import com.study.homework2.dto.AddressSaveRequestDto;
import com.study.homework2.dto.AddressUpdateRequestDto;
import com.study.homework2.entity.Address;
import com.study.homework2.service.entityservice.AddressEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressEntityService addressEntityService;



    public List<AddressDto> findAll(){
        List<Address> addressList = addressEntityService.findAll();

        return AddressMapper.INSTANCE.convertToAddressDtoList(addressList);
    }

    public AddressDto save(AddressSaveRequestDto addressSaveRequestDto){
        if(addressSaveRequestDto == null){
            throw new NullPointerException("addressSaveRequestDto is null");
        }

        Address address = AddressMapper.INSTANCE.convertToAddress(addressSaveRequestDto);

        return AddressMapper.INSTANCE.convertToAddressDto(address);
    }
    public AddressDto findById(Long id){
        Address address = addressEntityService.findByIdWithControl(id);

        return AddressMapper.INSTANCE.convertToAddressDto(address);
    }

    public void delete(Long id){
        Address address = addressEntityService.findByIdWithControl(id);

        addressEntityService.delete(address);
    }

    public AddressDto update(AddressUpdateRequestDto addressUpdateRequestDto){
        Long id = addressUpdateRequestDto.getId();
        boolean isExist = addressEntityService.existsById(id);

        if(!isExist){
            throw new NullPointerException("Address does not exist");
        }

        Address address = AddressMapper.INSTANCE.convertToAddress(addressUpdateRequestDto);

        address = addressEntityService.save(address);

        return AddressMapper.INSTANCE.convertToAddressDto(address);

    }
}
