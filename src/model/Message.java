package model;

import java.io.Serializable;
import java.util.Date;

public class Message extends NotreObservable implements Serializable {
    private String contenu;
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
    private boolean lu=false;

    public void lire() {
    }

    public String getTitre(){
        return titre;
    }
    public String getContenu() {
        return contenu;
    }
    public Date getDate(){ return date;}
    public void setLu(){
        if(!lu){
            notifier();
            lu = true;
        }
    }
    @Override
    public String toString(){
        return titre;
    }

}
