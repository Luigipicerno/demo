package com.example.demo.Controller.api;

import com.example.demo.Model.Postazione;
import com.example.demo.Service.PostazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class PostazioneController {

    @Autowired
    PostazioneService postazioneService;

    final String versionV1 = "v1";
    final String versionV2 = "v2";

    @GetMapping(versionV2 + "/postaziones")
    public ResponseEntity<List<Postazione>> getAllPostaziones(){

        List<Postazione> result = postazioneService.findAll();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(versionV1 + "/postazione")
    public ResponseEntity<Optional<Postazione>> getPostazioneByID(@RequestParam Long id){

        Optional<Postazione> result = postazioneService.findByID(id);

        if(result.isEmpty())
            //null potrei mapparlo con classe wrapper (POJO)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(versionV1 + "/postazione")
    public ResponseEntity<Postazione> createPostazione(@RequestBody Postazione newPostazione){

        Postazione postazioneSaved = postazioneService.save(newPostazione);

        return new ResponseEntity<>(postazioneSaved, HttpStatus.OK);
    }

    @PutMapping(versionV1 + "/postazione")
    public ResponseEntity<Postazione> updatePostazione(@RequestBody Postazione updatePostazione){

        Postazione postazioneUpdated = postazioneService.update(updatePostazione);

        return new ResponseEntity<>(postazioneUpdated, HttpStatus.OK);
    }

    @DeleteMapping(versionV1 + "/postazione/{id}")
    public ResponseEntity<Postazione> deletePostazione(@PathVariable Long id){

        postazioneService.deleteByID(id);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}