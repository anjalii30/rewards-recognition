package com.rewardsandrecognition.service;

import com.rewardsandrecognition.model.Awarded;
import com.rewardsandrecognition.model.Createreward;

import java.util.List;

public interface AwardedService {

    public List<Awarded> getALLAwarded();


    public Awarded getByAwardedId(Long id);

    public void save(Awarded awarded);

    public void deleteAwarded(Long id);

    public Awarded Update(Long id, Awarded awarded);

}
