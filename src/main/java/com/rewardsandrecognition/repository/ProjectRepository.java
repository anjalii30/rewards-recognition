package com.rewardsandrecognition.repository;

import com.rewardsandrecognition.model.DAOUser;
import com.rewardsandrecognition.model.ProjectModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Transactional
@Repository
public interface ProjectRepository extends JpaRepository<ProjectModel,Long> {




    class ProjectModelRowMapper implements RowMapper<ProjectModel> {

        @Override
        public ProjectModel mapRow(ResultSet rs, int rowNum) throws SQLException {
            ProjectModel project = new ProjectModel();
            project.setProjectid((long) rs.getInt("projectid"));
            project.setProjectname(rs.getString("projectname"));
            //project.setEmp_id((long)rs.getObject("emp_id"));
            return project;
        }
    }
}
