package com.study.homework2.controller;

import com.study.homework2.dao.StreetDao;
import com.study.homework2.entity.Street;
import com.study.homework2.entity.Town;
import lombok.AllArgsConstructor;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/streets")
@AllArgsConstructor
public class StreetController {

    private StreetDao streetDao;

    @PostMapping
    public ResponseEntity<Street> saveStreet(@RequestBody Street street){

        street = streetDao.save(street);
        return new ResponseEntity<>(street,HttpStatus.ACCEPTED);
    }

    @PostMapping("update/{id}/{newStreet}")
    public ResponseEntity<Street> updateStreet(@RequestParam long id, String newStreet){

        Street street =streetDao.findById(id).orElseThrow();
        street.setName(newStreet);
        streetDao.save(street);

        return new ResponseEntity<>(street,HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Street> findByStreetId(@RequestParam long id){

        Street street =streetDao.findById(id).orElseThrow();


        return new ResponseEntity<>(street,HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity findAll(){

        List<Street> streetList = streetDao.findAll();

        return new ResponseEntity<>(streetList,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){

        try{
            streetDao.deleteById(id);
            return ResponseEntity.noContent().build();

        }catch (EmptyResultDataAccessException e){

            return ResponseEntity.notFound().build();
        }


    }


}
