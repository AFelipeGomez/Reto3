package com.skate.controller;

import com.skate.model.Skate;
import com.skate.service.SkateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("/Skate")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class SkateController{

    @Autowired
    private SkateService skateSerivice;
    @GetMapping("/all")
    public List<Skate> getAll(){
        return skateSerivice.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Skate> getSkate(@PathVariable int id){
        return skateSerivice.getSkate(id);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Skate save(@RequestBody Skate skate) {
        return skateSerivice.save(skate);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteSkate(@PathVariable int id){
        return skateSerivice.deleteSkate(id);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Skate updateSkate(@RequestBody Skate skate){
        return skateSerivice.updateSkate(skate);
    }
}
