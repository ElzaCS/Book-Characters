package com.example.books.controllers;

import com.example.books.repositories.Famous5Repository;
import com.example.books.models.Famous5;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/famous5")
public class Famous5Controller {
    @Autowired
    private Famous5Repository famous5Repository;

    @GetMapping
    public List<Famous5> list() {
        return famous5Repository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Famous5 get(@PathVariable Long id) {
        return famous5Repository.getOne(id);
    }

    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED)
    public Famous5 create(@RequestBody final Famous5 famous5){
        return famous5Repository.saveAndFlush(famous5);
    }
    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        //wont delete children records
        famous5Repository.deleteById(id);
    }
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Famous5 update(@PathVariable Long id,@RequestBody Famous5 famous5){
        Famous5 existingFamous5=famous5Repository.getOne(id);
        BeanUtils.copyProperties(famous5, existingFamous5, "id");
        return famous5Repository.saveAndFlush(existingFamous5);
    }
}
