package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Journee extends Evenement implements Serializable {
    private Date dateJournee;

    private List<Match> matchs = new ArrayList<Match> ();

    public void avantEvenement() {
    }

    public void executerEvenement() {
    }

    public void apresEvenement() {
    }

}
