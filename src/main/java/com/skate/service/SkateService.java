package com.skate.service;

import com.skate.model.Skate;
import com.skate.repository.SkateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SkateService {

    @Autowired
    private SkateRepository skateRepository;

    public List<Skate> getAll() {
        return skateRepository.getAll();
    }

    public Optional<Skate> getSkate(int id) {
        return skateRepository.getSkate(id);
    }

    public Skate save(Skate skate) {
        if (skate.getId() == null) {
            return skateRepository.save(skate);
        } else {
            Optional<Skate> e = skateRepository.getSkate(skate.getId());
            if (e.isEmpty()) {
                return skateRepository.save(skate);
            } else {
                return skate;
            }
        }
    }
    
    public boolean deleteSkate(int id){
        Optional<Skate> miBote = skateRepository.getSkate(id);
        
        if (miBote.isEmpty()){
            return false;
        }else{
            skateRepository.delete(miBote.get());
            return true;
        }
    }
    
    public Skate updateSkate(Skate skate){
        if (skate.getId()!=null){
            Optional<Skate> bote = skateRepository.getSkate(skate.getId());
            
            if (!bote.isEmpty()){
               if (skate.getName()!=null){
                   bote.get().setName(skate.getName());
               }
               if (skate.getDescription()!=null){
                   bote.get().setDescription(skate.getDescription());
               }
               if (skate.getBrand()!=null){
                   bote.get().setBrand(skate.getBrand());
               }
               if (skate.getYear()!=null){
                   bote.get().setYear(skate.getYear());
               }
               return skateRepository.save(bote.get());
            }else{
               return skate;
            }
        }
        return skate;     
    }
}
