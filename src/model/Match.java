package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Match extends Evenement implements Serializable {
    private Equipe equipe1;

    private Equipe equipe2;

    private Arbitre arbitre;

    private Statistiques statistiques;

    private Stade stade;

    public void jouerMatch() {
    }

    public void executerEvenement() {
    }

    public void apresEvenement() {
    }

    public void avantEvenement() {
    }

    public Equipe getEquipe1() {
        return equipe1;
    }

    public void setEquipe1(Equipe equipe1) {
        this.equipe1 = equipe1;
    }

    public Equipe getEquipe2() {
        return equipe2;
    }

    public void setEquipe2(Equipe equipe2) {
        this.equipe2 = equipe2;
    }

    public Arbitre getArbitre() {
        return arbitre;
    }

    public void setArbitre(Arbitre arbitre) {
        this.arbitre = arbitre;
    }

    public Statistiques getStatistiques() {
        return statistiques;
    }

    public void setStatistiques(Statistiques statistiques) {
        this.statistiques = statistiques;
    }

    public Stade getStade() {
        return stade;
    }

    public void setStade(Stade stade) {
        this.stade = stade;
    }

    public Match(Equipe equipe1, Equipe equipe2, Arbitre arbitre, Stade stade, Date date) {
        super(PartieSingleton.INSTANCE.getEntraineur()!=null && (equipe1.equals(PartieSingleton.INSTANCE.getEntraineur().getEquipe()) ||
                equipe2.equals(PartieSingleton.INSTANCE.getEntraineur().getEquipe())),date);
        this.equipe1 = equipe1;
        this.equipe2 = equipe2;
        this.arbitre = arbitre;
        this.stade = stade;
        //Si this.statistiques == null cela veut dire que le match n'a pas encore eu lieu
        this.statistiques = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Match)) return false;
        Match match = (Match) o;
        return Objects.equals(equipe1, match.equipe1) &&
                        Objects.equals(equipe2, match.equipe2) &&
                        Objects.equals(arbitre, match.arbitre) &&
                        Objects.equals(statistiques, match.statistiques) &&
                        Objects.equals(stade, match.stade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(equipe1, equipe2, arbitre, statistiques, stade);
    }

    @Override
    public String toString() {
        return "Match{" +
                        "equipe1=" + equipe1 +
                        ", equipe2=" + equipe2 +
                        ", arbitre=" + arbitre +
                        ", statistiques=" + statistiques +
                        ", stade=" + stade +
                        '}';
    }

}
