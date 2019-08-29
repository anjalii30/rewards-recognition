package com.rewardsandrecognition.service;

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


    @Override
    public List getProjectsList()
    {
        return (List)projectRepository.getProjectsList();
    }

    @Override
    public List<String> getEmployeeByProject(String projectname) {
        System.out.println(projectname);
        return (List<String>)daoUserRepository.getEmployeeByProject(projectname);
    }

    @Override
    public void getProjects(ProjectModel projectModel) {

        projectRepository.save(projectModel);

    }
}