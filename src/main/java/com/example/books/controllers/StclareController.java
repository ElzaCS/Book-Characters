package com.example.books.controllers;

import com.example.books.models.Famous5;
import com.example.books.models.Stclare;
import com.example.books.repositories.StclareRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stclare")
public class StclareController {
    @Autowired
    private StclareRepository stclareRepository;

    @GetMapping
    public List<Stclare> list() {
        return stclareRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Stclare get(@PathVariable Long id) {
        return stclareRepository.getOne(id);
    }

    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED)
    public Stclare create(@RequestBody Stclare stclare){
        return stclareRepository.saveAndFlush(stclare);
    }
    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        //wont delete children records
        stclareRepository.deleteById(id);
    }
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Stclare update(@PathVariable Long id,@RequestBody Stclare stclare){
        Stclare existingStclare=stclareRepository.getOne(id);
        BeanUtils.copyProperties(stclare, existingStclare, "id");
        return stclareRepository.saveAndFlush(existingStclare);
    }
}
