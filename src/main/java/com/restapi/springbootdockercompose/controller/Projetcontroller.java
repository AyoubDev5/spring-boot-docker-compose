package com.restapi.springbootdockercompose.controller;

import com.restapi.springbootdockercompose.entity.Projet;
import com.restapi.springbootdockercompose.repository.Projetrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableJpaRepositories
public class Projetcontroller {

    @Autowired
    private Projetrepository projetrepository;

    @PostMapping("/projets")
    public Projet addprojet(@RequestBody Projet projet){
        return projetrepository.save(projet);
    }

    @GetMapping("/projets/identify")
    public ResponseEntity<List<Projet>> findAll(){
        return ResponseEntity.ok(projetrepository.findAll());
    }

    @GetMapping("projets/{id}")
    public ResponseEntity<Projet> findProjetById(@PathVariable(value = "id") Integer idProjet) {
        Projet projet = projetrepository.findById(idProjet).orElseThrow(
                () -> new ResouceNotFoundException("Projet not found" + idProjet));
        return ResponseEntity.ok().body(projet);
    }

    @PutMapping("projets/up/{id}")
    public ResponseEntity<Projet> Projet(@PathVariable(value = "id") Integer idProjet,
                                         @RequestBody Projet projetDetails) {
        Projet projet = projetrepository.findById(idProjet)
                .orElseThrow(() -> new ResouceNotFoundException("Projet not found for this id :: " + idProjet));
        projet.setNomProjet(projetDetails.getNomProjet());
        final Projet updatedProjet = projetrepository.save(projet);
        return ResponseEntity.ok(updatedProjet);

    }

    @DeleteMapping("projets/delete/{id}")
    public ResponseEntity<Void> deleteProjet(@PathVariable(value = "id") Integer idProjet) {
        Projet projet = projetrepository.findById(idProjet).orElseThrow(
                () -> new ResouceNotFoundException("Projet not found" + idProjet));
        projetrepository.delete(projet);
        return ResponseEntity.ok().build();
    }
}
