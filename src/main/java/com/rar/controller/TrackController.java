package com.rar.controller;

import com.rar.repository.SampleNominaterepository;
import com.rar.service.SampleNominateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@EnableAutoConfiguration
@RequestMapping
@Api(value="Rewards And Recognition", description="Controller for tracking nomination info")
public class TrackController {

    @Autowired
    SampleNominateService snservice;

    @Autowired
    SampleNominaterepository sampleNominaterepository;

    @ApiOperation(value = "getting the count of nominations on selecting project names and reward names")
    @GetMapping("/list/{projectname}/{reward_name}")
    public String findByproject(@PathVariable String projectname, @PathVariable String reward_name){
        return sampleNominaterepository.findByproject(projectname, reward_name);
    }

    @ApiOperation(value = "fetching selected rewards and projects ")
    @PostMapping("/getRewardAndProject")
    public Object findByrewardproject(@RequestBody Map<String,Object> request){
        System.out.println(request);
        String[] r=request.get("r").toString().replace("[", "").replace("]","").split(",");
        String[] p=request.get("p").toString().replace("[", "").replace("]","").split(",");
        return snservice.findByrewardproject(r,p);
    }
}
