package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Calendrier implements Serializable {
    private List<Journee> journees = new ArrayList<Journee> ();

    public Calendrier(List<Journee> journees) {
        this.journees = journees;
    }

    public List<Journee> getJournees() {
        return journees;
    }

    public void setJournees(List<Journee> journees) {
        this.journees = journees;
    }

    @Override
    public String toString() {
        return "Calendrier{" +
                                "journees=" + journees +
                                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Calendrier)) return false;
        Calendrier that = (Calendrier) o;
        return Objects.equals(getJournees(), that.getJournees());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getJournees());
    }

}
