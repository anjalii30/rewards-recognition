package com.nominate.controller;


import com.nominate.model.Samplenominate;
import com.nominate.service.SampleNominateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/practice")
public class SampleNominatecontroller {

    @Autowired
    SampleNominateService service;

    @PostMapping("/save")
    public Samplenominate Save(@RequestBody Samplenominate samplenominate) {
        service.save(samplenominate);
        return samplenominate;
    }

    @GetMapping("/list")
    public List<Samplenominate> list() {
        return service.getALLSamplenominate();
    }

    @GetMapping("/list/{rewardID}")
    public Samplenominate getById(@PathVariable String rewardID) {
        return service.getById(rewardID);
    }
}
