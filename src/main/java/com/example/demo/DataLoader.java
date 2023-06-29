package com.example.demo;

import com.example.demo.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.example.demo.Service.CittaService;
import com.example.demo.Service.EdificioService;
import com.example.demo.Service.PostazioneService;
import com.example.demo.Service.PrenotazioneService;
import com.example.demo.Service.UtenteService;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner{

    @Autowired
    UtenteService us;
    @Autowired
    PrenotazioneService ps;
    @Autowired
    PostazioneService pos;
    @Autowired
    EdificioService es;
    @Autowired
    CittaService cs;

    @Override
    public void run(String... args) throws Exception {
        
        Citta c1 = new Citta("Palermo");
        cs.save(c1);

        Edificio e1 = new Edificio("Empire","Via dubai",c1);
        es.save(e1);

        Postazione p1 = new Postazione("Bella stanza",5, Tipo.OPENSPACE,e1);
        pos.save(p1);

        Utente u1 = new Utente("loregibi","Lorenzo","lg@gmail.com","800A");
        us.save(u1);

        Prenotazione pr1 = new Prenotazione(LocalDate.of(2023,6,29),
                LocalDate.of(2023,7,1),p1,u1);
        ps.save(pr1);
    }
    
}
