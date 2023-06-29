package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Prenotazione;
import com.example.demo.Model.Utente;
import com.example.demo.Repository.PrenotazioneRepository;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotationrep;

    public Prenotazione save(Prenotazione prenotation){

        return prenotationrep.save(prenotation);
    }

     public Prenotazione update(Prenotazione prenotation){

        Prenotazione pren = prenotationrep.findById(prenotation.getId()).orElse(null);

        if (pren != null) {

            prenotationrep.save(pren);
        }
        return pren;
    }

    public void deleteByID(Long id){

        prenotationrep.deleteById(id);
    }

    public Optional<Prenotazione> findByID(Long id){

        return prenotationrep.findById(id);
    }

    public List<Prenotazione> findAll(){
        
        return prenotationrep.findAll();
    }   
}
