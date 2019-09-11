package com.rar.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "projects")
@ApiModel(description = "All details about Projects ")
public class Project implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "The database generated awarded ID")
    @Column(name = "projectid")
    private int projectid;

    @Column(name = "projectname")
    @ApiModelProperty(notes = "Project name")
    private String projectname;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name="emp_id")
    @ApiModelProperty(notes = "user id mapped from users table")
    private User emp_id;

    public Project() {
    }

    public Project(int projectid, String projectname,User emp_id) {
        this.projectid = projectid;
        this.projectname = projectname;
        this.emp_id = emp_id;
    }

    public int getProjectid() {
        return projectid;
    }

    public User getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(User emp_id) {
        this.emp_id = emp_id;
    }

    public void setProjectid(int projectid) {
        this.projectid = projectid;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    @Override
    public String toString() {
        return "ProjectModel{" +
                "projectid=" + projectid +
                ", projectname=" + projectname + ", emp_id"+emp_id+
                '}';
    }
}
