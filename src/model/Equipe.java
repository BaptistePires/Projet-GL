package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Equipe implements Serializable {
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

    private Ligue ligue;

    public void formulerOffreTransfert(final Contrat contratPropose, final Joueur joueurConvoite) {
    }

    public Equipe(String nom,String histoireDuClub,int budgetTransferts,int masseSalariale, List<Joueur> joueurs,
                  Entraineur entraineur, President president, Stade stade, Ligue ligue){
        this.nom = nom;
        this.histoireDuClub = histoireDuClub;
        this.budgetTransferts = budgetTransferts;
        this.masseSalariale = masseSalariale;
        this.joueurs = joueurs;
        this.entraineur = entraineur;
        this.president = president;
        this.stade = stade;
        this.ligue = ligue;
        initEquipe();
        equipesAll.add(this);
    }

    public void initEquipe() {
        nbPoints=0;
        nbButsMarques=0;
        nbButsEncaisses=0;
        nbVictoires=0;
        nbMatchsNuls=0;
        nbDefaites=0;
        strategie = new StrategieOffensive();
    }

    public boolean isNotreEquipe() {
        return PartieSingleton.INSTANCE.getEntraineur().getEquipe().equals(this);
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

    public Ligue getLigue() {
        return ligue;
    }

    public void setLigue(Ligue ligue) {
        this.ligue = ligue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Equipe)) return false;
        Equipe equipe = (Equipe) o;
        return getBudgetTransferts() == equipe.getBudgetTransferts() &&
                getMasseSalariale() == equipe.getMasseSalariale() &&
                getNbPoints() == equipe.getNbPoints() &&
                getNbButsMarques() == equipe.getNbButsMarques() &&
                getNbButsEncaisses() == equipe.getNbButsEncaisses() &&
                getNbVictoires() == equipe.getNbVictoires() &&
                getNbMatchsNuls() == equipe.getNbMatchsNuls() &&
                getNbDefaites() == equipe.getNbDefaites() &&
                Objects.equals(getNom(), equipe.getNom()) &&
                Objects.equals(getHistoireDuClub(), equipe.getHistoireDuClub()) &&
                Objects.equals(getJoueurs(), equipe.getJoueurs()) &&
                Objects.equals(getEntraineur(), equipe.getEntraineur()) &&
                Objects.equals(getPresident(), equipe.getPresident()) &&
                Objects.equals(getStrategie(), equipe.getStrategie()) &&
                Objects.equals(getHistoriqueSaisons(), equipe.getHistoriqueSaisons()) &&
                Objects.equals(getStade(), equipe.getStade()) &&
                Objects.equals(getLigue(), equipe.getLigue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNom(), getHistoireDuClub(), getBudgetTransferts(), getMasseSalariale(), getNbPoints(), getNbButsMarques(), getNbButsEncaisses(), getNbVictoires(), getNbMatchsNuls(), getNbDefaites(), getJoueurs(), getEntraineur(), getPresident(), getStrategie(), getHistoriqueSaisons(), getStade(), getLigue());
    }

    @Override
    public String toString(){
        return this.nom;
    }

}
