package com.rar.controller;

import com.rar.model.Awarded;
import com.rar.repository.AwardedRepository;
import com.rar.service.AwardedService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@EnableAutoConfiguration
@RequestMapping
@Api(value="Rewards And Recognition", description="Controller for awarded data")
public class AwardedController {
    @Autowired
    private AwardedService awardedService;

    @Autowired
    private AwardedRepository awardedRepository;

    @ApiOperation(value = "save the data for awarded persons")
    @PostMapping("/awardedSave")
    public Awarded save(@RequestBody Awarded awarded){
        awardedRepository.save(awarded);
        return awarded;
    }

    /*@ApiOperation(value = "update the awarded data")
    @PutMapping("/awardedUpdate/{id}")
    public Awarded Update(@PathVariable Long id, @RequestBody Awarded awarded){
        return awardedService.Update(id, awarded);

    }*/
    @ApiOperation(value = "show the awarded list")
    @GetMapping("/awardedList")
    public List<Awarded> awardedList(){
        return (List<Awarded>) awardedRepository.findAll();
    }
    @ApiOperation(value = "show the awarded data by id")
    @GetMapping("/awardedList/{id}")
    public Optional<Awarded> getByAwardedId(@PathVariable Long id){
        return awardedRepository.findById(id);
    }
    /*@ApiOperation(value = "delete the awarded data by id")
    @DeleteMapping("/awardedDelete/{id}")
    public String  deleteAwarded(@PathVariable Long id){
        awardedRepository.deleteById(id);
        return "Deleted Successfully id="+id;
    }*/

    @ApiOperation(value = "showing employee image,reward name, description for employee home page ")
    @GetMapping("/employeehomepage")
    public Object ehomepage(){
        Object awarded= awardedService.ehomepage();
        return awarded;
    }
}
