package com.rar.controller;

import com.rar.repository.NominateRepository;
import com.rar.service.NominateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
    private NominateService snservice;

    @Autowired
    NominateRepository sampleNominaterepository;

    /**
     *
     * @param projectname (Project name)
     * @param reward_name (Reward name)
     * @return nominations count for the given project and reward
     */
    @ApiOperation(value = "Getting the count of nominations on selecting project names and reward names")
    @GetMapping("/list/{projectname}/{reward_name}")
    public String findByproject(@ApiParam(value = "Project name from which count of nominations will retrieve",required = true) @PathVariable String projectname,
                               @ApiParam(value = "Reward name from which count of nominations will retrieve",required = true) @PathVariable String reward_name,
                                @RequestHeader (value="Authorization") String token){
        return snservice.findByproject(projectname, reward_name);
    }

    /**
     *
     * @param request (mapped object)
     * @return array of track  reward, project and value of count
     */
    @ApiOperation(value = "Fetching selected rewards and projects ")
    @PostMapping("/getRewardAndProject")
    public Object findByrewardproject(@ApiParam(value="Taking reward and project name in array format",required = true)@RequestBody Map<String,Object> request,
                                      @RequestHeader (value="Authorization") String token){
        System.out.println(request);
        String[] r=request.get("r").toString().replace("[", "").replace("]","").split(",");
        String[] p=request.get("p").toString().replace("[", "").replace("]","").split(",");
        return snservice.findByrewardproject(r,p);
    }
}
