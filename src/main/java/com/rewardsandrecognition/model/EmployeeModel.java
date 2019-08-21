package com.rewardsandrecognition.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "employee")
public class EmployeeModel implements Serializable {

    @Id
    @Column(name = "employeeid")
    private int employeeid;
    @Column(name = "employeename")
    private String employeename;

    public int getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(int employeeid) {
        this.employeeid = employeeid;
    }

    public String getEmployeename() {
        return employeename;
    }

    public void setEmployeename(String employeename) {
        this.employeename = employeename;
    }

    @Override
    public String toString() {
        return "EmployeeModel{" +
                "employeeid=" + employeeid +
                ", employeename='" + employeename + '\'' +
                '}';
    }
}

