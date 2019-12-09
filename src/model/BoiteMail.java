package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BoiteMail implements Serializable {
    private List<Message> messages = new ArrayList<Message> ();

    public List<Message> getMessages() {
        return messages;
    }

    public void addMessage(Message m) {
        this.messages.add(m);
    }

    public void removeMessage(Message m) {
        messages.remove(m);
    }

}
