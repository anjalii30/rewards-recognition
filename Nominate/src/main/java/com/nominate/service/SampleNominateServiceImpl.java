package com.nominate.service;

import com.nominate.model.Samplenominate;
import com.nominate.repository.SampleNominaterepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SampleNominateServiceImpl implements SampleNominateService {

    @Autowired
    SampleNominaterepository repository;

    @Override
    public List<Samplenominate> getALLSamplenominate() {
        return (List<Samplenominate>)repository.findAll();
    }

    @Override
    public Samplenominate getById(String rewardID) {
        return repository.findById(rewardID).get();
    }

    @Override
    public void save(Samplenominate samplenominate) {
        repository.save(samplenominate);
    }
}
