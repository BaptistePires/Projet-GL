package model;

import java.io.Serializable;

public class Message implements Serializable {
    private String contenu;

    private boolean lu;

    public void lire() {
    }

    public Message() {
        super();
        lu = false;
    }

    public Message(String contenu) {
        super();
        this.contenu = contenu;
    }

    public String getContenu() {
        return contenu;
    }

    public void setLu() {
        lu = true;
    }

}
