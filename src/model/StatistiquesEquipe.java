package model;

import java.io.Serializable;
import java.util.Objects;

public class StatistiquesEquipe implements Serializable {
    private int nombreDeButsMarques;

    private int nombreDeButsEncaisses;

    private int possessionDeBalle;

    private int nombreDePasses;

    private Equipe equipe;

    public void updateEquipe(){
        equipe.setNbButsMarques(equipe.getNbButsMarques()+nombreDeButsMarques);
        equipe.setNbButsEncaisses(equipe.getNbButsEncaisses()+ nombreDeButsEncaisses);
        if(nombreDeButsEncaisses==nombreDeButsMarques)equipe.setNbPoints(equipe.getNbPoints()+1);
        else if(nombreDeButsEncaisses<nombreDeButsMarques)equipe.setNbPoints(equipe.getNbPoints()+3);
    }

    public int getNombreDeButsEncaisses() {
        return nombreDeButsEncaisses;
    }

    public void setNombreDeButsEncaisses(int nombreDeButsEncaisses) {
        this.nombreDeButsEncaisses = nombreDeButsEncaisses;
    }

    public int getNombreDePasses() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.nombreDePasses;
    }

    public void setNombreDePasses(final int value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.nombreDePasses = value;
    }

    public int getNombreDeButsMarques() {
        return nombreDeButsMarques;
    }

    public void setNombreDeButsMarques(int nombreDeButsMarques) {
        this.nombreDeButsMarques = nombreDeButsMarques;
    }

    public int getPossessionDeBalle() {
        return possessionDeBalle;
    }

    public void setPossessionDeBalle(int possessionDeBalle) {
        this.possessionDeBalle = possessionDeBalle;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public StatistiquesEquipe(int nombreDeButsMarques, int nombreDeButsEncaisses, int possessionDeBalle, int nombreDePasses, Equipe equipe) {
        this.nombreDeButsMarques = nombreDeButsMarques;
        this.nombreDeButsEncaisses = nombreDeButsEncaisses;
        this.possessionDeBalle = possessionDeBalle;
        this.nombreDePasses = nombreDePasses;
        this.equipe = equipe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StatistiquesEquipe)) return false;
        StatistiquesEquipe that = (StatistiquesEquipe) o;
        return getNombreDeButsMarques() == that.getNombreDeButsMarques() &&
                                getPossessionDeBalle() == that.getPossessionDeBalle() &&
                                getNombreDeButsEncaisses() == that.getNombreDeButsEncaisses() &&
                                getNombreDePasses() == that.getNombreDePasses() &&
                                Objects.equals(getEquipe(), that.getEquipe());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombreDeButsMarques(), getNombreDeButsEncaisses(), getPossessionDeBalle(),
                getNombreDePasses(), getEquipe());
    }

    @Override
    public String toString() {
        return "StatistiquesEquipe{" +
                                "nombreDeButsMarques=" + nombreDeButsMarques +
                                "nombreDeButsEncaisses=" + nombreDeButsEncaisses +
                                ", possessionDeBalle=" + possessionDeBalle +
                                ", nombreDePasses=" + nombreDePasses +
                                ", equipe=" + equipe +
                                '}';
    }

}
