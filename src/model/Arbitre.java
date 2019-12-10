package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Arbitre extends Personne implements Serializable {
    private int severite;

    public static ArrayList<Arbitre> arbitresAll = new ArrayList<Arbitre>();

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

    public static ArrayList<Arbitre> getArbitresAll() {
        return arbitresAll;
    }

    public static void setArbitresAll(ArrayList<Arbitre> arbitresAll) {
        Arbitre.arbitresAll = arbitresAll;
    }

    @Override
    public String toString() {
        return getNom()+" "+getPrenom();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Arbitre)) return false;
        if (!super.equals(o)) return false;
        Arbitre arbitre = (Arbitre) o;
        return getSeverite() == arbitre.getSeverite();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getSeverite());
    }

}
