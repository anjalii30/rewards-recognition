package com.rewardsandrecognition.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name= "report")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="rewardName")
    @NotBlank
    private String rewardName;

    @Column(name="frequency")
    @NotBlank
    private String frequency;

    @Column(name="empId")
    @NotBlank
    private String empId;

    @Column(name="year")
    @NotBlank
    private Long year;

    public Report() {
    }

    public Report(Long id, @NotBlank String rewardName, @NotBlank String frequency, @NotBlank String empId, @NotBlank Long year) {
        this.id = id;
        this.rewardName = rewardName;
        this.frequency = frequency;
        this.empId = empId;
        this.year=year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRewardName() {
        return rewardName;
    }

    public void setRewardName(String rewardName) {
        this.rewardName = rewardName;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }
}
