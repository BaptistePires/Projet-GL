package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Statistiques implements Serializable {
    private StatistiquesEquipe statistiquesEquipeB;

    private StatistiquesEquipe statistiquesEquipeA;

    private List<StatistiquesJoueur> statistiquesJoueursA = new ArrayList<StatistiquesJoueur> ();

    private List<StatistiquesJoueur> statistiquesJoueursB = new ArrayList<StatistiquesJoueur> ();

    public void apresMatchMiseAJour() {
    }

}
