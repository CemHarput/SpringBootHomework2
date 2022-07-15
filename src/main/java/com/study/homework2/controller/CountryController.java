package com.study.homework2.controller;

import com.study.homework2.dao.CountryDao;
import com.study.homework2.entity.City;
import com.study.homework2.entity.Country;
import com.study.homework2.entity.Street;
import lombok.AllArgsConstructor;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/countries")
@AllArgsConstructor
public class CountryController {

    private CountryDao countryDao;

    @PostMapping
    public ResponseEntity<Country> saveCountry(@RequestBody Country country){

        country = countryDao.save(country);
        return new ResponseEntity<>(country, HttpStatus.ACCEPTED);
    }

    @PostMapping("update/{id}/{newCountry}")
    public ResponseEntity<Country> updateCountry(@RequestParam long id, String newCountry){

        Country country = countryDao.findById(id).orElseThrow();
        country.setName(newCountry);
        countryDao.save(country);
        return new ResponseEntity<>(country,HttpStatus.ACCEPTED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Country> findByCountryId(@RequestParam long id){

        Country country = countryDao.findById(id).orElseThrow();
        return new ResponseEntity<>(country,HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity findAll(){

        List<Country> countryList = countryDao.findAll();

        return new ResponseEntity<>(countryList,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){

        try{
            countryDao.deleteById(id);
            return ResponseEntity.noContent().build();

        }catch (EmptyResultDataAccessException e){

            return ResponseEntity.notFound().build();
        }

    }


}
