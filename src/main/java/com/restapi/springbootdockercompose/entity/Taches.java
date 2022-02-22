package com.restapi.springbootdockercompose.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Taches {
    @Id
    @SequenceGenerator(
            name = "taches_id_sequence",
            sequenceName = "taches_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "taches_id_sequence"
    )
    private int idTaches;
    private Date dateDebut;
    private Date dateFin;
    private String descriptionTache;
    private Number nouveauPrix;

    //private Set<Projet> enprojet = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idTache_fk",referencedColumnName = "idTaches")
    private Projet projet;

    /*public Set<Projet> getEnprojet() {
        return enprojet;
    }*/

    public int getIdTaches() {
        return idTaches;
    }
    public Date getDateDebut() {
        return dateDebut;
    }
    public Date getDateFin() {
        return dateFin;
    }
    public Projet getProjet() {
        return projet;
    }
    public String getDescriptionTache() {
        return descriptionTache;
    }
    public Number getNouveauPrix() {
        return nouveauPrix;
    }
    public void setIdTaches(int idTaches) {
        this.idTaches = idTaches;
    }
    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }
    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
    public void setDescriptionTache(String descriptionTache) {
        this.descriptionTache = descriptionTache;
    }
    public void setNouveauPrix(Number nouveauPrix) {
        this.nouveauPrix = nouveauPrix;
    }

}
