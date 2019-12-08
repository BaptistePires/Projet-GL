package model;


import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;

public abstract class Strategie implements Serializable {

    HashMap<Joueur,Poste> formation=new HashMap<Joueur, Poste>();


    private int agressivite;

    private int passes;

    private int defense;

    private int milieu;

    private int attaque;

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


    public void placerJoueur(final Joueur joueur, final int indexPosition) {
    }

    public void permuterJoueurs(final Joueur joueur1, final Joueur joueur2) {
    }

    public static void pickRandomStrategie(Equipe e){
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

    public abstract void appliquer();

}
