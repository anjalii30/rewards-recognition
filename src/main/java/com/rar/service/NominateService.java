package com.rar.service;

import com.rar.model.Nominate;
import com.rar.model.Project;

import java.util.List;

public interface NominateService {

     Object findByrewardproject(String[] r, String[] p);

     String findByproject(String projectname, String reward_name);

    List<String> getEmployeeByProject(String projectname);

    Object getProjectsList();

    Nominate save(Nominate samplenominate);

    Project saveProject(Project projectModel);
}
