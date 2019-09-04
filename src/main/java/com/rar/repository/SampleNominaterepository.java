package com.rar.repository;

import com.rar.model.Samplenominate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleNominaterepository extends CrudRepository<Samplenominate, String> {


    @Query(value = "SELECT count(projectname) FROM nominations WHERE projectname= ?1 AND reward_name = ?2",
            nativeQuery=true)
    String findByproject(String projectname, String reward_name);




}
