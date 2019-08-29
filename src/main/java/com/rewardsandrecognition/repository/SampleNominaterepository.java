package com.rewardsandrecognition.repository;

import com.rewardsandrecognition.model.Samplenominate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleNominaterepository extends CrudRepository<Samplenominate, String> {


    @Query(value = "SELECT count(projectname) FROM nominations WHERE projectname = ?2 AND reward_name= ?1",
            nativeQuery=true)
    long findByproject(String reward_name, String projectname);
}
