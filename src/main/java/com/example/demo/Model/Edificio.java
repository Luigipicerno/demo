package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Edificio {

    @Id
    private Long id;
    private String nome;
    private String indirizzo;
    @ManyToOne
    private Citta city;
    

    public Edificio(String nome, String indirizzo, Citta city){

        this.nome = nome;
        this.indirizzo = indirizzo;
        this.city = city;
    }


    
    
}
