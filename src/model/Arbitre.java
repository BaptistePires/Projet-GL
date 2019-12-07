package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Arbitre extends Personne implements Serializable {
    public static ArrayList<Arbitre> arbitresAll = new ArrayList<Arbitre>();

    private int severite;

    public void initArbitre() {
    }

    public Arbitre(String nom, String prenom, Date dateDeNaissance, String historique) {
        super(nom, prenom, dateDeNaissance, historique);
    }

    public Arbitre(String nom, String prenom, Date dateDeNaissance, String historique, int severite) {
        this(nom, prenom, dateDeNaissance, historique);
        this.severite = severite;
    }

    public int getSeverite() {
        return severite;
    }

    public void setSeverite(int valeur) {
        this.severite = valeur;
    }

}
