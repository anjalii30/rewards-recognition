package com.rewardsandrecognition.controller;


import com.rewardsandrecognition.config.JwtRequest;
import com.rewardsandrecognition.config.JwtTokenUtil;
import com.rewardsandrecognition.model.*;
import com.rewardsandrecognition.repository.AwardedRepository;
import com.rewardsandrecognition.repository.DAOUserRepository;
import com.rewardsandrecognition.repository.ProjectRepository;
import com.rewardsandrecognition.repository.SampleNominaterepository;
import com.rewardsandrecognition.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@EnableAutoConfiguration
@RequestMapping
@Api(value="Rewards And Recognition", description="Rewards And Recognition")
public class CreaterewardController {

    @Autowired
    CreaterewardService service;

    @Autowired
    AwardedService awardedService;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private JwtUserDetailsService userDetailsService;

  @Autowired
    AwardedRepository awardedRepository;

    @Autowired
    DAOUserRepository daoUserRepository;



    @Autowired
    private NServices nServices;

    @Autowired
    SampleNominateService snservice;

    @Autowired
    SampleNominaterepository sampleNominaterepository;


    @Autowired
    ProjectRepository projectRepository;




    @ApiOperation(value = "Create a reward")
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Createreward createreward){
        Date edate = createreward.getEnding_date();
        Date sdate = createreward.getStarting_date();
        if(edate.compareTo(sdate)>0) {
            service.saveOrUpdate(createreward);
            return  ResponseEntity.ok(createreward);
        }
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);

    }

    @ApiOperation(value = "Update a created reward by its id")
    @PutMapping("/update/{id}")
    public Createreward Update(@PathVariable Long id,@RequestBody Createreward createreward){
        return service.Update(id, createreward);

    }
    @ApiOperation(value = "Update award status (created/rolled out/nomination closed/discontinued)")
    @PutMapping("/updateAwardStatus/{id}")
    public Createreward updateAwardStatus(@PathVariable Long id,@RequestBody Createreward createreward){
        return service.updateAwardStatus(id, createreward);

    }
    @ApiOperation(value = "Show the rolled out rewards list")
    @GetMapping("/Rolledlist")
    public List<Createreward> findByRolled() {
        Samplenominate samplenominate=new Samplenominate();
        if (samplenominate.isDisable(false))
            return service.findByRolled();
        else {
            Createreward createreward=new Createreward();
            createreward.setAward_status(2);
            return service.findByRolled();
        }
    }
    @ApiOperation(value = "Show the list of rewards for which nomination has been closed")
    @GetMapping("/NominationClosed")
    public List<Createreward> findByNominationClosed(){
        return service.findByNominationClosed();
    }
    @ApiOperation(value = "Show the discontinued rewards list")
    @GetMapping("/Discontinued")
    public List<Createreward> findByDiscontinued(){
        return service.findByDiscontinued();
    }
    @ApiOperation(value = "Show the list of all the rewards")
    @GetMapping("/list")
    public List<Createreward> list(){
        return service.getALLCreatereward();
    }
 /*   @ApiOperation(value = "Show the list of rewards by their id")
    @GetMapping("/list/{id}")
    public Createreward getById(@PathVariable Long id){
        return service.getById(id);
    }*/
 @ApiOperation(value = "Delete reward of a particular id")
    @DeleteMapping("/delete/{id}")
    public String  deleteCreatereward(@PathVariable Long id){
        service.deleteCreatereward(id);
        return "Deleted Succcessfully id="+id;
    }

    /*------- Login Controller here onwards----*/


    @ApiOperation(value = "Authenticate username and password and generate JWT token along with role of the user")
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);

        String  username = userDetails.getUsername();
        String role=  daoUserRepository.findRoleByUserName(username);
        HashMap<String, String> s = new HashMap<String, String>();
        s.put("token",token);
        s.put("role",role);
       Object send=  s ;
        return ResponseEntity.ok(send);
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    @ApiOperation(value = "registering user by username and password and by default role is 'employee'")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody DAOUser user) throws Exception {
        return ResponseEntity.ok(userDetailsService.save(user));
    }





    /*------Report Controller here onwards---- */

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

    /*------ nominate and drop down  controller here onwards------*/

    @ApiOperation(value = "get employees list for the particular project")
    @GetMapping(value = "/trail/load/{projectname}")
    public List<String> load(@PathVariable String projectname) {
        System.out.println(projectname);
        List<String> users = nServices.getEmployeeByProject(projectname);
        return users;
    }

    @ApiOperation(value = "returns the list of projects")
    @GetMapping("/trail/projectlist")
    public List getProjectsList() {
        return (List) nServices.getProjectsList();
    }

    @ApiOperation(value = "get the nomination data and disable it once nominated")
    @PostMapping("/trail/save")
    public Samplenominate save(@RequestBody Samplenominate samplenominate) {
        snservice.save(samplenominate);
        samplenominate.setDisable(true);
        return samplenominate;
    }
    @ApiOperation(value = "create project and assign employees ")
    @PostMapping("/projects")
    public ProjectModel getProjects(@RequestBody ProjectModel projectModel){
        //  String username=projectModelService.tokendecoder(token);
        System.out.println(projectModel);
        nServices.getProjects(projectModel);
        return projectModel;

    }

    /*-------AWARDED--------*/

    @ApiOperation(value = "save the data for awarded persons")
    @PostMapping("/awardedSave")
    public Awarded save(@RequestBody Awarded awarded){
        awardedService.save(awarded);
        return awarded;
    }

    @ApiOperation(value = "update the awarded data")
    @PutMapping("/awardedUpdate/{id}")
    public Awarded Update(@PathVariable Long id,@RequestBody Awarded awarded){
        return awardedService.Update(id, awarded);

    }
    @ApiOperation(value = "show the awarded list")
    @GetMapping("/awardedList")
    public List<Awarded> awardedList(){
        return awardedService.getALLAwarded();
    }
    @ApiOperation(value = "show the awarded data by id")
    @GetMapping("/awardedList/{id}")
    public Awarded getByAwardedId(@PathVariable Long id){
        return awardedService.getByAwardedId(id);
    }
    @ApiOperation(value = "delete the awarded data by id")
    @DeleteMapping("/awardedDelete/{id}")
    public String  deleteAwarded(@PathVariable Long id){
        awardedService.deleteAwarded(id);
        return "Deleted Successfully id="+id;
    }

    @ApiOperation(value = "showing employee image,reward name, description for employee home page ")
    @GetMapping("/employeehomepage")
    public Object ehomepage(){
        Object awarded= awardedService.ehomepage();
        return awarded;
    }



    /*-----------track controller here onwards------------*/

    @ApiOperation(value = "getting the count of nominations on selecting project names and reward names")
    @GetMapping("/list/{projectname}/{reward_name}")
    public long findByproject(@PathVariable String projectname, @PathVariable String reward_name){
        return snservice.findByproject(projectname, reward_name);
    }

    @ApiOperation(value = "fetching selected rewards and projects ")
    @PostMapping("/getRewardAndProject")
    public Object findByrewardproject(@RequestBody Map<String,Object> request){
        System.out.println(request);
        String[] r=request.get("r").toString().replace("[", "").replace("]","").split(",");
        String[] p=request.get("p").toString().replace("[", "").replace("]","").split(",");
        return snservice.findByrewardproject(r,p);
    }

    /*@ApiOperation(value = "display project names from nomination tables")
    @GetMapping("/track")
    public List<Samplenominate> tracklist(){
        return  sampleNominaterepository.tracklist();
    }
*/

}
