package com.rewardsandrecognition.service;

import com.rewardsandrecognition.model.Createreward;

import java.util.List;

public interface CreaterewardService {

    public List<Createreward> getALLCreatereward();


    public Createreward getById(Long id);

    public void saveOrUpdate(Createreward createreward);

    public void deleteCreatereward(Long id);

    public Createreward Update(Long id, Createreward createreward);
}
