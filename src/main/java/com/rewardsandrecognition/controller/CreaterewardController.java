package com.rewardsandrecognition.controller;


import com.rewardsandrecognition.model.Createreward;
import com.rewardsandrecognition.service.CreaterewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/RAR")
public class CreaterewardController {

    @Autowired
    CreaterewardService service;


    @PostMapping("/save")
    public Createreward save(@RequestBody Createreward createreward){
        service.saveOrUpdate(createreward);
        return createreward;
    }


    @PutMapping("/update/{id}")
    public Createreward Update(@PathVariable Long id,@RequestBody Createreward createreward){
        return service.Update(id, createreward);

    }


   /* @PutMapping("/process")
    public void process(@RequestBody Createreward[] payload)
            throws Exception {

       return service.payload;

    }*/


    @GetMapping("/list")
    public List<Createreward> list(){
        return service.getALLCreatereward();
    }

    @GetMapping("/list/{id}")
    public Createreward getById(@PathVariable Long id){
        return service.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String  deleteCreatereward(@PathVariable Long id){
        service.deleteCreatereward(id);
        return "Deleted Succcessfully id="+id;
    }

}
