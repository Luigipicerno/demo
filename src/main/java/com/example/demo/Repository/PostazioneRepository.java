package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Postazione;

public interface PostazioneRepository extends JpaRepository<Postazione,Long> {
    
}
