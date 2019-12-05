package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Evenement {
    private boolean importance;

    private Date dateDeLEvenement;

    private boolean tst;

    private static List<Evenement> evenements = new ArrayList<Evenement> ();

    public abstract void avantEvenement();

    public abstract void apresEvenement();

    public abstract void executerEvenement();

}
