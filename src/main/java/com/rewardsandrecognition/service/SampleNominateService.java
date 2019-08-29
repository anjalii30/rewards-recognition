package com.rewardsandrecognition.service;



import com.rewardsandrecognition.model.ProjectModel;
import com.rewardsandrecognition.model.Samplenominate;

public interface SampleNominateService {


    public long findByproject(String projectname,String reward_name);

    public Object findByrewardproject(String[] r,String[] p);

    public void save(Samplenominate samplenominate);


}
