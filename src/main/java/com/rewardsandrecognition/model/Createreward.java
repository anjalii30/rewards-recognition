package com.rewardsandrecognition.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

@Entity
@Table(name = "createreward")
@EntityListeners(AuditingEntityListener.class)
public class Createreward implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

    @Column(name = "Reward_Name")
    private String reward_name;
    @Column(name = "Reward_Scope")
    private String reward_scope;
    @Column(name = "Frequency")
    private String frequency;
    @Column(name = "Description")
    private String description;
    @Column(name = "Objective")
    private String objective;
    @Column(name = "Starting_Date")
    private Date starting_date; /* year-month-date*/
    @Column(name = "Reward_Type")
    private String reward_type;
    @Column(name = "Nomination_Process")
    private String nomination_process;
    @Column(name = "Nomination_Url")
    private String nomination_url;
    @Column(name = "Employee_idname")
    private String employee_idname;
    @Column(name = "Rolled_Out")
    private Boolean rolled_out;

    public Boolean getRolled_out() {
        return rolled_out;
    }

    public void setRolled_out(Boolean rolled_out) {
        this.rolled_out = rolled_out;
    }

    @Override
    public String toString() {
        return "Createreward{" +
                "id=" + id +
                ", reward_name='" + reward_name + '\'' +
                ", reward_scope='" + reward_scope + '\'' +
                ", frequency='" + frequency + '\'' +
                ", description='" + description + '\'' +
                ", objective='" + objective + '\'' +
                ", starting_date=" + starting_date +
                ", reward_type='" + reward_type + '\'' +
                ", nomination_process='" + nomination_process + '\'' +
                ", nomination_url='" + nomination_url + '\'' +
                ", employee_idname='" + employee_idname + '\'' +
                ", rolled_out=" + rolled_out +
                ", project_name='" + project_name + '\'' +
                ", subject='" + subject + '\'' +
                ", employee_image=" + employee_image +
                '}';
    }

    @Column(name = "Project_name")
    private String project_name;
    @Column(name = "Subject")
    private String subject;
    @Column(name = "Employee_image")
    private Blob employee_image;

    public Createreward() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReward_name() {
        return reward_name;
    }

    public void setReward_name(String reward_name) {
        this.reward_name = reward_name;
    }

    public String getReward_scope() {
        return reward_scope;
    }

    public void setReward_scope(String reward_scope) {
        this.reward_scope = reward_scope;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public Date getStarting_date() {
        return starting_date;
    }

    public void setStarting_date(Date starting_date) {
        this.starting_date = starting_date;
    }

    public String getReward_type() {
        return reward_type;
    }

    public void setReward_type(String reward_type) {
        this.reward_type = reward_type;
    }

    public String getNomination_process() {
        return nomination_process;
    }

    public void setNomination_process(String nomination_process) {
        this.nomination_process = nomination_process;
    }

    public String getNomination_url() {
        return nomination_url;
    }

    public void setNomination_url(String nomination_url) {
        this.nomination_url = nomination_url;
    }

    public String getEmployee_idname() {
        return employee_idname;
    }

    public void setEmployee_idname(String employee_idname) {
        this.employee_idname = employee_idname;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Blob getEmployee_image() {
        return employee_image;
    }

    public void setEmployee_image(Blob employee_image) {
        this.employee_image = employee_image;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }
}

