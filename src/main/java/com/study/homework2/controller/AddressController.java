package com.study.homework2.controller;

import com.study.homework2.converter.AddressMapper;
import com.study.homework2.dto.AddressDto;
import com.study.homework2.dto.AddressSaveRequestDto;
import com.study.homework2.dto.AddressUpdateRequestDto;
import com.study.homework2.entity.Address;
import com.study.homework2.service.AddressService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/v1/addresses")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;





    @GetMapping
    public ResponseEntity findAll(){

        List<AddressDto> addressDtoList = addressService.findAll();

        return new ResponseEntity<>(addressDtoList, HttpStatus.ACCEPTED);
    }
    @PostMapping
    public ResponseEntity save(@RequestBody AddressSaveRequestDto addressSaveRequestDto){
        AddressDto addressDto = addressService.save(addressSaveRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(addressDto);
    }

    @Operation(tags = "Address Controller")
    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        AddressDto addressDto = addressService.findById(id);

        return new ResponseEntity<>(addressDto,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){

        try {
            addressService.delete(id);

            return ResponseEntity.noContent().build();

        }catch (EmptyResultDataAccessException e){

            return ResponseEntity.notFound().build();
        }


    }
    @PutMapping
    public ResponseEntity update(@RequestBody AddressUpdateRequestDto addressUpdateRequestDto){
        AddressDto addressDto = addressService.update(addressUpdateRequestDto);

        return new ResponseEntity<>(addressDto,HttpStatus.ACCEPTED);
    }
}
