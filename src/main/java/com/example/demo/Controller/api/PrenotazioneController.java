package com.example.demo.Controller.api;

import com.example.demo.Model.Prenotazione;
import com.example.demo.Service.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class PrenotazioneController {

    @Autowired
    PrenotazioneService prenotazioneService;

    final String versionV1 = "v1";
    final String versionV2 = "v2";

    @GetMapping(versionV2 + "/prenotaziones")
    public ResponseEntity<List<Prenotazione>> getAllPrenotaziones(){

        List<Prenotazione> result = prenotazioneService.findAll();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(versionV1 + "/prenotazione")
    public ResponseEntity<Optional<Prenotazione>> getPrenotazioneByID(@RequestParam Long id){

        Optional<Prenotazione> result = prenotazioneService.findByID(id);

        if(result.isEmpty())
            //null potrei mapparlo con classe wrapper (POJO)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(versionV1 + "/prenotazione")
    public ResponseEntity<Prenotazione> createPrenotazione(@RequestBody Prenotazione newPrenotazione){

        Prenotazione prenotazioneSaved = prenotazioneService.save(newPrenotazione);

        return new ResponseEntity<>(prenotazioneSaved, HttpStatus.OK);
    }

    @PutMapping(versionV1 + "/prenotazione")
    public ResponseEntity<Prenotazione> updatePrenotazione(@RequestBody Prenotazione updatePrenotazione){

        Prenotazione prenotazioneUpdated = prenotazioneService.update(updatePrenotazione);

        return new ResponseEntity<>(prenotazioneUpdated, HttpStatus.OK);
    }

    @DeleteMapping(versionV1 + "/prenotazione/{id}")
    public ResponseEntity<Prenotazione> deletePrenotazione(@PathVariable Long id){

        prenotazioneService.deleteByID(id);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}