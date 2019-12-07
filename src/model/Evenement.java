package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

public abstract class Evenement implements Serializable {
    public static TreeMap<Date, List<Evenement>> evenements = new TreeMap<Date, List<Evenement>>();

    private boolean importance;

    private Date dateDeLEvenement;

    private boolean tst;

    public static List<Evenement> getEvenementsPourLaDate(Date date) {
        return evenements.get(date);
    }

    public boolean getImportance() {
        return importance;
    }

    public void processEvenement() {
        avantEvenement();
        executerEvenement();
        apresEvenement();
    }

    public abstract void avantEvenement();

    public abstract void apresEvenement();

    public abstract void executerEvenement();

}
