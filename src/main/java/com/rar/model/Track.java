package com.rar.model;

import java.io.Serializable;

public class Track implements Serializable {
    private String projectname;
    private String reward_name;
    private String mapped_value;

    public Track(String projectname, String reward_name, String mapped_value) {
        this.projectname = projectname;
        this.reward_name = reward_name;
        this.mapped_value = mapped_value;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getReward_name() {
        return reward_name;
    }

    public void setReward_name(String reward_name) {
        this.reward_name = reward_name;
    }

    public String getMapped_value() {
        return mapped_value;
    }

    public void setMapped_value(String mapped_value) {
        this.mapped_value = mapped_value;
    }
}
