package com.rewardsandrecognition.service;


import com.rewardsandrecognition.model.Samplenominate;
import com.rewardsandrecognition.repository.SampleNominaterepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SampleNominateServiceImpl implements SampleNominateService {

    @Autowired
    SampleNominaterepository repository;


    @Override
    public void save(Samplenominate samplenominate) {
        repository.save(samplenominate);
    }
}