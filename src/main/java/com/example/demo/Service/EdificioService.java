package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Edificio;
import com.example.demo.Model.Utente;
import com.example.demo.Repository.EdificioRepository;

@Service
public class EdificioService {

    @Autowired
    private EdificioRepository buildingrep;

    public Edificio save(Edificio building){

        return buildingrep.save(building);
    }

     public void update(Edificio e){

        Edificio edi = buildingrep.findById(e.getId()).orElse(null);

        if (edi != null) {

            buildingrep.save(e);
        }
    }

    public void delete(Long id){

        buildingrep.deleteById(id);
    }

    public Edificio get(Long id){

        return buildingrep.findById(id).orElse(null);
    }

    public List<Edificio> getAll(){
        
        return buildingrep.findAll();
    }
}
