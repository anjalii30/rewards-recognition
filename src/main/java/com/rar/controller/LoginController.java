package com.rar.controller;

import com.rar.config.JwtRequest;
import com.rar.config.JwtTokenUtil;
import com.rar.model.DAOUser;
import com.rar.repository.DAOUserRepository;
import com.rar.service.JwtUserDetailsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

@CrossOrigin
@RestController
@EnableAutoConfiguration
@RequestMapping
@Api(value="Rewards And Recognition", description="Controller for registering and authenticating")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    DAOUserRepository daoUserRepository;


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
}
