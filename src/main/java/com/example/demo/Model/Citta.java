package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Citta{
    
    @Id
    @GeneratedValue
    private Long id;
    private String nome;

    public Citta(String nome){
        this.nome = nome;
    }
}
