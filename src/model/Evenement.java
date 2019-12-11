package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

public abstract class Evenement implements Serializable {
    private boolean importance;

    private Date dateDeLEvenement;

    public static TreeMap<Date, List<Evenement>> evenements = new TreeMap<Date, List<Evenement>>();

    public abstract void avantEvenement();

    public abstract void apresEvenement();

    public abstract void executerEvenement();

    public static List<Evenement> getEvenementsPourLaDate(Date date) {
        return evenements.get(date);
    }

    public boolean isImportance() {
        return importance;
    }

    public void setImportance(boolean importance) {
        this.importance = importance;
    }

    public Date getDateDeLEvenement() {
        return dateDeLEvenement;
    }

    public void setDateDeLEvenement(Date dateDeLEvenement) {
        this.dateDeLEvenement = dateDeLEvenement;
    }

    public boolean getImportance() {
        return importance;
    }

    public void processEvenement() {
        avantEvenement();
        executerEvenement();
        apresEvenement();
    }

    public Evenement(boolean importance, Date dateDeLEvenement) {
        this.importance = importance;
        this.dateDeLEvenement = dateDeLEvenement;
        evenements.putIfAbsent(dateDeLEvenement, new ArrayList<Evenement>());
        evenements.get(dateDeLEvenement).add(this);
        //System.out.println(dateDeLEvenement);
    }
}
