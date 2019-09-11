package com.rar.controller;

import com.rar.model.Awarded;
import com.rar.repository.AwardedRepository;
import com.rar.service.AwardedService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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

    /**
     *
     * @param awarded (awarded object)
     * @return saved awarded data
     */
    @ApiOperation(value = "save the data for awarded persons")
    @PostMapping("/awardedSave")
    public Awarded save(@ApiParam(value="Awarded object store in database table", required = true) @RequestBody Awarded awarded,
                        @RequestHeader (value="Authorization") String token){
        awardedService.save(awarded);
        return awarded;
    }


    /**
     *
     * @param id (awarded id)
     * @param awarded (awarded object)
     * @return updated awarded data of the given awarded id
     */
    @ApiOperation(value = "update the awarded data")
    @PutMapping("/awardedUpdate/{id}")
    public Awarded Update(@ApiParam(value = "Awarded Id to update awarded object", required = true)@PathVariable Long id,
                          @ApiParam(value = "Update awarded object", required = true)@RequestBody Awarded awarded,
                          @RequestHeader (value="Authorization") String token){
        return awardedService.Update(id, awarded);

    }

    /**
     *
     * @return list of awarded people
     */
    @ApiOperation(value = "show the awarded list",response = List.class)
    @GetMapping("/awardedList")
    public List<Awarded> awardedList(@RequestHeader (value="Authorization") String token){

        return (List<Awarded>) awardedService.findAll();
    }

    /**
     *
     *
     * @param id (awarded data id)
     * @return awarded people of the given id
     */
    @ApiOperation(value = "show the awarded data by id")
    @GetMapping("/awardedList/{id}")
    public Optional<Awarded> getByAwardedId(@ApiParam(value = "Awarded id from which awarded object will retrieve", required = true)@PathVariable Long id,
                                            @RequestHeader (value="Authorization") String token)
    {
        return awardedService.findById(id);
    }

    /**
     *
     * @param id (awarded id)
     * @return deleted award data
     */

    @ApiOperation(value = "delete the awarded data by id")
    @DeleteMapping("/awardedDelete/{id}")
    public String  deleteAwarded(@ApiParam(value = "Awarded Id from which awarded object will delete from database table", required = true)@PathVariable Long id){
        awardedRepository.deleteById(id);
        return "Deleted Successfully id="+id;
    }

    /**
     *
     * @return  timeline of all the awarded people
     */
    @ApiOperation(value = "showing employee image,reward name, description for employee home page ")
    @GetMapping("/employeehomepage")
    public Object ehomepage(){
        Object awarded= awardedService.ehomepage();
        return awarded;
    }

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
