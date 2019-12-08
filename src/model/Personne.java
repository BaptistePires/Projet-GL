package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Personne implements Serializable {
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

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDateDeNaissance(Date dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public void setHistoriqueCarriere(String historiqueCarriere) {
        this.historiqueCarriere = historiqueCarriere;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Personne)) return false;
        Personne personne = (Personne) o;
        return Objects.equals(getNom(), personne.getNom()) &&
                        Objects.equals(getPrenom(), personne.getPrenom()) &&
                        Objects.equals(getDateDeNaissance(), personne.getDateDeNaissance()) &&
                        Objects.equals(getHistoriqueCarriere(), personne.getHistoriqueCarriere());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNom(), getPrenom(), getDateDeNaissance(), getHistoriqueCarriere());
    }

    @Override
    public String toString() {
        return "Personne{" +
                        "nom='" + nom + '\'' +
                        ", prenom='" + prenom + '\'' +
                        ", dateDeNaissance=" + dateDeNaissance +
                        ", historiqueCarriere='" + historiqueCarriere + '\'' +
                        '}';
    }

}
