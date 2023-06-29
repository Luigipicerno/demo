package com.example.demo.Controller.api;

import com.example.demo.Model.Citta;
import com.example.demo.Service.CittaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class CittaController {

    @Autowired
    CittaService cittaService;

    final String versionV1 = "v1";
    final String versionV2 = "v2";

    @GetMapping(versionV2 + "/cittas")
    public ResponseEntity<List<Citta>> getAllCittas(){

        List<Citta> result = cittaService.findAll();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(versionV1 + "/citta")
    public ResponseEntity<Optional<Citta>> getCittaByID(@RequestParam Long id){

        Optional<Citta> result = cittaService.findByID(id);

        if(result.isEmpty())
            //null potrei mapparlo con classe wrapper (POJO)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(versionV1 + "/citta")
    public ResponseEntity<Citta> createCitta(@RequestBody Citta newCitta){

        Citta cittaSaved = cittaService.save(newCitta);

        return new ResponseEntity<>(cittaSaved, HttpStatus.OK);
    }

    @PutMapping(versionV1 + "/citta")
    public ResponseEntity<Citta> updateCitta(@RequestBody Citta updateCitta){

        Citta cittaUpdated = cittaService.update(updateCitta);

        return new ResponseEntity<>(cittaUpdated, HttpStatus.OK);
    }

    @DeleteMapping(versionV1 + "/citta/{id}")
    public ResponseEntity<Citta> deleteCitta(@PathVariable Long id){

        cittaService.deleteByID(id);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
