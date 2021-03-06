package model;

import java.io.Serializable;
import java.util.Date;

public class Message extends NotreObservable implements Serializable {
    private String contenu;

    private boolean lu = false;

    private String titre;

    private Date date;

    public Message() {
        super();
        lu = false;
    }

    public Message(String contenu, String titre, Date date) {
        super();
        this.contenu = contenu;
        this.titre = titre;
        this.date = date;
    }

    public String getContenu() {
        return contenu;
    }

    public void setLu() {
        if(!lu){
            notifier();
            lu = true;
        }
    }

    public String getTitre() {
        return titre;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return titre;
    }

}
