package model;

import java.util.ArrayList;
import java.util.List;

public class NotreObservable {
    private List<Observateur> abonnes = new ArrayList<Observateur>();

    public void sabonner(Observateur o) {
        abonnes.add(o);
    }

    public void seDesabonner(Observateur o) {
        abonnes.remove(o);
    }

    public void notifier() {
        for(Observateur o:abonnes)o.miseAJour();
    }
    public void notifier(NotreObservable x){for(Observateur o:abonnes)o.miseAJour(x);}

}
