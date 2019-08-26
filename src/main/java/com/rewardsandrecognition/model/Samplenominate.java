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

    @Override
    public String toString() {
        return "Samplenominate{" +
                ", projectname='" + projectname + '\'' +
                ", Employeename='" + Employeename + '\'' +
                ", Description='" + Description + '\'' +
                '}';
    }
}
