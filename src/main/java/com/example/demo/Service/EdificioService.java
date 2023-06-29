package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

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

     public Edificio update(Edificio e){

        Edificio edi = buildingrep.findById(e.getId()).orElse(null);

        if (edi != null) {

            buildingrep.save(e);
        }
        return edi;
    }

    public void deleteByID(Long id){

        buildingrep.deleteById(id);
    }

    public Optional<Edificio> findByID(Long id){

        return buildingrep.findById(id);
    }

    public List<Edificio> findAll(){
        
        return buildingrep.findAll();
    }
}
