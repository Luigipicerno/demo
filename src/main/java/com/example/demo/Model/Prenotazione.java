package com.example.demo.Model;

import java.time.LocalDate;

import jakarta.persistence.GeneratedValue;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Prenotazione{

    @Id
    @GeneratedValue
    private Long id;
    private LocalDate dataPrenotazione;
    private LocalDate dataPrenotata;
    @ManyToOne
    private Postazione sala;
    @ManyToOne
    private Utente user;

    public Prenotazione(LocalDate dataPrenotazione, LocalDate dataPrenotata, Postazione sala, Utente user){

        this.dataPrenotazione = dataPrenotazione;
        this.dataPrenotata = dataPrenotata;
        this.sala = sala;
        this.user = user;
    }
}
