package model;

import java.io.Serializable;
import java.util.*;
import java.util.List;

public class Ligue implements Serializable {
    private String nom;

    private Calendrier calendrier;

    private List<Equipe> equipes = new ArrayList<Equipe> ();

    private List<Arbitre> arbitres = new ArrayList<Arbitre> ();

    public static List<Ligue> liguesAll = new ArrayList<Ligue>();

    public void initLigue() {
        initCalendrier();
    }

    public String getNom() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.nom;
    }

    public List<Equipe> getEquipes() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.equipes;
    }

    public List<Equipe> getCLassementEquipes() {
        // TODO Auto-generated return
        return null;
    }

    public List<Joueur> getClassementButeurs() {
        // TODO Auto-generated return
        return null;
    }

    public List<Equipe> getClassementEquipesParButsMarques() {
        // TODO Auto-generated return
        return null;
    }

    public List<Equipe> getClassementEquipesParButsEncaisses() {
        // TODO Auto-generated return
        return null;
    }

    public List<Joueur> getClassementJoueursPassesDecisives() {
        // TODO Auto-generated return
        return null;
    }

    public void initCalendrier() {
        System.out.println("init calendrier");
        List<Journee> journees = new ArrayList<Journee>();
        Date today = PartieSingleton.INSTANCE.getDateCourante().getJourCourant();
        if(equipes==null){
            System.err.println("Impossible d'initialiser un calendrier avec la liste des équipes à null");
            return;
        }if(equipes.size()<=1){
            System.err.println("Impossible d'initialiser un calendrier avec la liste des équipes à "+equipes.size()+
                    " éléments");
            return;
        }if(arbitres==null){
            System.err.println("On essaye d'initialiser un calendrier avec une liste d'arbitres null");
            return;
        }if(arbitres.size()<equipes.size()/2){
            System.err.println("Nombre d'arbitres insuffisants pour initialiser un calendrier : "+arbitres.size()+
                    " arbitre pour "+equipes.size()+" equipes");
            return;
        }
        
        for(int i=0; i < equipes.size() -1; i++){
            for(int j=i+1; j<equipes.size(); j++){
                int k;
                for(k=0;k<journees.size();k++){
                    Iterator iter = journees.get(k).getMatchs().iterator();
                    boolean canPlaceIt = true;
                    while(iter.hasNext()){
                        Match cur = (Match)iter.next();
                        if(cur.getEquipe1().equals(equipes.get(i))||cur.getEquipe2().equals(equipes.get(i))){
                            canPlaceIt=false;
                            break;
                        }
                        if(cur.getEquipe1().equals(equipes.get(j))||cur.getEquipe2().equals(equipes.get(j))){
                            canPlaceIt=false;
                            break;
                        }
                    }
                    if(canPlaceIt){
                        Match curMatchAller = new Match(equipes.get(i),equipes.get(j),null,
                                equipes.get(i).getStade(),journees.get(k).getDateJournee());
                        equipes.get(j).getMatchsDeLequipe().add(curMatchAller);
                        equipes.get(i).getMatchsDeLequipe().add(curMatchAller);
                        journees.get(k).getMatchs().add(curMatchAller);
                        break;
                    }
                }
                if(k>=journees.size()) {
                    journees.add(new Journee(today,new ArrayList<Match>()));
                    today = new Date(today.getTime()+(7 * 1000 * 60 * 60 * 24));
                    Match curMatchAller = new Match(equipes.get(i),equipes.get(j),null,
                            equipes.get(i).getStade(),journees.get(k).getDateJournee());
                    equipes.get(j).getMatchsDeLequipe().add(curMatchAller);
                    equipes.get(i).getMatchsDeLequipe().add(curMatchAller);
                    journees.get(k).getMatchs().add(curMatchAller);
                }
            }
        }
        int nbJ = journees.size();
        for(int r=0;r<nbJ;r++){
            journees.add(new Journee(today, new ArrayList<Match>()));
            today = new Date(today.getTime()+(7 * 1000 * 60 * 60 * 24));
            for(Match m:journees.get(r).getMatchs()){
                Match curMatchRetour = new Match(m.getEquipe2(),m.getEquipe1(),null,m.getEquipe2().getStade(),
                        journees.get(journees.size()-1).getDateJournee());
                journees.get(journees.size()-1).getMatchs().add(curMatchRetour);
                m.getEquipe1().getMatchsDeLequipe().add(curMatchRetour);
                m.getEquipe2().getMatchsDeLequipe().add(curMatchRetour);
            }
        }
        
        for(Journee j:journees){
            Collections.shuffle(arbitres);
            for(int i=0;i<j.getMatchs().size();i++){
                j.getMatchs().get(i).setArbitre(arbitres.get(i));
            }
            /*System.out.println(j.getMatchs().size());
            System.out.println(j);*/
        }
        
        if(calendrier==null)calendrier=new Calendrier(journees);
        else calendrier.setJournees(journees);
    }

    public Ligue(String nom, List<Equipe> equipes, List<Arbitre> arbitres) {
        this.nom=nom;
        this.equipes = equipes;
        for(Equipe e:equipes)e.setLigue(this);
        this.arbitres = arbitres;
        this.calendrier = null;
        //On initialise le calendrier dans la init qui initialise le calendrier selon les bonnes règles
        initLigue();
        liguesAll.add(this);
    }

    @Override
    public String toString() {
        return this.nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ligue)) return false;
        Ligue ligue = (Ligue) o;
        return Objects.equals(getNom(), ligue.getNom()) &&
                        Objects.equals(calendrier, ligue.calendrier) &&
                        Objects.equals(getEquipes(), ligue.getEquipes()) &&
                        Objects.equals(arbitres, ligue.arbitres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNom(), calendrier, getEquipes(), arbitres);
    }

}
