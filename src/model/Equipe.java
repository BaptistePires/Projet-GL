package model;

import java.util.ArrayList;
import java.util.List;

public class Equipe {
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

}
