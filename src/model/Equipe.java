package model;

import java.util.ArrayList;
import java.util.List;

public class Equipe {
    public static List<Equipe> equipesAll = new ArrayList<Equipe>();

    public static Equipe getEquipeParNom(String nom){
        for(Equipe e :equipesAll){
            if(e.nom.equals(nom))return e;
        }
        //Otherwise
        return null;
    }

    private String nom;

    private String histoireDuClub;

    private int budgetTransferts;

    private int masseSalariale;

    private List<Joueur> joueurs = new ArrayList<Joueur> ();

    private Entraineur entraineur;

    private President president;

    private Strategie strategie;

    private List<StatistiquesSaisonEquipe> historiqueSaisons = new ArrayList<StatistiquesSaisonEquipe> ();

    private Stade stade;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getHistoireDuClub() {
        return histoireDuClub;
    }

    public void setHistoireDuClub(String histoireDuClub) {
        this.histoireDuClub = histoireDuClub;
    }

    public int getBudgetTransferts() {
        return budgetTransferts;
    }

    public void setBudgetTransferts(int budgetTransferts) {
        this.budgetTransferts = budgetTransferts;
    }

    public int getMasseSalariale() {
        return masseSalariale;
    }

    public void setMasseSalariale(int masseSalariale) {
        this.masseSalariale = masseSalariale;
    }

    public void setJoueurs(List<Joueur> joueurs) {
        this.joueurs = joueurs;
    }

    public Entraineur getEntraineur() {
        return entraineur;
    }

    public void setEntraineur(Entraineur entraineur) {
        this.entraineur = entraineur;
    }

    public President getPresident() {
        return president;
    }

    public void setPresident(President president) {
        this.president = president;
    }

    public Strategie getStrategie() {
        return strategie;
    }

    public void setStrategie(Strategie strategie) {
        this.strategie = strategie;
    }

    public List<StatistiquesSaisonEquipe> getHistoriqueSaisons() {
        return historiqueSaisons;
    }

    public void setHistoriqueSaisons(List<StatistiquesSaisonEquipe> historiqueSaisons) {
        this.historiqueSaisons = historiqueSaisons;
    }

    public Stade getStade() {
        return stade;
    }

    public void setStade(Stade stade) {
        this.stade = stade;
    }

    public List<Joueur> getJoueurs() {
        // TODO Auto-generated return
        return null;
    }

    public void formulerOffreTransfert(final Contrat contratPropose, final Joueur joueurConvoite) {
    }

    public void initEquipe() {
    }

    public boolean isNotreEquipe() {
        // TODO Auto-generated return
        return false;
    }

    public Information organiserTeamBuilding() {
        // TODO Auto-generated return
        return null;
    }

    @Override
    public String toString(){
        return this.nom;
    }

}
