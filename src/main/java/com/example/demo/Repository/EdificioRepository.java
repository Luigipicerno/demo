package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Edificio;

public interface EdificioRepository extends JpaRepository<Edificio,Long> {
    
}
