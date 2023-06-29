package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Utente;
import com.example.demo.Repository.UtenteRepository;

@Service
public class UtenteService {
    
    @Autowired
    UtenteRepository userrep;

    public Utente save(Utente user){

        return userrep.save(user);
    }

    public void update(Utente user){

        Utente utente = userrep.findById(user.getId()).orElse(null);

        if (utente != null) {

            userrep.save(user);
        }
    }

    public void delete(Long id){

        userrep.deleteById(id);
    }

    public Utente get(Long id){

        return userrep.findById(id).orElse(null);
    }

    public List<Utente> getAll(){
        
        return userrep.findAll();
    }

}
