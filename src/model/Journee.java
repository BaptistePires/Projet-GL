package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Journee extends Evenement implements Serializable {
    private Date dateJournee;

    private List<Match> matchs = new ArrayList<Match> ();

    public void avantEvenement() {
    }

    public void executerEvenement() {
    }

    public void apresEvenement() {
    }

    public Date getDateJournee() {
        return dateJournee;
    }

    public void setDateJournee(Date dateJournee) {
        this.dateJournee = dateJournee;
    }

    public List<Match> getMatchs() {
        return matchs;
    }

    public void setMatchs(List<Match> matchs) {
        this.matchs = matchs;
    }

    public Journee(Date dateJournee, List<Match> matchs) {
        super(false, dateJournee);
        this.dateJournee = dateJournee;
        this.matchs = matchs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Journee)) return false;
        Journee journee = (Journee) o;
        return Objects.equals(getDateJournee(), journee.getDateJournee()) &&
                                        Objects.equals(getMatchs(), journee.getMatchs());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDateJournee(), getMatchs());
    }

    @Override
    public String toString() {
        return "Journee{" +
                                        "dateJournee=" + dateJournee +
                                        ", matchs=" + matchs +
                                        '}';
    }

}
