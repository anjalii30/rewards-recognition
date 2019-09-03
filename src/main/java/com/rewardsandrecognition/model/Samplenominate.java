package com.rewardsandrecognition.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "nominations")
public class Samplenominate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Sno;
    @Column(name = "projectname",updatable = false,nullable = false)
    private String projectname;
    @Column(name = "employeename")
    private String Employeename;
    @Column(name = "Description")
    private String Description;
    @Column(name= "reward_name")
    private String reward_name;
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

    public boolean isDisable() {
        return isDisable;
    }

    public void setDisable(boolean disable) {
        isDisable = disable;
    }
}
