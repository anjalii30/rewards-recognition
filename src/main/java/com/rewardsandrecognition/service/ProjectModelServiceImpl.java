package com.rewardsandrecognition.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rewardsandrecognition.model.Createreward;
import com.rewardsandrecognition.model.ProjectModel;
import com.rewardsandrecognition.model.Samplenominate;
import com.rewardsandrecognition.repository.ProjectRepository;
import com.rewardsandrecognition.repository.SampleNominaterepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProjectModelServiceImpl implements ProjectModelService {


    @Autowired
    private
    ProjectRepository projectRepository;
    @Autowired
    private
    JdbcTemplate jdbcTemplate;



    @Override
    public void getProjects(ProjectModel projectModel) {

        projectRepository.save(projectModel);

    }


    @Override
    public List<ProjectModel> getProjectsList() {
        String sql = "select * from projects";

        RowMapper<ProjectModel> rowMapper = new ProjectRepository.ProjectModelRowMapper();
        List<ProjectModel> list = jdbcTemplate.query(sql, rowMapper);

        return list;
    }
}