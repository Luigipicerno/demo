package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Edificio {

    @Id
    @GeneratedValue
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
