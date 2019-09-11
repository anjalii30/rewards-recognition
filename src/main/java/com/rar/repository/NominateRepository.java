package com.rar.repository;

import com.rar.model.Nominate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface NominateRepository extends CrudRepository<Nominate, String> {


    @Query(value = "SELECT count(projectname) FROM nominations WHERE projectname= ?1 AND reward_name = ?2",
            nativeQuery=true)
    String findByproject(String projectname, String reward_name);



}
