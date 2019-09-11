package com.rar.service;

import com.rar.model.Createreward;

import java.util.List;
import java.util.Optional;

public interface CreaterewardService {



     Createreward Update(Long id, Createreward createreward);

     Createreward updateAwardStatus(Long id, Createreward createreward);

    Optional<Createreward> findById(Long id);

    String deleteById(Long id);

    List<Createreward> findAll();

    List<Createreward> findByDiscontinued();

    List<Createreward> findByNominationClosed();

    List<Createreward> findByRolled();

    Createreward save(Createreward createreward);
}
