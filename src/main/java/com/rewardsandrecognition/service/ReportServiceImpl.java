/*
package com.rewardsandrecognition.service;

import com.rewardsandrecognition.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    ReportRepository reportRepository;

    @Autowired
    ReportService reportService;


    @Override
    public HashMap<String, Long> getReport(Long year) {

        HashMap<String, Long> report = new HashMap<String, Long>();
        report.put("rewards", reportRepository.findByRewards(year));
        report.put("week", reportRepository.weeklyFrequency(year));
        report.put("month", reportRepository.monthlyFrequency(year));
        report.put("quarter", reportRepository.quarterlyFrequency(year));
        report.put("annual", reportRepository.annuallyFrequency(year));
        report.put("spot", reportRepository.spotFrequency(year));
        report.put("people", reportRepository.findByPeople(year));

        return report;

    }

}
*/
