package com.rewardsandrecognition.controller;


import com.rewardsandrecognition.config.JwtTokenUtil;
import com.rewardsandrecognition.model.*;
import com.rewardsandrecognition.repository.ReportRepository;
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

import java.util.List;

@CrossOrigin
@RestController
@EnableAutoConfiguration
@RequestMapping
public class CreaterewardController {

    @Autowired
    CreaterewardService service;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private
    ReportRepository reportRepository;
    @Autowired
    ReportService reportService;


    @Autowired
    private
    SampleNominateService nominateService;
    @Autowired
    private Services services;



    @PostMapping("/save")
    public Createreward save(@RequestBody Createreward createreward){
        service.saveOrUpdate(createreward);
        return createreward;
    }


    @PutMapping("/update/{id}")
    public Createreward Update(@PathVariable Long id,@RequestBody Createreward createreward){
        return service.Update(id, createreward);

    }


   /* @PutMapping("/process")
    public void process(@RequestBody Createreward[] payload)
            throws Exception {

       return service.payload;

    }*/


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
        return ResponseEntity.ok(new JwtResponse(token));
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
        List years= reportRepository.getAllYears();
        return years;
    }


    @GetMapping("/reports/{year}")
    public Object getReport(@PathVariable Long year){
        Object report = reportService.getReport(year);
        return report;
    }

    /*------ nominate controller here onwards------*/
    @PostMapping("/practice/save")
    public Samplenominate Save(@RequestBody Samplenominate samplenominate) {
        nominateService.save(samplenominate);
        return samplenominate;
    }

    @GetMapping("/practice/nominatelist")
    public List<Samplenominate> samplenominateListlist() {
        return nominateService.getALLSamplenominate();
    }

    @GetMapping("/practice/list/{rewardID}")
    public Samplenominate getById(@PathVariable String rewardID) {
        return nominateService.getById(rewardID);
    }



    /*--------dropdown controller here onwards---*/


    @RequestMapping(value = "/load/{projectname}", method = RequestMethod.GET)
    public @ResponseBody List<EmployeeModel> load(@PathVariable String projectname) {
        List<EmployeeModel> employees = services.getEmployeeByProject(projectname);

        return employees;
    }

    @GetMapping("/dlist")
    public List<ProjectModel> ddlist() {
        return services.getProjectsList();
    }
}
