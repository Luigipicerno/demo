package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Postazione;
import com.example.demo.Model.Utente;
import com.example.demo.Repository.PostazioneRepository;

@Service
public class PostazioneService {

    @Autowired
    PostazioneRepository roomrep;

    public Postazione save(Postazione room){

        return roomrep.save(room);
    }

     public void update(Postazione room){

        Postazione r = roomrep.findById(room.getId()).orElse(null);

        if (r != null) {

            roomrep.save(room);
        }
    }

    public void delete(String id){

        roomrep.deleteById(id);
    }

    public Postazione get(String id){

        return roomrep.findById(id).orElse(null);
    }

    public List<Postazione> getAll(){
        
        return roomrep.findAll();
    }
}
