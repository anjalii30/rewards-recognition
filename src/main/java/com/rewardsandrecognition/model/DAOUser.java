package com.rewardsandrecognition.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
@ApiModel(description = "All details about User ")
public class DAOUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated awarded ID")
    private long id;
    @Column
    @ApiModelProperty(notes = "Username")
    private String username;
    @Column
    //@JsonIgnore
    @ApiModelProperty(notes = "Password")
    private String password;
    @Column(name="role")
    @ApiModelProperty(notes = "User role by default 'employee'")
    private String role="employee";
    @OneToMany(fetch = FetchType.LAZY,mappedBy="emp_id")
    @ApiModelProperty(notes = "user_id mapped to project table")
    private Set<ProjectModel> emp_id;

    public DAOUser() {
    }

    public DAOUser(long id, String username, String password, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        //this.emp_id=emp_id;

       //this.projects = projects;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }}
