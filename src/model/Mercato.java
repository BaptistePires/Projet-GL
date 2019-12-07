package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Mercato extends Evenement implements Serializable {
    private Date dateDebut;

    private Date dateFin;

    private List<Transfert> transferts = new ArrayList<Transfert> ();

    private ContratFactory contratFactory;

    public void avantEvenement() {
    }

    public void executerEvenement() {
    }

    public void apresEvenement() {
    }

}
