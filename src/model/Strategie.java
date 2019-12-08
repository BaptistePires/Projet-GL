package model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.TreeMap;

public abstract class Strategie implements Serializable {
    private int agressivite;

    private int passes;

    private int defense;

    private int milieu;

    private int attaque;

     HashMap<Joueur, Poste> formation = new HashMap<Joueur, Poste>();

    public void placerJoueur(final Joueur joueur, final int indexPosition) {
    }

    public int indexDuJoueur(final Joueur joueur) {
        // TODO Auto-generated return
        return 0;
    }

    public void permuterJoueurs(final Joueur joueur1, final Joueur joueur2) {
    }

    public abstract void appliquer();

    public static Strategie pickRandomStrategie() {
        if(Math.random()<0.5){
            return new StrategieDefensive();
        }else return new StrategieDefensive();
    }

    public int getAgressivite() {
        return agressivite;
    }

    public void setAgressivite(int agressivite) {
        this.agressivite = agressivite;
    }

    public int getPasses() {
        return passes;
    }

    public void setPasses(int passes) {
        this.passes = passes;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getMilieu() {
        return milieu;
    }

    public void setMilieu(int milieu) {
        this.milieu = milieu;
    }

    public int getAttaque() {
        return attaque;
    }

    public void setAttaque(int attaque) {
        this.attaque = attaque;
    }

    public HashMap<Joueur, Poste> getFormation() {
        return formation;
    }

    public void setFormation(HashMap<Joueur, Poste> formation) {
        this.formation = formation;
    }

}
