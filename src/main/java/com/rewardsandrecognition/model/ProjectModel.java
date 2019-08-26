package com.rewardsandrecognition.model;

import javax.persistence.*;
import java.io.Serializable;



@Entity
@Table(name = "projects")

public class ProjectModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "projectid")
    private int projectid;
    @Column(name = "projectname")
    private String projectname;

   @ManyToOne (fetch = FetchType.LAZY)
   @JoinColumn(name="emp_id")
    private DAOUser emp_id;

   public ProjectModel() {
    }

    public ProjectModel(int projectid, String projectname) {
        this.projectid = projectid;
        this.projectname = projectname;
       this.emp_id = emp_id;
    }

    public int getProjectid() {
        return projectid;
    }

    public DAOUser getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(DAOUser emp_id) {
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
