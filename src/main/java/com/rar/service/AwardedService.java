package com.rar.service;

import com.rar.model.Awarded;

import java.util.List;
import java.util.Optional;

public interface AwardedService {


     Object ehomepage();

     Object getReport(Long year);

    Awarded Update(Long id, Awarded awarded);

    Awarded save(Awarded awarded);

    List<Awarded> findAll();

    Optional<Awarded> findById(Long id);
}
