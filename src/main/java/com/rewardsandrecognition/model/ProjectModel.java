package com.rewardsandrecognition.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "projects")

public class ProjectModel implements Serializable {

    @Id
    @Column(name = "projectid")
    private int projectid;
    @Column(name = "projectname")
    private String projectname;

    public int getProjectid() {
        return projectid;
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
                ", projectname='" + projectname + '\'' +
                '}';
    }
}
