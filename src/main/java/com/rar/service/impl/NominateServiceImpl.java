package com.rar.service.impl;

import com.rar.model.Nominate;
import com.rar.model.Project;
import com.rar.model.Track;
import com.rar.repository.NominateRepository;
import com.rar.repository.ProjectRepository;
import com.rar.repository.UserRepository;
import com.rar.service.NominateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NominateServiceImpl implements NominateService {

    @Autowired
    private NominateRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectRepository projectRepository;


    @Override
    public ArrayList<Track> findByrewardproject(String[] r, String[] p){

        String mv;

        ArrayList<Track> str=new ArrayList<>();

        for(int i=0;i<r.length;i++)
        {
            for (int j=0;j<p.length;j++)
            {
                mv= repository.findByproject(p[j], r[i]);
                Track s1= new Track(p[j]+"",r[i]+"",""+mv);
                str.add(s1);
            }
        }
        return str;



    }

    @Override
    public String findByproject(String projectname, String reward_name) {
        return repository.findByproject(projectname, reward_name);
    }

    @Override
    public List<String> getEmployeeByProject(String projectname) {
        return userRepository.getEmployeeByProject(projectname) ;
    }

    @Override
    public Object getProjectsList() {
        return projectRepository.getProjectsList();
    }

    @Override
    public Nominate save(Nominate samplenominate) {

        return repository.save(samplenominate);
    }

    @Override
    public Project saveProject(Project projectModel) {

        return projectRepository.save(projectModel);
    }


}
