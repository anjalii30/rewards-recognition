package com.rewardsandrecognition.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;


@CrossOrigin
@Entity
@Table(name = "awarded")
@EntityListeners(AuditingEntityListener.class)
public class Awarded implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long awarded_id;

    @Column(name = "Reward_Name")
    private String reward_name;

    @Column(name = "Frequency")
    private String frequency;

    @Column(name = "Employee_id")
    private String emp_id;

    @Column(name = "Year")
    private String year;

    @Column(name = "Employee_name")
    private String employee_name;

    @Column(name = "Project_name")
    private String project_name;

    @Column(name = "subjectDescription")
    private String subjectDescription;

    @Column(name = "Employee_image")
    private String employee_image;


    public Awarded() {
    }

    public long getAwarded_id() {
        return awarded_id;
    }

    public void setAwarded_id(long awarded_id) {
        this.awarded_id = awarded_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_idname) {
        this.employee_name = employee_idname;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getSubjectDescription() {
        return subjectDescription;
    }

    public void setSubjectDescription(String subjectDescription) {
        this.subjectDescription = subjectDescription;
    }

    public String getEmployee_image() {
        return employee_image;
    }

    public void setEmployee_image(String employee_image) {
        this.employee_image = employee_image;
    }

    @Override
    public String toString() {
        return "Awarded{" +
                "awarded_id=" + awarded_id +
                ", reward_name='" + reward_name + '\'' +
                ", frequency='" + frequency + '\'' +
                ", emp_id='" + emp_id + '\'' +
                ", year='" + year + '\'' +
                ", employee_name='" + employee_name + '\'' +
                ", project_name='" + project_name + '\'' +
                ", subjectDescription='" + subjectDescription + '\'' +
                ", employee_image='" + employee_image + '\'' +
                '}';
    }

    public String getReward_name() {
        return reward_name;
    }

    public void setReward_name(String reward_name) {
        this.reward_name = reward_name;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }


}
