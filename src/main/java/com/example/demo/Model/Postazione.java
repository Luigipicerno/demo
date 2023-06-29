package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.hibernate.annotations.NaturalId;

@Data
@Entity
public class Postazione{

    @Id
    @GeneratedValue
    private Long id;
    @NaturalId
    private String codice;
    private String descrizione;
    private Integer nposti;
    private Tipo type;
    @ManyToOne
    private Edificio building;

    public Postazione(String codice, String descrizione, Integer nposti, Tipo type, Edificio building){

        this.codice = codice;
        this.descrizione = descrizione;
        this.nposti = nposti;
        this.type = type;
        this.building = building;
    }
}
