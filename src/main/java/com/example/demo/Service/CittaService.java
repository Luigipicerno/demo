package com.example.demo.Service;

import java.util.List;

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

    public void update(Citta city){

        Citta c = cityrep.findById(city.getId()).orElse(null);

        if (c != null) {

            cityrep.save(c);
        }
    }

    public void delete(Long id){

        cityrep.deleteById(id);
    }

    public Citta get(Long id){

        return cityrep.findById(id).orElse(null);
    }

    public List<Citta> getAll(){
        
        return cityrep.findAll();
    }
}
