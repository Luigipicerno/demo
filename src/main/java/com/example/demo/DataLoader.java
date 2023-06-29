package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.example.demo.Model.Citta;
import com.example.demo.Service.CittaService;
import com.example.demo.Service.EdificioService;
import com.example.demo.Service.PostazioneService;
import com.example.demo.Service.PrenotazioneService;
import com.example.demo.Service.UtenteService;

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
        
        Citta c = new Citta()
    }
    
}
