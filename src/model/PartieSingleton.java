package model;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;

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


    /**
     *
     */
    public void initEntraineur() {
    }

    public void initFifa() {
    }

    public void avancerLeTemps() {
        while(true){
            /* Ajout d'un jour à la date courante et récupération des évenements. */
            dateCourante.avancerDUnJour();
            List<Evenement> evenements = Evenement.getEvenementsPourLaDate(dateCourante.getJourCourant());

            /* Tri des évenements (Les plus importants en tête de liste) */
            evenements.sort((o1, o2) -> Boolean.compare(o2.getImportance(), o1.getImportance()));

            /* Si le premier evenement de la liste est important, on arrête d'avancer le temps, sinon
            * cela signifie qu'il n'y a aucun evenement important ce jour la, on les execute tous
            * et on recommence. */
            if(evenements.get(0).getImportance()) {
                break;
            }else{
                for(Evenement e: evenements) {
                    e.processEvenement();
                }
            }
        }
    }

    public void initDateCourante() {
    }

    public void tableauDeBord(){

    }

}
