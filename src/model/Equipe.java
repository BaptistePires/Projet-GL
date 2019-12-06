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

    private int nbPoints;

    private int nbButsMarques;

    private int nbButsEncaisses;

    private int nbVictoires;

    private int nbMatchsNuls;

    private int nbDefaites;

    private List<Joueur> joueurs = new ArrayList<Joueur> ();

    private Entraineur entraineur;

    private President president;

    private Strategie strategie;

    private List<StatistiquesSaisonEquipe> historiqueSaisons = new ArrayList<StatistiquesSaisonEquipe> ();

    private Stade stade;

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

    public String getNom() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.nom;
    }

    public String getHistoireDuClub() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.histoireDuClub;
    }

    public int getBudgetTransferts() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.budgetTransferts;
    }

    public int getMasseSalariale() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.masseSalariale;
    }

    public List<Joueur> getJoueurs() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.joueurs;
    }

    public int getNbPoints() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.nbPoints;
    }

    public int getNbVictoires() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.nbVictoires;
    }

    public int getNbMatchsNuls() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.nbMatchsNuls;
    }

    public int getNbDefaites() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.nbDefaites;
    }

    public int getNbButsMarques() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.nbButsMarques;
    }

    public int getNbButsEncaisses() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.nbButsEncaisses;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setHistoireDuClub(String histoireDuClub) {
        this.histoireDuClub = histoireDuClub;
    }

    public void setBudgetTransferts(int budgetTransferts) {
        this.budgetTransferts = budgetTransferts;
    }

    public void setMasseSalariale(int masseSalariale) {
        this.masseSalariale = masseSalariale;
    }

    public void setNbPoints(int nbPoints) {
        this.nbPoints = nbPoints;
    }

    public void setNbButsMarques(int nbButsMarques) {
        this.nbButsMarques = nbButsMarques;
    }

    public void setNbButsEncaisses(int nbButsEncaisses) {
        this.nbButsEncaisses = nbButsEncaisses;
    }

    public void setNbVictoires(int nbVictoires) {
        this.nbVictoires = nbVictoires;
    }

    public void setNbMatchsNuls(int nbMatchsNuls) {
        this.nbMatchsNuls = nbMatchsNuls;
    }

    public void setNbDefaites(int nbDefaites) {
        this.nbDefaites = nbDefaites;
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

    @Override
    public String toString(){
        return this.nom;
    }

}
