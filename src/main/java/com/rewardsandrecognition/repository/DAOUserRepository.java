package com.rewardsandrecognition.repository;

import com.rewardsandrecognition.model.DAOUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DAOUserRepository extends CrudRepository<DAOUser, Integer> {

    DAOUser findByUsername(String username);

    @Query(value = "select u.username from users u where u.id in (Select emp_id from projects where projectname=?1)",nativeQuery = true)
    public List<String> getEmployeeByProject(String projectname);
/*
    @Query(value = "select distinct projectname from projects", nativeQuery = true)
    public List<ProjectModel> getProjectsList();*/
}
