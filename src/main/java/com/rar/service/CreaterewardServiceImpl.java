package com.rar.service;


import com.rar.model.Createreward;
import com.rar.repository.CreaterewardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CreaterewardServiceImpl implements CreaterewardService {

    @Autowired
    CreaterewardRepository repository;



    @Override
    public Createreward Update(Long id, Createreward createreward)
    {
        Createreward Createaward1=repository.findById(id).get();
        Createaward1.setReward_name(createreward.getReward_name());
        Createaward1.setReward_scope(createreward.getReward_scope());
        Createaward1.setFrequency(createreward.getFrequency());
        Createaward1.setObjective(createreward.getObjective());
        Createaward1.setDescription(createreward.getDescription());
        Createaward1.setStarting_date(createreward.getStarting_date());
        Createaward1.setReward_type(createreward.getReward_type());
        Createaward1.setNomination_process(createreward.getNomination_process());
        Createaward1.setNomination_url(createreward.getNomination_url());
        Createaward1.setEnding_date(createreward.getEnding_date());
        Createaward1.setAward_status(createreward.getAward_status());
        Createaward1.setDiscontinuedate(createreward.getDiscontinuedate());
        Createaward1.setDiscontiuereason(createreward.getDiscontiuereason());


        Createreward update= repository.save(Createaward1);
        return update;
    }

    @Override
    public Createreward updateAwardStatus(Long id, Createreward createreward)
    {
        Createreward Createaward1=repository.findById(id).get();
        Createaward1.setReward_name(Createaward1.getReward_name());
        Createaward1.setReward_scope(Createaward1.getReward_scope());
        Createaward1.setFrequency(Createaward1.getFrequency());
        Createaward1.setObjective(Createaward1.getObjective());
        Createaward1.setDescription(Createaward1.getDescription());
        Createaward1.setStarting_date(Createaward1.getStarting_date());
        Createaward1.setReward_type(Createaward1.getReward_type());
        Createaward1.setNomination_process(Createaward1.getNomination_process());
        Createaward1.setNomination_url(Createaward1.getNomination_url());
        Createaward1.setEnding_date(Createaward1.getEnding_date());
        Createaward1.setAward_status(createreward.getAward_status());
        Createaward1.setDiscontinuedate(createreward.getDiscontinuedate());
        Createaward1.setDiscontiuereason(createreward.getDiscontiuereason());

        Createreward update= repository.save(Createaward1);
        return update;
    }

}
