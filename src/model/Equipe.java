package model;

import java.util.ArrayList;
import java.util.List;

public class Equipe {
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

}
