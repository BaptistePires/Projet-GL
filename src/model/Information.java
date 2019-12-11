package model;

import java.io.Serializable;
import java.util.Date;

public class Information extends Evenement implements Serializable {
    private String description;

    private String titre;

    public void avantEvenement() {
    }

    public void executerEvenement() {
        PartieSingleton.INSTANCE.getBoiteMail().addMessage(new Message(titre,description,getDateDeLEvenement()));
        //System.out.println(PartieSingleton.INSTANCE.getBoiteMail().getMessages());
    }

    public void apresEvenement() {
    }

    private Information(String description, String titre, Date date) {
        super(false, date);
        this.description = description;
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public static Information generateInformation(String description, String titre, Date date) {
        return new Information(description, titre, date);
    }

}
