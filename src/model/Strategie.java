package model;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;
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

    public static void pickRandomStrategie(Equipe e) {
        Strategie s;
        if(Math.random()<0.5){
            s= new StrategieDefensive();
        }else s= new StrategieDefensive();
        HashMap<Joueur, Poste> f = new HashMap<Joueur, Poste>();
        for(int i =0;i<e.getJoueurs().size();i++){
            if(e.getJoueurs().get(i).getPoste().equals(Poste.GB)){
                f.putIfAbsent(e.getJoueurs().get(i),Poste.GB);
                break;
            }
        }
        Collections.shuffle(e.getJoueurs());
        int added = 0;
        for(Joueur j:e.getJoueurs()){
            if(added==11)break;
            if(!j.getPoste().equals(Poste.GB)){
                added++;
                f.putIfAbsent(j,j.getPoste());
            }
        }
        s.setFormation(f);
        e.setStrategie(s);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Strategie)) return false;
        Strategie strategie = (Strategie) o;
        return getAgressivite() == strategie.getAgressivite() &&
                        getPasses() == strategie.getPasses() &&
                        getDefense() == strategie.getDefense() &&
                        getMilieu() == strategie.getMilieu() &&
                        getAttaque() == strategie.getAttaque() &&
                        Objects.equals(getFormation(), strategie.getFormation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFormation(), getAgressivite(), getPasses(), getDefense(), getMilieu(), getAttaque());
    }

    @Override
    public String toString() {
        return getClass().toString();
    }

}
