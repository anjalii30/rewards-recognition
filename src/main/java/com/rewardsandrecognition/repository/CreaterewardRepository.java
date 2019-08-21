package com.rewardsandrecognition.repository;

import com.rewardsandrecognition.model.Createreward;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreaterewardRepository extends CrudRepository<Createreward, Long> {

    @Query(value = "SELECT * FROM createreward WHERE rolled_out = 1",
            nativeQuery=true)
    Createreward findByRolled();
}
