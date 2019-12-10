package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Stade implements Serializable {
    private String nom;

    private int nombrePlaces;

    private String ville;

    private String histoire;

    public static ArrayList<Stade> stadesAll = new ArrayList<Stade>();

    public Stade(String nom, int nombrePlaces, String ville, String histoire) {
        this.nom = nom;
        this.nombrePlaces = nombrePlaces;
        this.ville = ville;
        this.histoire = histoire;
        stadesAll.add(this);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNombrePlaces() {
        return nombrePlaces;
    }

    public void setNombrePlaces(int nombrePlaces) {
        this.nombrePlaces = nombrePlaces;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getHistoire() {
        return histoire;
    }

    public void setHistoire(String histoire) {
        this.histoire = histoire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stade)) return false;
        Stade stade = (Stade) o;
        return getNombrePlaces() == stade.getNombrePlaces() &&
                        Objects.equals(getNom(), stade.getNom()) &&
                        Objects.equals(getVille(), stade.getVille()) &&
                        Objects.equals(getHistoire(), stade.getHistoire());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNom(), getNombrePlaces(), getVille(), getHistoire());
    }

    @Override
    public String toString() {
        return nom;
    }

}
