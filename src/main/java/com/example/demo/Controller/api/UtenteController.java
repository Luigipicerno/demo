package com.example.demo.Controller.api;

import com.example.demo.Model.Utente;
import com.example.demo.Service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class UtenteController {

    @Autowired
    UtenteService utenteService;

    final String versionV1 = "v1";
    final String versionV2 = "v2";

    @GetMapping(versionV2 + "/utentes")
    public ResponseEntity<List<Utente>> getAllUtentes(){

        List<Utente> result = utenteService.findAll();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(versionV1 + "/utente")
    public ResponseEntity<Optional<Utente>> getUtenteByID(@RequestParam Long id){

        Optional<Utente> result = utenteService.findByID(id);

        if(result.isEmpty())
            //null potrei mapparlo con classe wrapper (POJO)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(versionV1 + "/utente")
    public ResponseEntity<Utente> createUtente(@RequestBody Utente newUtente){

        Utente utenteSaved = utenteService.save(newUtente);

        return new ResponseEntity<>(utenteSaved, HttpStatus.OK);
    }

    @PutMapping(versionV1 + "/utente")
    public ResponseEntity<Utente> updateUtente(@RequestBody Utente updateUtente){

        Utente utenteUpdated = utenteService.update(updateUtente);

        return new ResponseEntity<>(utenteUpdated, HttpStatus.OK);
    }

    @DeleteMapping(versionV1 + "/utente/{id}")
    public ResponseEntity<Utente> deleteUtente(@PathVariable Long id){

        utenteService.deleteByID(id);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}