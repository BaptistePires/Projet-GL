package model;

import java.io.Serializable;

public final class PartieSingleton implements Serializable {
    private String nomFichierSauvegarde;

    private DateCourante dateCourante;

    private Fifa fifa;

    private BoiteMail boiteMail;

    private Entraineur entraineur;

    public static transient PartieSingleton INSTANCE = new PartieSingleton();

    public void init(final String nomFichierSauvegarde) {
    }

    public void chargerPartieDepuis(final String nomFichierSource) {
        tableauDeBord();
    }

    public void initEntraineur() {
    }

    public void initFifa() {
    }

    public void avancerLeTemps() {
    }

    public void initDateCourante() {
    }

    public String getNomFichierSauvegarde() {
        return nomFichierSauvegarde;
    }

    public void setNomFichierSauvegarde(String nomFichierSauvegarde) {
        this.nomFichierSauvegarde = nomFichierSauvegarde;
    }

    public DateCourante getDateCourante() {
        return dateCourante;
    }

    public void setDateCourante(DateCourante dateCourante) {
        this.dateCourante = dateCourante;
    }

    public Fifa getFifa() {
        return fifa;
    }

    public void setFifa(Fifa fifa) {
        this.fifa = fifa;
    }

    public BoiteMail getBoiteMail() {
        return boiteMail;
    }

    public void setBoiteMail(BoiteMail boiteMail) {
        this.boiteMail = boiteMail;
    }

    public Entraineur getEntraineur() {
        return entraineur;
    }

    public void setEntraineur(Entraineur entraineur) {
        this.entraineur = entraineur;
    }

    public void tableauDeBord() {
    }

}
