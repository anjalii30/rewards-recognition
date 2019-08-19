package com.rewardsandrecognition.repository;

import com.rewardsandrecognition.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report,Long> {



    @Query(value = "SELECT count(frequency) FROM report  WHERE frequency = ?1",
            nativeQuery=true
    )
    public long findByFrequency(String frequency);


    @Query(value= "SELECT count(DISTINCT emp_id) from report ", nativeQuery = true)
    public long findByPeople();

    @Query(value="SELECT count(reward_name) from  report", nativeQuery = true)
    public long findByRewards();

}
