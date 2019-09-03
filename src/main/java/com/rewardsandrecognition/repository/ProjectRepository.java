package com.rewardsandrecognition.repository;

import com.rewardsandrecognition.model.ProjectModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Repository
public interface ProjectRepository extends CrudRepository<ProjectModel, Integer> {



 @Query(value="select distinct projectname from projects",nativeQuery = true)
 public List getProjectsList();

}
