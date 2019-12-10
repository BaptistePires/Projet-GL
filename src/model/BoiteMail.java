package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BoiteMail implements Serializable, Observateur {
    private int nombreDeMessagesNonLus = 0;

    private List<Message> messages = new ArrayList<Message> ();

    public int getNombreDeMessagesNonLus() {
        return nombreDeMessagesNonLus;
    }

    public void setNombreDeMessagesNonLus(int nombreDeMessagesNonLus) {
        this.nombreDeMessagesNonLus = nombreDeMessagesNonLus;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void addMessage(Message m) {
        this.messages.add(m);
        nombreDeMessagesNonLus ++;
        m.sabonner(this);
    }

    @Override
    public void miseAJour() {
        nombreDeMessagesNonLus--;
    }

    public void removeMessage(Message m) {
        messages.remove(m);
    }

}
