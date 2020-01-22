package com.rbonfim.petclinic.service.springdatajpa;

import com.rbonfim.petclinic.model.Visit;
import com.rbonfim.petclinic.repositories.VisitRespository;
import com.rbonfim.petclinic.service.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VisitJpaService implements VisitService {

    public final VisitRespository visitRespository;

    public VisitJpaService(VisitRespository visitRespository) {
        this.visitRespository = visitRespository;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitRespository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public Visit findById(Long aLong) {
        return visitRespository.findById(aLong).orElse(null);
    }

    @Override
    public Visit save(Visit obj) {
        return visitRespository.save(obj);
    }

    @Override
    public void delete(Visit o) {
        visitRespository.delete(o);
    }

    @Override
    public void deleteById(Long aLong) {
        visitRespository.deleteById(aLong);
    }
}
