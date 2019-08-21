package com.rewardsandrecognition.repository;

//import com.example.dropdown.Model.ProjectModel;
import com.rewardsandrecognition.model.ProjectModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Transactional
@Repository
public class ProjectRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<ProjectModel> getProjectsList() {
        String sql = "select * from projects";

        RowMapper<ProjectModel> rowMapper = new ProjectModelRowMapper();
        List<ProjectModel> list = jdbcTemplate.query(sql, rowMapper);

        return list;
    }

    class ProjectModelRowMapper implements RowMapper<ProjectModel> {

        @Override
        public ProjectModel mapRow(ResultSet rs, int rowNum) throws SQLException {
            ProjectModel project = new ProjectModel();
            project.setProjectid(rs.getInt("projectid"));
            project.setProjectname(rs.getString("projectname"));
            return project;
        }
    }
}
