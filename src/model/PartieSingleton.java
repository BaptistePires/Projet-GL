package model;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.Instant;
import java.util.*;
import java.util.Date;
import com.sun.org.apache.xpath.internal.operations.Bool;
import data.DataGenerator;

public final class PartieSingleton extends NotreObservable implements Serializable {
    private String nomFichierSauvegarde;

    public static int avancerAuMaximum;

    private DateCourante dateCourante;

    private Fifa fifa;

    private BoiteMail boiteMail;

    private Entraineur entraineur;

    public static transient PartieSingleton INSTANCE = new PartieSingleton();

    public void init(final String nomFichierSauvegarde) {
        boiteMail = new BoiteMail();
        setNomFichierSauvegarde(nomFichierSauvegarde);
        dateCourante = new DateCourante();
        dateCourante.setJourCourant(new GregorianCalendar(2019, Calendar.JULY, 1).getTime());
        initFifa();
        INSTANCE = this;
        //L'initialisation de l'entraineur se fait au moment ou l'utilisateur saisit ses infos
    }

    public void chargerPartieDepuis(final String nomFichierSource) {
        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomFichierSource));
            INSTANCE = (PartieSingleton) in.readObject();
        }catch(Exception e){
            e.printStackTrace();
            System.err.println("Erreur lors du chargement de la partie "+nomFichierSource+" : "+e.getClass()+" : "+e.getMessage());
        }
    }

    public void initEntraineur(Entraineur entraineur) {
        INSTANCE.entraineur = entraineur;
        entraineur.getEquipe().setEntraineur(entraineur);
    }

    public void initFifa() {
        this.fifa = DataGenerator.generateRandomFifa();
    }

    public void avancerLeTemps() {
        int i=0;
        while(i++<avancerAuMaximum){
            /* Ajout d'un jour à la date courante et récupération des évenements. */
            dateCourante.avancerDUnJour();
            List<Evenement> evenements = Evenement.getEvenementsPourLaDate(dateCourante.getJourCourant());
            if(evenements==null)continue;
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
        notifier();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PartieSingleton)) return false;
        PartieSingleton that = (PartieSingleton) o;
        return Objects.equals(getNomFichierSauvegarde(), that.getNomFichierSauvegarde()) &&
                        Objects.equals(getDateCourante(), that.getDateCourante()) &&
                        Objects.equals(getFifa(), that.getFifa()) &&
                        Objects.equals(getBoiteMail(), that.getBoiteMail()) &&
                        Objects.equals(getEntraineur(), that.getEntraineur());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNomFichierSauvegarde(), getDateCourante(), getFifa(), getBoiteMail(), getEntraineur());
    }

    @Override
    public String toString() {
        return "PartieSingleton{" +
                        "nomFichierSauvegarde='" + nomFichierSauvegarde + '\'' +
                        ", dateCourante=" + dateCourante +
                        ", fifa=" + fifa +
                        ", boiteMail=" + boiteMail +
                        ", entraineur=" + entraineur +
                        '}';
    }

    public void avancerLeTempsJusqua(Date date) {
        while(date.after(dateCourante.getJourCourant())){
            /* Ajout d'un jour à la date courante et récupération des évenements. */
            dateCourante.avancerDUnJour();
            List<Evenement> evenements = Evenement.getEvenementsPourLaDate(dateCourante.getJourCourant());
            if(evenements==null)continue;
            /* Tri des évenements (Les plus importants en tête de liste) */
            System.out.println("Evenements :"+evenements);
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
        notifier();
    }

}
