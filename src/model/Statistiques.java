package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Statistiques implements Serializable {
    private StatistiquesEquipe statistiquesEquipeB;

    private StatistiquesEquipe statistiquesEquipeA;

    private List<StatistiquesJoueur> statistiquesJoueursA = new ArrayList<StatistiquesJoueur> ();

    private List<StatistiquesJoueur> statistiquesJoueursB = new ArrayList<StatistiquesJoueur> ();

    public void apresMatchMiseAJour() {
    }

    public Statistiques(StatistiquesEquipe statistiquesEquipeB, StatistiquesEquipe statistiquesEquipeA, List<StatistiquesJoueur> statistiquesJoueursA, List<StatistiquesJoueur> statistiquesJoueursB) {
        this.statistiquesEquipeB = statistiquesEquipeB;
        this.statistiquesEquipeA = statistiquesEquipeA;
        this.statistiquesJoueursA = statistiquesJoueursA;
        this.statistiquesJoueursB = statistiquesJoueursB;
    }

    public StatistiquesEquipe getStatistiquesEquipeB() {
        return statistiquesEquipeB;
    }

    public void setStatistiquesEquipeB(StatistiquesEquipe statistiquesEquipeB) {
        this.statistiquesEquipeB = statistiquesEquipeB;
    }

    public StatistiquesEquipe getStatistiquesEquipeA() {
        return statistiquesEquipeA;
    }

    public void setStatistiquesEquipeA(StatistiquesEquipe statistiquesEquipeA) {
        this.statistiquesEquipeA = statistiquesEquipeA;
    }

    public List<StatistiquesJoueur> getStatistiquesJoueursA() {
        return statistiquesJoueursA;
    }

    public void setStatistiquesJoueursA(List<StatistiquesJoueur> statistiquesJoueursA) {
        this.statistiquesJoueursA = statistiquesJoueursA;
    }

    public List<StatistiquesJoueur> getStatistiquesJoueursB() {
        return statistiquesJoueursB;
    }

    public void setStatistiquesJoueursB(List<StatistiquesJoueur> statistiquesJoueursB) {
        this.statistiquesJoueursB = statistiquesJoueursB;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Statistiques)) return false;
        Statistiques that = (Statistiques) o;
        return Objects.equals(getStatistiquesEquipeB(), that.getStatistiquesEquipeB()) &&
                        Objects.equals(getStatistiquesEquipeA(), that.getStatistiquesEquipeA()) &&
                        Objects.equals(getStatistiquesJoueursA(), that.getStatistiquesJoueursA()) &&
                        Objects.equals(getStatistiquesJoueursB(), that.getStatistiquesJoueursB());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStatistiquesEquipeB(), getStatistiquesEquipeA(), getStatistiquesJoueursA(), getStatistiquesJoueursB());
    }

    @Override
    public String toString() {
        return "Statistiques{" +
                        "statistiquesEquipeB=" + statistiquesEquipeB +
                        ", statistiquesEquipeA=" + statistiquesEquipeA +
                        ", statistiquesJoueursA=" + statistiquesJoueursA +
                        ", statistiquesJoueursB=" + statistiquesJoueursB +
                        '}';
    }

}
