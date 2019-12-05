package model;

import java.util.Date;

public class Personne {
    private String nom;

    private String prenom;

    private Date dateDeNaissance;

    private String historiqueCarriere;

    public Personne(String nom, String prenom, Date dateDeNaissance, String historiqueCarriere){
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
        this.historiqueCarriere = historiqueCarriere;
    }
}
