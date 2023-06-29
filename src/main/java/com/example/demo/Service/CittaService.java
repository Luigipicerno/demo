package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Citta;
import com.example.demo.Repository.CittaRepository;

@Service
public class CittaService {
    
    @Autowired
    private CittaRepository cityrep;
    
    public Citta save(Citta city){

        return cityrep.save(city);
    }

    public Citta update(Citta city){

        Citta c = cityrep.findById(city.getId()).orElse(null);

        if (c != null) {

            cityrep.save(c);
        }
        return c;
    }

    public void deleteByID(Long id){

        cityrep.deleteById(id);
    }

    public Optional<Citta> findByID(Long id){

        if(id == 0)
            return Optional.empty();

        return cityrep.findById(id);
    }

    public List<Citta> findAll(){
        
        return cityrep.findAll();
    }
}
