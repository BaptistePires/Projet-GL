package model;

import java.io.Serializable;
import java.util.Objects;

public class StatistiquesJoueur implements Serializable {
    private int nombreDeButsMarques;

    private int nombreDeCartonsJaunes;

    private int nombreDeCartonsRouges;

    private int noteDuJoueur;

    private Joueur joueur;

    public String getNom() {
        return joueur.getNom();
    }

    public String getPrenom() {
        return joueur.getPrenom();
    }

    public int getPhysique() {
        return joueur.getEtatPhysique();
    }

    public int getMoral() {
        return joueur.getMoral();
    }

    public StatistiquesJoueur(int nombreDeButsMarques, int nombreDeCartonsJaunes, int nombreDeCartonsRouges, int noteDuJoueur, Joueur joueur) {
        this.nombreDeButsMarques = nombreDeButsMarques;
        this.nombreDeCartonsJaunes = nombreDeCartonsJaunes;
        this.nombreDeCartonsRouges = nombreDeCartonsRouges;
        this.noteDuJoueur = noteDuJoueur;
        this.joueur = joueur;
    }

    public int getNombreDeButsMarques() {
        return nombreDeButsMarques;
    }

    public void setNombreDeButsMarques(int nombreDeButsMarques) {
        this.nombreDeButsMarques = nombreDeButsMarques;
    }

    public int getNombreDeCartonsJaunes() {
        return nombreDeCartonsJaunes;
    }

    public void setNombreDeCartonsJaunes(int nombreDeCartonsJaunes) {
        this.nombreDeCartonsJaunes = nombreDeCartonsJaunes;
    }

    public int getNombreDeCartonsRouges() {
        return nombreDeCartonsRouges;
    }

    public void setNombreDeCartonsRouges(int nombreDeCartonsRouges) {
        this.nombreDeCartonsRouges = nombreDeCartonsRouges;
    }

    public int getNoteDuJoueur() {
        return noteDuJoueur;
    }

    public void setNoteDuJoueur(int noteDuJoueur) {
        this.noteDuJoueur = noteDuJoueur;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StatistiquesJoueur)) return false;
        StatistiquesJoueur that = (StatistiquesJoueur) o;
        return getNombreDeButsMarques() == that.getNombreDeButsMarques() &&
                                getNombreDeCartonsJaunes() == that.getNombreDeCartonsJaunes() &&
                                getNombreDeCartonsRouges() == that.getNombreDeCartonsRouges() &&
                                getNoteDuJoueur() == that.getNoteDuJoueur() &&
                                Objects.equals(getJoueur(), that.getJoueur());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombreDeButsMarques(), getNombreDeCartonsJaunes(), getNombreDeCartonsRouges(), getNoteDuJoueur(), getJoueur());
    }

    @Override
    public String toString() {
        return "StatistiquesJoueur{" +
                                "nombreDeButsMarques=" + nombreDeButsMarques +
                                ", nombreDeCartonsJaunes=" + nombreDeCartonsJaunes +
                                ", nombreDeCartonsRouges=" + nombreDeCartonsRouges +
                                ", noteDuJoueur=" + noteDuJoueur +
                                ", joueur=" + joueur +
                                '}';
    }

}
