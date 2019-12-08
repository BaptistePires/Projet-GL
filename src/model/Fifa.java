package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Fifa implements Serializable {
    private List<Ligue> ligues = new ArrayList<Ligue> ();

    public List<Ligue> getLigues() {
        return ligues;
    }

    public void setLigues(List<Ligue> ligues) {
        this.ligues = ligues;
    }

    public Fifa(List<Ligue> ligues) {
        this.ligues = ligues;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fifa)) return false;
        Fifa fifa = (Fifa) o;
        return Objects.equals(getLigues(), fifa.getLigues());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLigues());
    }

    @Override
    public String toString() {
        return "Fifa{" +
                        "ligues=" + ligues +
                        '}';
    }

}
