package com.rewardsandrecognition.service;


import com.rewardsandrecognition.model.DAOUser;
import com.rewardsandrecognition.model.ProjectModel;

import java.util.List;

public interface NServices {

    public List<ProjectModel> getProjectsList();

    public List <String> getEmployeeByProject(String projectname);
}