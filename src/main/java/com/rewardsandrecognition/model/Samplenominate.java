package com.rewardsandrecognition.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "nominations")
@ApiModel(description = "All details about Nominations ")
public class Samplenominate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "The database generated awarded ID")
    private Long Sno;
    @Column(name = "projectname",updatable = false,nullable = false)
    @ApiModelProperty(notes = "Project in which nominated employee is working ")
    private String projectname;
    @Column(name = "employeename")
    @ApiModelProperty(notes = "Employee who is getting nominated")
    private String Employeename;
    @Column(name = "Description")
    @ApiModelProperty(notes = "Description of why nominate this person")
    private String Description;
    @Column(name= "reward_name")
    @ApiModelProperty(notes = "Reward for which someone is nominated")
    private String reward_name;
    @ApiModelProperty(notes = "Disable nominate so that only one employee can be nominated for a reward")
    private boolean isDisable=false;

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getEmployeename() {
        return Employeename;
    }

    public void setEmployeename(String employeename) {
        Employeename = employeename;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }


    public String getReward_name() {
        return reward_name;
    }

    public void setReward_name(String reward_name) {
        this.reward_name = reward_name;
    }

    public boolean isDisable(boolean b) {
        return isDisable;
    }

    public void setDisable(boolean disable) {
        isDisable = disable;
    }
}
