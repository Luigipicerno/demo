package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Postazione{

    @Id
    private String id;
    private String descrizione;
    private Integer nposti;
    private Tipo type;
    @ManyToOne
    private Edificio building;

    public Postazione(String descrizione, Integer nposti, Tipo type, Edificio building){

        this.descrizione = descrizione;
        this.nposti = nposti;
        this.type = type;
        this.building = building;
    }
}
