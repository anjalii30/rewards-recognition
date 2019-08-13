package com.nominate.service;

import com.nominate.model.Samplenominate;

import java.util.List;

public interface SampleNominateService {

    public List<Samplenominate> getALLSamplenominate();

    public Samplenominate getById(String rewardID);

    public void save(Samplenominate samplenominate);


}
