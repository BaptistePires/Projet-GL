package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Ligue implements Serializable {
    public static List<Ligue> liguesAll = new ArrayList<Ligue>();

    private String nom;

    private Calendrier calendrier;

    private List<Equipe> equipes = new ArrayList<Equipe> ();

    private List<Arbitre> arbitres = new ArrayList<Arbitre> ();

    public Ligue(String nom, Calendrier calendrier, List<Equipe> equipes, List<Arbitre> arbitres){
        this.nom=nom;
        this.calendrier = calendrier;
        this.equipes = equipes;
        for(Equipe e:equipes)e.setLigue(this);
        this.arbitres = arbitres;
        initLigue();
        liguesAll.add(this);
    }

    public void initLigue() {
        if(calendrier==null){
            initCalendrier();
        }
    }

    public String getNom() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.nom;
    }

    public List<Equipe> getEquipes() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.equipes;
    }

    public List<Equipe> getCLassementEquipes() {
        // TODO Auto-generated return
        return null;
    }

    public List<Joueur> getClassementButeurs() {
        // TODO Auto-generated return
        return null;
    }

    public List<Equipe> getClassementEquipesParButsMarques() {
        // TODO Auto-generated return
        return null;
    }

    public List<Equipe> getClassementEquipesParButsEncaisses() {
        // TODO Auto-generated return
        return null;
    }

    public List<Joueur> getClassementJoueursPassesDecisives() {
        // TODO Auto-generated return
        return null;
    }

    public void initCalendrier() {
    }

    public void afficherInfosLigue() {
    }

}
