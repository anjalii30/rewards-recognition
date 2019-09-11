package com.rar.service.impl;

import com.rar.model.Awarded;
import com.rar.repository.AwardedRepository;
import com.rar.service.AwardedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AwardedServiceImpl implements AwardedService {


    @Autowired
    private AwardedRepository awardedRepository;


    @Override
    public Awarded Update(Long id, Awarded awarded) {
        Awarded awarded1=awardedRepository.findById(id).get();
        awarded1.setProject_name(awarded.getProject_name());
        awarded1.setSubjectDescription(awarded.getSubjectDescription());
        awarded1.setEmployee_image(awarded.getEmployee_image());
        awarded1.setEmployee_name(awarded.getEmployee_name());
        awarded1.setEmp_id(awarded.getEmp_id());
        awarded1.setYear(awarded.getYear());
        awarded1.setFrequency(awarded.getFrequency());
        awarded1.setReward_name(awarded.getReward_name());



        Awarded update= awardedRepository.save(awarded1);
        return update;
    }

    @Override
    public Awarded save(Awarded awarded) {

        return awardedRepository.save(awarded);
    }

    @Override
    public List<Awarded> findAll() {
        return (List<Awarded>) awardedRepository.findAll();
    }

    @Override
    public Optional<Awarded> findById(Long id) {
        return awardedRepository.findById(id);
    }

    @Override
    public HashMap<String, Long> getReport(Long year) {

        HashMap<String, Long> report = new HashMap<String, Long>();
        report.put("rewards", awardedRepository.findByRewards(year));
        report.put("week", awardedRepository.weeklyFrequency(year));
        report.put("month", awardedRepository.monthlyFrequency(year));
        report.put("quarter", awardedRepository.quarterlyFrequency(year));
        report.put("annual", awardedRepository.annuallyFrequency(year));
        report.put("spot", awardedRepository.spotFrequency(year));
        report.put("people", awardedRepository.findByPeople(year));

        return report;

    }

    @Override
    public HashMap<Object,List> ehomepage(){
        HashMap<Object,List> awarded=new HashMap<>();
        awarded.put("awarded", (List) awardedRepository.ehomepage());
        return awarded;
    }
}
