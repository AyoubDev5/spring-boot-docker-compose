package com.restapi.springbootdockercompose.controller;

import com.restapi.springbootdockercompose.entity.Projet;
import com.restapi.springbootdockercompose.entity.Taches;
import com.restapi.springbootdockercompose.repository.Projetrepository;
import com.restapi.springbootdockercompose.repository.Tachesrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableJpaRepositories
public class Tachescontroller {

    @Autowired
    private Tachesrepository tachesrepository;

    @Autowired
    private Projetrepository projetrepository;

    @PostMapping("/taches")
    public Taches addtache(@RequestBody Taches tache){
        return tachesrepository.save(tache);
    }

    @GetMapping("/taches/identify")
    public ResponseEntity<List<Taches>> findAll(){
        return ResponseEntity.ok(tachesrepository.findAll());
    }

    @GetMapping("/taches/{id}")
    public ResponseEntity<Taches> findTacheById(@PathVariable(value = "id") Integer idTaches) {
        Taches tache = tachesrepository.findById(idTaches).orElseThrow(
                () -> new ResouceNotFoundException("Projet not found" + idTaches));
        return ResponseEntity.ok().body(tache);
    }

    @PutMapping("/taches/up/{id}")
    public ResponseEntity<Taches> updateTache(@PathVariable(value = "id") Integer idTaches,
                                         @RequestBody Taches tacheDetail) {
        Taches tache = tachesrepository.findById(idTaches)
                .orElseThrow(() -> new ResouceNotFoundException("Tache not found for this id :: " + idTaches));
        tache.setDescriptionTache(tacheDetail.getDescriptionTache());
        final Taches updatedTache = tachesrepository.save(tache);
        return ResponseEntity.ok(updatedTache);

    }

    @PutMapping("/taches/{tachesId}/projet/{projetId}")
    Taches assignProjetToTaches(
            @PathVariable Integer idProjet,
            @PathVariable Integer idTaches
    ) {
        Taches tache = tachesrepository.findById(idProjet).get();
        Projet projet = projetrepository.findById(idTaches).get();
        tache.setProjet(projet);
        return tachesrepository.save(tache);
    }

    @DeleteMapping("/taches/delete/{id}")
    public ResponseEntity<Void> deleteTache(@PathVariable(value = "id") Integer idTaches) {
        Taches tache = tachesrepository.findById(idTaches).orElseThrow(
                () -> new ResouceNotFoundException("Tache not found" + idTaches));
        tachesrepository.delete(tache);
        return ResponseEntity.ok().build();
    }
}
