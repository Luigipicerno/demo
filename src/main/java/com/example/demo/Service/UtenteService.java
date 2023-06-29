package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Utente;
import com.example.demo.Repository.UtenteRepository;

@Service
public class UtenteService {
    
    @Autowired
    private UtenteRepository userrep;

    public Utente save(Utente user){

        return userrep.save(user);
    }

    public Utente update(Utente user){

        Utente utente = userrep.findById(user.getId()).orElse(null);

        if (utente != null) {

            userrep.save(user);
        }
        return utente;
    }

    public void deleteByID(Long id){

        userrep.deleteById(id);
    }

    public Optional<Utente> findByID(Long id){

        return userrep.findById(id);
    }

    public List<Utente> findAll(){
        
        return userrep.findAll();
    }

}
