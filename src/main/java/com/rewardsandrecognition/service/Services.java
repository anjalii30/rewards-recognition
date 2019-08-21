package com.rewardsandrecognition.service;

//import com.example.dropdown.Model.EmployeeModel;
//import com.example.dropdown.Model.ProjectModel;
import com.rewardsandrecognition.model.EmployeeModel;
import com.rewardsandrecognition.model.ProjectModel;

import java.util.List;

public interface Services {

    public List<ProjectModel> getProjectsList();

    public List <EmployeeModel> getEmployeeByProject(String employeename);
}
