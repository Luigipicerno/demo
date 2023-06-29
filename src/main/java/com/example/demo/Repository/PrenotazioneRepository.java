package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Prenotazione;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione,Long>{
    
}
