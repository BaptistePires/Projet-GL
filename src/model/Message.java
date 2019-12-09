package model;

import java.io.Serializable;

public class Message implements Serializable  {
    private String contenu;
    private String titre;

    public Message() {
        super();
        lu = false;
    }

    public Message(String contenu, String titre) {
        super();
        this.contenu = contenu;
        this.titre = titre;
    }
    private boolean lu;

    public void lire() {
    }

    public String getTitre(){
        return titre;
    }
    public String getContenu() {
        return contenu;
    }

    public void setLu(){
        lu = true;
    }

}
