package model;

import java.io.Serializable;
import java.util.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Joueur extends Personne implements Serializable {
    private int etatPhysique;

    private int moral;

    private int defense;

    private int millieu;

    private int attaque;

    private int notePerformancesRecentes;

    private int nbButsSaison;

    private int nbPasseDecisiveSaison;

    private int nbCartonJauneSaison;

    private int nbCartonRougeSaison;

    private Poste poste;

    private Equipe equipe;

    private List<StatistiquesSaisonJoueur> historiqueSaisons = new ArrayList<StatistiquesSaisonJoueur> ();

    public ArrayList<Joueur> joueursAll = new ArrayList<Joueur>();

    public boolean etudierOffreTransfert(final Contrat contratPropose) {
        Random rd = new Random();
        boolean result = rd.nextBoolean();
        contratPropose.setAccepte(result);
        return result;
    }

    public void initJoueur() {
    }

    public Joueur(String nom, String prenom, Date dateDeNaissance, String historique, int etatPhysique, int moral, int defense, int millieu, int attaque, int notePerformancesRecentes, int nbButsSaison, int nbPasseDecisiveSaison, int nbCartonJauneSaison, int nbCartonRougeSaison, Poste poste, Equipe equipe, List<StatistiquesSaisonJoueur> historiqueSaisons) {
        this(nom, prenom, dateDeNaissance, historique);
        configure(etatPhysique, moral, defense, millieu, attaque, notePerformancesRecentes, nbButsSaison,
                nbPasseDecisiveSaison, nbCartonJauneSaison, nbCartonRougeSaison,
                poste, equipe, historiqueSaisons);
    }

    public Joueur(String nom, String prenom, Date dateDeNaissance, String historique) {
        super(nom, prenom, dateDeNaissance, historique);
        joueursAll.add(this);
    }

    public void configure(int etatPhysique, int moral, int defense, int millieu, int attaque, int notePerformancesRecentes, int nbButsSaison, int nbPasseDecisiveSaison, int nbCartonJauneSaison, int nbCartonRougeSaison, Poste poste, Equipe equipe, List<StatistiquesSaisonJoueur> historiqueSaisons) {
        this.etatPhysique = etatPhysique;
        this.moral = moral;
        this.defense = defense;
        this.millieu = millieu;
        this.attaque = attaque;
        this.notePerformancesRecentes = notePerformancesRecentes;
        this.nbButsSaison = nbButsSaison;
        this.nbPasseDecisiveSaison = nbPasseDecisiveSaison;
        this.nbCartonJauneSaison = nbCartonJauneSaison;
        this.nbCartonRougeSaison = nbCartonRougeSaison;
        this.poste = poste;
        this.equipe = equipe;
        if(equipe!=null){
            if(equipe.getJoueurs()==null){
                equipe.setJoueurs(new ArrayList<Joueur>());
                equipe.getJoueurs().add(this);
            }else{
                if(!equipe.getJoueurs().contains(this))equipe.getJoueurs().add(this);
            }
        }
        this.historiqueSaisons = historiqueSaisons;
    }

    public int getEtatPhysique() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.etatPhysique;
    }

    public int getMoral() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.moral;
    }

    public int getDefense() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.defense;
    }

    public int getMillieu() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.millieu;
    }

    public int getAttaque() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.attaque;
    }

    public int getNotePerformancesRecentes() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.notePerformancesRecentes;
    }

    public int getNbButsSaison() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.nbButsSaison;
    }

    public int getNbPasseDecisiveSaison() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.nbPasseDecisiveSaison;
    }

    public int getNbCartonJauneSaison() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.nbCartonJauneSaison;
    }

    public int getNbCartonRougeSaison() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.nbCartonRougeSaison;
    }

    public Poste getPoste() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.poste;
    }

    public Equipe getEquipe() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.equipe;
    }

    public void afficherInfosJoueur() {
    }

    public void setEtatPhysique(int etatPhysique) {
        this.etatPhysique = etatPhysique;
    }

    public void setMoral(int moral) {
        this.moral = moral;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setMillieu(int millieu) {
        this.millieu = millieu;
    }

    public void setAttaque(int attaque) {
        this.attaque = attaque;
    }

    public void setNotePerformancesRecentes(int notePerformancesRecentes) {
        this.notePerformancesRecentes = notePerformancesRecentes;
    }

    public void setNbButsSaison(int nbButsSaison) {
        this.nbButsSaison = nbButsSaison;
    }

    public void setNbPasseDecisiveSaison(int nbPasseDecisiveSaison) {
        this.nbPasseDecisiveSaison = nbPasseDecisiveSaison;
    }

    public void setNbCartonJauneSaison(int nbCartonJauneSaison) {
        this.nbCartonJauneSaison = nbCartonJauneSaison;
    }

    public void setNbCartonRougeSaison(int nbCartonRougeSaison) {
        this.nbCartonRougeSaison = nbCartonRougeSaison;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public List<StatistiquesSaisonJoueur> getHistoriqueSaisons() {
        return historiqueSaisons;
    }

    public void setHistoriqueSaisons(List<StatistiquesSaisonJoueur> historiqueSaisons) {
        this.historiqueSaisons = historiqueSaisons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Joueur)) return false;
        Joueur joueur = (Joueur) o;
        return getEtatPhysique() == joueur.getEtatPhysique() &&
                                getMoral() == joueur.getMoral() &&
                                getDefense() == joueur.getDefense() &&
                                getMillieu() == joueur.getMillieu() &&
                                getAttaque() == joueur.getAttaque() &&
                                getNotePerformancesRecentes() == joueur.getNotePerformancesRecentes() &&
                                getNbButsSaison() == joueur.getNbButsSaison() &&
                                getNbPasseDecisiveSaison() == joueur.getNbPasseDecisiveSaison() &&
                                getNbCartonJauneSaison() == joueur.getNbCartonJauneSaison() &&
                                getNbCartonRougeSaison() == joueur.getNbCartonRougeSaison() &&
                                getPoste() == joueur.getPoste() &&
                                Objects.equals(getEquipe(), joueur.getEquipe()) &&
                                Objects.equals(getHistoriqueSaisons(), joueur.getHistoriqueSaisons());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEtatPhysique(), getMoral(), getDefense(), getMillieu(), getAttaque(),
                                getNotePerformancesRecentes(), getNbButsSaison(), getNbPasseDecisiveSaison(), getNbCartonJauneSaison(),
                                getNbCartonRougeSaison(), getPoste(), getEquipe(), getHistoriqueSaisons());
    }

    @Override
    public String toString() {
        return getNom()+" "+getPrenom();
    }

}
