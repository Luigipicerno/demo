package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Postazione;
import com.example.demo.Repository.PostazioneRepository;

@Service
public class PostazioneService {

    @Autowired
    private PostazioneRepository roomrep;

    public Postazione save(Postazione room){

        return roomrep.save(room);
    }

     public Postazione update(Postazione room){

        Postazione r = roomrep.findById(room.getId()).orElse(null);

        if (r != null) {

            roomrep.save(room);
        }
        return r;
    }

    public void deleteByID(Long id){

        roomrep.deleteById(id);
    }

    public Optional<Postazione> findByID(Long id){

        return roomrep.findById(id);
    }

    public List<Postazione> findAll(){
        
        return roomrep.findAll();
    }
}
