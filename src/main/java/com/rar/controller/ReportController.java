package com.rar.controller;

import com.rar.repository.AwardedRepository;
import com.rar.service.AwardedService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@EnableAutoConfiguration
@RequestMapping
@Api(value="Rewards And Recognition", description="Controller of Report for awarded ")
public class ReportController {

    @Autowired
    AwardedService awardedService;

    @Autowired
    AwardedRepository awardedRepository;

    @ApiOperation(value = "returning the years for which report is there")
    @GetMapping("/reports/years")
    public List getAllYears(){
        List years= awardedRepository.getAllYears();
        return years;
    }

    @ApiOperation(value = "showing count of all the awarded people and rewards according to year")
    @GetMapping("/reports/{year}")
    public Object getReport(@PathVariable Long year){
        Object report = awardedService.getReport(year);
        return report;
    }

}
