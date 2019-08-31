package com.rewardsandrecognition.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@CrossOrigin
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
    @Column(name = "Ending_Date")
    private Date ending_date;
    @Column(name = "discontinuedate")
    private Date discontinuedate;
    @Column(name = "discontinuereason")
    private String discontiuereason;

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
                ", ending_date=" + ending_date +
                ", discontinuedate=" + discontinuedate +
                ", discontiuereason='" + discontiuereason + '\'' +
                ", award_status=" + award_status +
                '}';
    }

    public Date getEnding_date() {
        return ending_date;
    }

    public void setEnding_date(Date ending_date) {
        this.ending_date = ending_date;
    }

    @Column(name = "Award_Status")
    private int award_status=0;

    public int getAward_status() {
        return award_status;
    }

    public void setAward_status(int award_status) {
        this.award_status = award_status;
    }


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

    public Date getDiscontinuedate() {
        return discontinuedate;
    }

    public void setDiscontinuedate(Date discontinuedate) {
        this.discontinuedate = discontinuedate;
    }

    public String getDiscontiuereason() {
        return discontiuereason;
    }

    public void setDiscontiuereason(String discontiuereason) {
        this.discontiuereason = discontiuereason;
    }
}
