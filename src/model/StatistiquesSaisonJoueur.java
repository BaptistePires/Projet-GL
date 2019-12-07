package model;


import java.io.Serializable;

public class StatistiquesSaisonJoueur implements Serializable {
    private int noteGlobale;

    private int nombreDeButs;

    private int nombreDePassesDecisives;

    private int nombreDeCartonsRouges;

    private int nombreDeCartonsJaunes;

    private Joueur joueur;

}
