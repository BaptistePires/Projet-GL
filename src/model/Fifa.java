package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Fifa implements Serializable {
    private List<Ligue> ligues = new ArrayList<Ligue> ();

    private List<Mercato> mercatos = new ArrayList<Mercato> ();

    public void setLigues(List<Ligue> ligues) {
        this.ligues = ligues;
    }

    public List<Mercato> getMercatos() {
        return mercatos;
    }

    public void setMercatos(List<Mercato> mercatos) {
        this.mercatos = mercatos;
    }

    public List<Ligue> getLigues() {
        return ligues;
    }

    public Fifa(List<Ligue> ligues){
        this.ligues = ligues;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fifa)) return false;
        Fifa fifa = (Fifa) o;
        return Objects.equals(getLigues(), fifa.getLigues()) &&
                Objects.equals(getMercatos(), fifa.getMercatos());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLigues(), getMercatos());
    }

    @Override
    public String toString() {
        return "Fifa{" +
                "ligues=" + ligues +
                ", mercatos=" + mercatos +
                '}';
    }
}
