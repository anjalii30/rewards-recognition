package com.rewardsandrecognition.controller;


import com.rewardsandrecognition.config.JwtTokenUtil;
import com.rewardsandrecognition.model.*;
import com.rewardsandrecognition.repository.AwardedRepository;
import com.rewardsandrecognition.repository.DAOUserRepository;
/*
import com.rewardsandrecognition.repository.ReportRepository;
*/
import com.rewardsandrecognition.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@EnableAutoConfiguration
@RequestMapping
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

  /*  @Autowired
    private
    ReportRepository reportRepository;
    @Autowired
    ReportService reportService;*/

  @Autowired
    AwardedRepository awardedRepository;

    @Autowired
    DAOUserRepository daoUserRepository;




    @Autowired
    private NServices nServices;

    @Autowired
    SampleNominateService snservice;





    @PostMapping("/save")
    public Createreward save(@RequestBody Createreward createreward){
        service.saveOrUpdate(createreward);
        return createreward;
    }


    @PutMapping("/update/{id}")
    public Createreward Update(@PathVariable Long id,@RequestBody Createreward createreward){
        return service.Update(id, createreward);

    }

    @PutMapping("/updateAwardStatus/{id}")
    public Createreward updateAwardStatus(@PathVariable Long id,@RequestBody Createreward createreward){
        return service.updateAwardStatus(id, createreward);

    }

    @GetMapping("/Rolledlist")
    public List<Createreward> findByRolled(){
        return service.findByRolled();
    }

    @GetMapping("/NominationClosed")
    public List<Createreward> findByNominationClosed(){
        return service.findByNominationClosed();
    }

    @GetMapping("/Discontinued")
    public List<Createreward> findByDiscontinued(){
        return service.findByDiscontinued();
    }

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

    /*------- Login Controller here onwards----*/



    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
       /* System.out.println(token);
        String s[]=new String[2];
        s[0]=token;
        String  username = userDetails.getUsername();
        String role=  daoUserRepository.findRoleByUserName(username);
        s[1]=role;


       *//* System.out.println(role);
        System.out.println(s[0]+s[1]);
       *//*
       return ResponseEntity.ok(s);*/
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


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
        return ResponseEntity.ok(userDetailsService.save(user));
    }





    /*------Report Controller here onwards---- */


    @GetMapping("/reports/years")
    public List getAllYears(){
        List years= awardedRepository.getAllYears();
        return years;
    }


    @GetMapping("/reports/{year}")
    public Object getReport(@PathVariable Long year){
        Object report = awardedService.getReport(year);
        return report;
    }

    /*------ nominate and drop down  controller here onwards------*/

    @GetMapping(value = "/trail/load/{projectname}")
    public List<String> load(@PathVariable String projectname) {
        System.out.println(projectname);
        List<String> users = nServices.getEmployeeByProject(projectname);
        return users;
    }

    @GetMapping("/trail/projectlist")
    public List getProjectsList() {
        return (List) nServices.getProjectsList();
    }

    @PostMapping("/trail/save")
    public Samplenominate save(@RequestBody Samplenominate samplenominate) {
        snservice.save(samplenominate);
        return samplenominate;
    }

    @PostMapping("/projects")
    public ProjectModel getProjects(@RequestBody ProjectModel projectModel){
        //  String username=projectModelService.tokendecoder(token);
        System.out.println(projectModel);
        nServices.getProjects(projectModel);
        return projectModel;

    }

    /*-------AWARDED--------*/

    @PostMapping("/awardedSave")
    public Awarded save(@RequestBody Awarded awarded){
        awardedService.save(awarded);
        return awarded;
    }


    @PutMapping("/awardedUpdate/{id}")
    public Awarded Update(@PathVariable Long id,@RequestBody Awarded awarded){
        return awardedService.Update(id, awarded);

    }

   /* @GetMapping("/awardedList")
    public List<Awarded> awardedList(){
        return awardedService.getALLAwarded();
    }
*/
    @GetMapping("/awardedList/{id}")
    public Awarded getByAwardedId(@PathVariable Long id){
        return awardedService.getByAwardedId(id);
    }

    @DeleteMapping("/awardedDelete/{id}")
    public String  deleteAwarded(@PathVariable Long id){
        awardedService.deleteAwarded(id);
        return "Deleted Successfully id="+id;
    }

    @GetMapping("/awardedList")
    public Object awardedList(){
        Object awarded= awardedService.awardedList();
        return awarded;
    }



    // track

    @GetMapping("/list/{projectname}/{reward_name}")
    public long findByproject(@PathVariable String projectname, @PathVariable String reward_name){
        return snservice.findByproject(projectname, reward_name);
    }

    @PostMapping("/getRewardAndProject")
    public Object findByrewardproject(@RequestBody Map<String,Object> request){
        System.out.println(request);
        String[] r=request.get("r").toString().replace("[", "").replace("]","").split(",");
        String[] p=request.get("p").toString().replace("[", "").replace("]","").split(",");
        return snservice.findByrewardproject(r,p);
    }

}
