package com.example.demo.Controller.api;

import com.example.demo.Model.Edificio;
import com.example.demo.Service.EdificioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class EdificioController {

    @Autowired
    EdificioService edificioService;

    final String versionV1 = "v1";
    final String versionV2 = "v2";

    @GetMapping(versionV2 + "/edificios")
    public ResponseEntity<List<Edificio>> getAllEdificios(){

        List<Edificio> result = edificioService.findAll();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(versionV1 + "/edificio")
    public ResponseEntity<Optional<Edificio>> getEdificioByID(@RequestParam Long id){

        Optional<Edificio> result = edificioService.findByID(id);

        if(result.isEmpty())
            //null potrei mapparlo con classe wrapper (POJO)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(versionV1 + "/edificio")
    public ResponseEntity<Edificio> createEdificio(@RequestBody Edificio newEdificio){

        Edificio edificioSaved = edificioService.save(newEdificio);

        return new ResponseEntity<>(edificioSaved, HttpStatus.OK);
    }

    @PutMapping(versionV1 + "/edificio")
    public ResponseEntity<Edificio> updateEdificio(@RequestBody Edificio updateEdificio){

        Edificio edificioUpdated = edificioService.update(updateEdificio);

        return new ResponseEntity<>(edificioUpdated, HttpStatus.OK);
    }

    @DeleteMapping(versionV1 + "/edificio/{id}")
    public ResponseEntity<Edificio> deleteEdificio(@PathVariable Long id){

        edificioService.deleteByID(id);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}