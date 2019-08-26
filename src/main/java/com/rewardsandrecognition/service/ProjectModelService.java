package com.rewardsandrecognition.service;

import com.rewardsandrecognition.model.ProjectModel;
import com.rewardsandrecognition.model.Samplenominate;

import java.util.List;

public interface ProjectModelService {

    public void getProjects(ProjectModel projectModel);

    public List<ProjectModel> getProjectsList();


    }
