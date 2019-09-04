package com.rar.service;


import com.rar.model.Track;
import com.rar.repository.SampleNominaterepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class SampleNominateServiceImpl implements SampleNominateService {

    @Autowired
    SampleNominaterepository repository;



    @Override
    public ArrayList<Track> findByrewardproject(String[] r, String[] p){

        String mv;

        ArrayList<Track> str=new ArrayList<>();

        for(int i=0;i<r.length;i++)
        {
            for (int j=0;j<p.length;j++)
            {
                mv= repository.findByproject(p[j], r[i]);
                Track s1= new Track(p[j]+"",r[i]+"",""+mv);
                str.add(s1);
            }
        }
        return str;



    }


}