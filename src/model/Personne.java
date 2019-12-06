package model;

import java.util.Date;

public class Personne {
    private String nom;

    private String prenom;

    private Date dateDeNaissance;

    private String historiqueCarriere;

    public Personne(String nom, String prenom, Date dateDeNaissance, String historiqueCarriere) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
        this.historiqueCarriere = historiqueCarriere;
    }

    public String getNom() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.nom;
    }

    public String getPrenom() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.prenom;
    }

    public Date getDateDeNaissance() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.dateDeNaissance;
    }

    public String getHistoriqueCarriere() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.historiqueCarriere;
    }

}
