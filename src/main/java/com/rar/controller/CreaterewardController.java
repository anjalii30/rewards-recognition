package com.rar.controller;


import com.rar.model.Createreward;
import com.rar.repository.CreaterewardRepository;
import com.rar.service.CreaterewardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@EnableAutoConfiguration
@RequestMapping
@Api(value="Rewards And Recognition", description="Controller for rewards created")
public class CreaterewardController {

    @Autowired
    CreaterewardService service;


    @Autowired
    CreaterewardRepository createrewardRepository;




    @ApiOperation(value = "Create a reward")
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Createreward createreward){
        Date edate = createreward.getEnding_date();
        Date sdate = createreward.getStarting_date();
        if(edate.compareTo(sdate)>0) {
            createrewardRepository.save(createreward);
            return  ResponseEntity.ok(createreward);
        }
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);

    }

    @ApiOperation(value = "Update a created reward by its id")
    @PutMapping("/update/{id}")
    public Createreward Update(@PathVariable Long id, @RequestBody Createreward createreward){
        return service.Update(id, createreward);
    }

    @ApiOperation(value = "Update award status (created/rolled out/nomination closed/discontinued)")
    @PutMapping("/updateAwardStatus/{id}")
    public Createreward updateAwardStatus(@PathVariable Long id, @RequestBody Createreward createreward){
        return service.updateAwardStatus(id, createreward);
    }

    @ApiOperation(value = "Show the rolled out rewards list")
    @GetMapping("/Rolledlist")
    public List<Createreward> findByRolled() {

     
            return createrewardRepository.findByRolled();

    }

    @ApiOperation(value = "Show the list of rewards for which nomination has been closed")
    @GetMapping("/NominationClosed")
    public List<Createreward> findByNominationClosed(){
        return createrewardRepository.findByNominationClosed();
    }

    @ApiOperation(value = "Show the discontinued rewards list")
    @GetMapping("/Discontinued")
    public List<Createreward> findByDiscontinued(){
        return createrewardRepository.findByDiscontinued();
    }

    @ApiOperation(value = "Show the list of all the rewards")
    @GetMapping("/list")
    public List<Createreward> list(){
        return (List<Createreward>) createrewardRepository.findAll();
    }

    @ApiOperation(value = "Show the list of rewards by their id")
    @GetMapping("/list/{id}")
    public Optional<Createreward> getById(@PathVariable Long id){
        return createrewardRepository.findById(id);
    }
 @ApiOperation(value = "Delete reward of a particular id")
    @DeleteMapping("/delete/{id}")
    public String  deleteCreatereward(@PathVariable Long id){
        createrewardRepository.deleteById(id);
        return "Deleted Succcessfully id="+id;
    }



}
