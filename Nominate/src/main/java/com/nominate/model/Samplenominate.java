package com.nominate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "nominations")
public class Samplenominate implements Serializable {

    @Id
    @Column(name = "rewardID",updatable = false,nullable = false)
    private String rewardID;
    @Column(name = "projectname",updatable = false,nullable = false)
    private String projectname;
    @Column(name = "EmployeeID")
    private String EmployeeID;
    @Column(name = "Employeename")
    private String Employeename;
    @Column(name = "startingdate")
    private String startingdate;
    @Column(name = "enddate")
    private String enddate;
    @Column(name = "Description")
    private String Description;

    public String getRewardID() {
        return rewardID;
    }

    public void setRewardID(String rewardID) {
        this.rewardID = rewardID;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(String employeeID) {
        EmployeeID = employeeID;
    }

    public String getEmployeename() {
        return Employeename;
    }

    public void setEmployeename(String employeename) {
        Employeename = employeename;
    }

    public String getStartingdate() {
        return startingdate;
    }

    public void setStartingdate(String startingdate) {
        this.startingdate = startingdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    @Override
    public String toString() {
        return "Samplenominate{" +
                "rewardID='" + rewardID + '\'' +
                ", projectname='" + projectname + '\'' +
                ", EmployeeID='" + EmployeeID + '\'' +
                ", Employeename='" + Employeename + '\'' +
                ", startingdate='" + startingdate + '\'' +
                ", enddate='" + enddate + '\'' +
                ", Description='" + Description + '\'' +
                '}';
    }
}
