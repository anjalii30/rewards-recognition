package com.rewardsandrecognition.repository;

import com.rewardsandrecognition.model.Createreward;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreaterewardRepository extends CrudRepository<Createreward, Long> {
}
