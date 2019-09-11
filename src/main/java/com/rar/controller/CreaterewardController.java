package com.rar.controller;


import com.rar.model.Createreward;
import com.rar.repository.CreaterewardRepository;
import com.rar.service.CreaterewardService;
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
@Api(value="Rewards And Recognition", description="Controller for rewards created")
public class CreaterewardController {

    @Autowired
    private CreaterewardService service;


    @Autowired
    private CreaterewardRepository createrewardRepository;


    /**
     *
     * @param createreward (reward object)
     * @return created reward data
     */
    @ApiOperation(value = "Create a reward")
    @PostMapping("/save")
    public Createreward save(@ApiParam(value="Reward store in a database table",required = true)
            @RequestBody Createreward createreward, @RequestHeader (value="Authorization") String token){

        return service.save(createreward);
    }

    /**
     *
     * @param id (reward id)
     * @param createreward (reward object)
     * @return updated reward data of the given id
     */
    @ApiOperation(value = "Update a created reward by its id")
    @PutMapping("/update/{id}")
    public Createreward Update(@ApiParam (value="Reward Id to update reward", required = true)
            @PathVariable Long id,@ApiParam(value="update reward")
                               @RequestBody Createreward createreward,@RequestHeader (value="Authorization") String token){
        return service.Update(id, createreward);
    }

    /**
     *
     * @param id (reward id)
     * @param createreward (reward object)
     * @return update award status  for the given reward id
     */
    @ApiOperation(value = "Update award status (created/rolled out/nomination closed/discontinued)")
    @PutMapping("/updateAwardStatus/{id}")
    public Createreward updateAwardStatus(@ApiParam (value="Reward Id to update reward status", required = true)@PathVariable Long id,
                                          @ApiParam(value="update reward status") @RequestBody Createreward createreward,
                                          @RequestHeader (value="Authorization") String token){
        return service.updateAwardStatus(id, createreward);
    }

    /**
     *
     * @return list of rolled out rewards
     */
    @ApiOperation(value = "Show the rolled out rewards list",response = List.class)
    @GetMapping("/Rolledlist")
    public List<Createreward> findByRolled(@RequestHeader (value="Authorization") String token) {

            return service.findByRolled();

    }

    /**
     *
     * @return list of nomination closed rewards
     */
    @ApiOperation(value = "Show the list of rewards for which nomination has been closed",response = List.class)
    @GetMapping("/NominationClosed")
    public List<Createreward> findByNominationClosed(@RequestHeader (value="Authorization") String token)
    {
        return service.findByNominationClosed();
    }

    /**
     *
     * @return list of discontinued rewards
     */
    @ApiOperation(value = "Show the discontinued rewards list",response = List.class)
    @GetMapping("/Discontinued")
    public List<Createreward> findByDiscontinued(@RequestHeader (value="Authorization") String token)
    {
        return service.findByDiscontinued();
    }

    /**
     *
     * @return list of all the rewards
     */
    @ApiOperation(value = "Show the list of all the rewards",response = List.class)
    @GetMapping("/list")
    public List<Createreward> list(@RequestHeader (value="Authorization") String token){

        return (List<Createreward>) service.findAll();
    }

    /**
     *
     * @param id (reward id)
     * @return reward of the given id
     */
    @ApiOperation(value = "Show the reward by the id")
    @GetMapping("/list/{id}")
    public Optional<Createreward> getById(@ApiParam(value = "Reward id from which reward object will retrieve",required = true)
                                              @PathVariable Long id,@RequestHeader (value="Authorization") String token){

        return service.findById(id);
    }

    /**
     *
     * @param id (reward id)
     * @return delete message with id given
     */
 @ApiOperation(value = "Delete reward of a particular id")
    @DeleteMapping("/delete/{id}")
    public String  deleteCreatereward(@ApiParam(value = "Reward Id from which reward object will delete from database table", required = true)
                                       @PathVariable Long id,@RequestHeader (value="Authorization") String token){
        service.deleteById(id);
        return "Deleted Succcessfully id="+id;
    }



}
