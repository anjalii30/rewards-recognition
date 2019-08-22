package com.rewardsandrecognition.controller;


import com.rewardsandrecognition.config.JwtTokenUtil;
import com.rewardsandrecognition.model.*;
import com.rewardsandrecognition.repository.ReportRepository;
import com.rewardsandrecognition.service.CreaterewardService;
import com.rewardsandrecognition.service.JwtUserDetailsService;
import com.rewardsandrecognition.service.SampleNominateService;
import com.rewardsandrecognition.service.Services;
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

    @GetMapping("/Rolled_list")
    public List<Createreward> findByRolled(){
        return service.findByRolled();
    }

    @GetMapping("/Nomination_Closed")
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


     @GetMapping("/reports")
    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

  /*  @GetMapping("/reports/{year}")
    public List<Report> getAllReports(@PathVariable Long year){
        return reportRepository.findAllByYear(year);
    }

    @GetMapping("/reports/{frequency}/{year}")
    public long findByFrequency(@PathVariable String frequency, @PathVariable Long year){
        return reportRepository.findByFrequency(frequency, year);
    }
*/


    @GetMapping("/reports/years")
    public List getAllYears(){
        List years= reportRepository.getAllYears();
        return years;
    }


   @GetMapping("/reports/people/{year}")
    public long findByPeople(@PathVariable Long year){
        long people= reportRepository.findByPeople(year);
        return people;
   }


   @GetMapping("/reports/rewards/{year}")
    public long findByRewards(@PathVariable Long year){
       long rewards =  reportRepository.findByRewards(year);
       return rewards;
       // return reportRepository.findByRewards(year);
   }


   @GetMapping("/reports/weekly/{year}")
    public long weeklyFrequency(@PathVariable Long year){

       long week= reportRepository.weeklyFrequency(year);
       return week;

   }

    @GetMapping("/reports/monthly/{year}")
    public long monthlyFrequency(@PathVariable Long year)
    {
        long month= reportRepository.monthlyFrequency(year);
        return month;
    }


    @GetMapping("/reports/quarterly/{year}")
    public long quarterlyFrequency(@PathVariable Long year){

       long quarter= reportRepository.quarterlyFrequency(year);
       return quarter;
    }

    @GetMapping("/reports/annually/{year}")
    public long annuallyFrequency(@PathVariable Long year){
        long annual= reportRepository.annuallyFrequency(year);
        return annual;
    }

    @GetMapping("/reports/spot/{year}")
    public long spotFrequency(@PathVariable Long year){
        long spot= reportRepository.spotFrequency(year);
        return spot;
    }

    /*------ nominate controleer here onwards------*/
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



    /*--------dropdown---*/
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
