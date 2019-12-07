package model;


import java.io.Serializable;
import java.util.Date;

public class Information extends Evenement implements Serializable {
    public void avantEvenement() {
    }

    public void executerEvenement() {
    }

    public void apresEvenement() {
    }

    String description;


    public Information(String description, Date date){
        super(false, date);
        this.description = description;
    }

}
