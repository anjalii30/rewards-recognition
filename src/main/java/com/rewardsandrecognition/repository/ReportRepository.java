package com.rewardsandrecognition.repository;

import com.rewardsandrecognition.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report,Long> {



    @Query(value= "SELECT * from report where year = ?1", nativeQuery = true)
    public List<Report> findAllByYear(Long year);

    @Query(value = "SELECT   count(frequency) FROM report  where frequency = ?1 and year = ?2 group by year ", nativeQuery=true)
    public long findByFrequency(String frequency, Long year);


    @Query(value= "SELECT  count(DISTINCT emp_id) from report where year = ?1  ", nativeQuery = true)
    public long findByPeople(Long year);

    @Query(value="SELECT count(reward_name) from  report where year = ?1 ", nativeQuery = true)
    public long findByRewards(Long year);

}
