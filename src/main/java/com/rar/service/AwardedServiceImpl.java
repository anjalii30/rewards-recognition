package com.rar.service;

import com.rar.repository.AwardedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class AwardedServiceImpl implements AwardedService  {


    @Autowired
    AwardedRepository awardedRepository;



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
