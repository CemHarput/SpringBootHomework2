package com.study.homework2.controller;


import com.study.homework2.dao.TownDao;
import com.study.homework2.entity.Town;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/towns")
@AllArgsConstructor
public class TownController {

    private TownDao townDao;

    @PostMapping
    public ResponseEntity<Town> saveTown(@Valid @RequestBody Town town){
        town = townDao.save(town);
        return new ResponseEntity<>(town, HttpStatus.ACCEPTED);

    }

    @PostMapping("update/{id}/{newTown}")
    public ResponseEntity<Town> updateTown(@RequestParam long id,String newTown){
        Town town = townDao.findById(id).orElseThrow();
        town.setName(newTown);
        townDao.save(town);

        return new ResponseEntity<>(town,HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity findAll(){

        List<Town> townList = townDao.findAll();

        return new ResponseEntity<>(townList,HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){

        try{
            townDao.deleteById(id);
            return ResponseEntity.noContent().build();

        }catch (EmptyResultDataAccessException e){

            return ResponseEntity.notFound().build();
        }


    }

}
