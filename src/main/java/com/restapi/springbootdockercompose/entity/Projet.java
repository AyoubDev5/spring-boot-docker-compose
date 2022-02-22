package com.restapi.springbootdockercompose.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Projet {
    @Id
    @SequenceGenerator(
            name = "projet_id_sequence",
            sequenceName = "projet_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "projet_id_sequence"
    )
    private Integer idProjet;
    private String nomProjet;
    private Date dateDebut;
    private Date dateFin;

    @JsonIgnore
    @OneToMany(mappedBy = "projet")
    private Set<Taches> entache = new HashSet<>();

    public Set<Taches> getEnprojet() {
        return entache;
    }

    public int getIdProjet() {
        return idProjet;
    }

    public String getNomProjet() {
        return nomProjet;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setIdProjet(int idProjet) {
        this.idProjet = idProjet;
    }

    public void setNomProjet(String nomProjet) {
        this.nomProjet = nomProjet;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
}
