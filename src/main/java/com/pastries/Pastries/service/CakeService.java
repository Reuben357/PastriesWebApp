package com.pastries.Pastries.service;

import com.pastries.Pastries.exception.CakeNotFoundException;
import com.pastries.Pastries.model.Cake;
import com.pastries.Pastries.repo.CakeRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CakeService {
    private final CakeRepo cakeRepo;

    @Autowired
    public CakeService(CakeRepo cakeRepo) {
        this.cakeRepo = cakeRepo;
    }

    public Cake addCake(Cake cake){
        cake.setCakeCode(UUID.randomUUID().toString());
        return cakeRepo.save(cake);
    }

    public List<Cake> findAllCakes(){
        return cakeRepo.findAll();
    }

    public Cake updateCake(Cake cake){
        return cakeRepo.save(cake);
    }

    public Cake findCakeById(Long id){
        return cakeRepo.findCakeById(id)
                .orElseThrow(()-> new CakeNotFoundException("Cake by id " +  " " +  id  + " " + "was not found"));
    }

    public void deleteCake(Long id){
        cakeRepo.deleteCakeById(id);
    }
}
