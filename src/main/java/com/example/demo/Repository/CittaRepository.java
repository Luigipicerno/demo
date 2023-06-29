package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Citta;

public interface CittaRepository extends JpaRepository<Citta,Long>{
    
}
