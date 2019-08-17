package com.rewardsandrecognition.repository;

import com.rewardsandrecognition.model.DAOUser;
import org.springframework.data.repository.CrudRepository;

public interface DAOUserRepository extends CrudRepository<DAOUser, Integer> {

    DAOUser findByUsername(String username);

}