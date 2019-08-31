package com.rewardsandrecognition.service;

import com.rewardsandrecognition.model.Awarded;

import java.util.List;

public interface AwardedService {

    public List<Awarded> getALLAwarded();

    public Object awardedList();

    public Awarded getByAwardedId(Long id);

    public void save(Awarded awarded);

    public void deleteAwarded(Long id);

    public Awarded Update(Long id, Awarded awarded);

    public Object getReport(Long year);

}
