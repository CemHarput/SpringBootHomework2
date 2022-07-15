package com.study.homework2.controller;

import com.study.homework2.dao.CityDao;
import com.study.homework2.entity.City;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cities")
@AllArgsConstructor
public class CityController {

    private CityDao cityDao;

    @PostMapping
    public ResponseEntity<City> saveCity(@RequestBody City city){

        city = cityDao.save(city);
        return new ResponseEntity<>(city, HttpStatus.ACCEPTED);
    }

    @PostMapping("update/{id}/{newCity}")
    public ResponseEntity<City> updateCity(@RequestParam long id, String newCity){

        City city = cityDao.findById(id).orElseThrow();
        city.setName(newCity);
        cityDao.save(city);

        return new ResponseEntity<>(city,HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> findByCityId(@RequestParam long id){

        City city = cityDao.findById(id).orElseThrow();



        return new ResponseEntity<>(city,HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity findAll(){

        List<City> cityList = cityDao.findAll();

        return new ResponseEntity<>(cityList,HttpStatus.ACCEPTED);
    }


}
