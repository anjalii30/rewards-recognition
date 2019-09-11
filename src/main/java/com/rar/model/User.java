package com.rar.model;

import com.rar.enums.RoleEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
@ApiModel(description = "All details about User ")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated awarded ID")
    private long id;

    @Column
    @ApiModelProperty(notes = "Username")
    private String username;

    @Column
    @ApiModelProperty(notes = "Password")
    private String password;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(name="role")
    @ApiModelProperty(notes = "User role by default 'employee'")
    // private String role="employee";
    private RoleEnum role=RoleEnum.EMPLOYEE;

    @OneToMany(fetch = FetchType.LAZY,mappedBy="emp_id")
    @ApiModelProperty(notes = "user_id mapped to project table")
    private Set<Project> emp_id;

    public User() {
    }

    public User(long id, String username, String password, RoleEnum role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public RoleEnum getRole() {

        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

}

