package com.rewardsandrecognition.service;


import com.rewardsandrecognition.model.Samplenominate;
import com.rewardsandrecognition.repository.SampleNominaterepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;

@Service
@Transactional
public class SampleNominateServiceImpl implements SampleNominateService {

    @Autowired
    SampleNominaterepository repository;


    @Override
    public void save(Samplenominate samplenominate) {
        repository.save(samplenominate);
    }


    @Override
    public long findByproject(String projectname, String reward_name) {
        return repository.findByproject(projectname, reward_name);
    }


    @Override
    public HashMap<String,Long> findByrewardproject(String[] r, String[] p){

        HashMap<String,Long> rp=new HashMap<String,Long>();

        for(int i=0;i<r.length;i++)
        {
            for (int j=0;j<p.length;j++)
            {
                rp.put(r[i]+"_"+p[j],repository.findByproject(r[i], p[j]));
            }
        }

        return rp;

    }


}