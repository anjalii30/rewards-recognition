package com.rewardsandrecognition.service;


import com.rewardsandrecognition.model.DAOUser;
import com.rewardsandrecognition.model.ProjectModel;
import com.rewardsandrecognition.repository.DAOUserRepository;
import com.rewardsandrecognition.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



@Service
@Transactional
public class Servicesimpl implements NServices {

    @Autowired
    DAOUserRepository daoUserRepository;
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    ProjectModelService projectModelService;

    @Override
    public List<ProjectModel> getProjectsList() {
        return (List<ProjectModel>)projectModelService.getProjectsList();
    }

    @Override
    public List<String> getEmployeeByProject(String projectname) {
        System.out.println(projectname);
        return (List<String>)daoUserRepository.getEmployeeByProject(projectname);
    }
}