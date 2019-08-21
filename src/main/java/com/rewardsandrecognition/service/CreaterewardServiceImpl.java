package com.rewardsandrecognition.service;


import com.rewardsandrecognition.model.Createreward;
import com.rewardsandrecognition.repository.CreaterewardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CreaterewardServiceImpl implements CreaterewardService {

    @Autowired
    CreaterewardRepository repository;

    @Override
    public List<Createreward> getALLCreatereward(){
        return (List<Createreward>)repository.findAll();
    }

    @Override
    public Createreward getById(Long id){
        return repository.findById(id).get();
    }

    @Override
    public void saveOrUpdate(Createreward createreward){
        repository.save(createreward);
    }

    @Override
    public void deleteCreatereward(Long id){
        repository.deleteById(id);

    }

    @Override
    public List<Createreward> findByRolled(){
        return repository.findByRolled();
    }

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
        Createaward1.setEmployee_idname(createreward.getEmployee_idname());
        Createaward1.setRolled_out(createreward.getRolled_out());
        Createaward1.setProject_name(createreward.getProject_name());
        Createaward1.setSubject(createreward.getSubject());
        Createaward1.setEmployee_image(createreward.getEmployee_image());
        Createreward update= repository.save(Createaward1);
        return update;
    }
}
