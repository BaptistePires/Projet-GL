package model;

import ihm.controllers.MatchController;
import ihm.controllers.StrategieController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.io.Serializable;
import java.util.*;

public class Match extends Evenement implements Serializable, Observateur{
    private Equipe equipe1;

    private Equipe equipe2;

    private Arbitre arbitre;

    private Statistiques statistiques;

    private Stade stade;

    public void jouerMatch() {
        StatistiquesEquipe sEq1;
        StatistiquesEquipe sEq2;

        List<StatistiquesJoueur> sjEq1 = new ArrayList<StatistiquesJoueur>();
        List<StatistiquesJoueur> sjEq2 = new ArrayList<StatistiquesJoueur>();

        final int nbB1 = (int)(Math.random()*6);
        int cptB1=0;
        final int nbB2 = 100 - nbB1;
        int cptB2=0;
        final int poss1 = (int)(Math.random()*6);
        final int poss2 = 100 - poss1;
        final int nbPasses1 = (int)(Math.random()*1000);
        final int nbPasses2 = (int)(Math.random()*1000);
        sEq1 = new StatistiquesEquipe(nbB1, nbB2, poss1, nbPasses1, equipe1);
        sEq2 = new StatistiquesEquipe(nbB2, nbB1, poss2, nbPasses2, equipe2);
        List<Joueur> jrs = new ArrayList<Joueur> (equipe1.getStrategie().getFormation());
        Collections.shuffle(jrs);
        for(Joueur j: jrs){
            int bJ=0;
            if(cptB1<nbB1){
                bJ=1;
                cptB1++;
                if(cptB1<nbB1)if(Math.random()<0.05){
                    cptB1++;
                    bJ++;
                }
            }
            final int noteJ = (int)(Math.random()*10);
            final int cJJoueur  = (int)(Math.random()*2);
            final int cRJoueur = (int)(Math.random()*1);
            StatistiquesJoueur sj = new StatistiquesJoueur(bJ,0,cJJoueur,cRJoueur,noteJ,j);
            sjEq1.add(sj);
        }


        List<Joueur> jrs2 = new ArrayList<Joueur> (equipe2.getStrategie().getFormation());
        Collections.shuffle(jrs2);
        for(Joueur j: jrs2){
            int bJ=0;
            if(cptB2<nbB2){
                bJ=1;
                cptB2++;
                if(cptB2<nbB2)if(Math.random()<0.05){
                    cptB2++;
                    bJ++;
                }
            }
            final int noteJ = (int)(Math.random()*10);
            final int cJJoueur  = (int)(Math.random()*2);
            final int cRJoueur = (int)(Math.random()*1);
            StatistiquesJoueur sj = new StatistiquesJoueur(bJ,0,cJJoueur,cRJoueur,noteJ,j);
            sjEq2.add(sj);
        }
        setStatistiques(new Statistiques(sEq1, sEq2, sjEq1,sjEq2));
        statistiques.apresMatchMiseAJour();
        System.out.println("Match opposant :"+equipe1.getNom()+" "+equipe1.getNbPoints()+" à "+equipe2.getNom()+" "+equipe2.getNbPoints());
    }

    public void miseAJour(){

    }
    public void miseAJour(NotreObservable o){
        if(o instanceof StrategieController){
            o.seDesabonner(this);
            GridPane ecranDuJeu = (GridPane)Main.mainStage.getScene().getRoot();
            Pane p=null;
            for(Node c:ecranDuJeu.getChildren()){
                if(GridPane.getColumnIndex(c)==1 && GridPane.getRowIndex(c)==1){
                    p=(Pane)c;
                    break;
                }
            }
            if(p==null){
                System.err.println("Echec de chargement du match");
                return;
            }
            try{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../ihm/match.fxml"));
                GridPane matchEcran = (GridPane) fxmlLoader.load();
                MatchController c = fxmlLoader.<MatchController>getController();
                c.setMatch(this);
                p.getChildren().clear();
                p.getChildren().add(matchEcran);
            }catch(Exception e){
                e.printStackTrace();
                System.err.println("Erreur lors du chargement de l fenetre stratégie");
            }

        }
    }

    public void executerEvenement() {
        if(isImportance()){
            GridPane ecranDuJeu = (GridPane)Main.mainStage.getScene().getRoot();
            Pane p=null;
            /*for(Node c:ecranDuJeu.getChildren()){
                if(GridPane.getColumnIndex(c)==1 && GridPane.getRowIndex(c)==1){
                    p=(Pane)c;
                    break;
                }
            }*/
            p = (Pane) ecranDuJeu.getChildren().get(3);
            if(p==null){
                System.err.println("Echec de chargement de la strategie");
                return;
            }
            try{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../ihm/strategie.fxml"));
                GridPane strategieEcran = (GridPane) fxmlLoader.load();
                StrategieController c = fxmlLoader.<StrategieController>getController();
                c.sabonner(this);
                p.getChildren().clear();
                p.getChildren().add(strategieEcran);
            }catch(Exception e){
                e.printStackTrace();
                System.err.println("Erreur lors du chargement de l fenetre stratégie");
            }
        }else{
            jouerMatch();
        }
    }

    public void apresEvenement() {
        if(isImportance()){
            PartieSingleton.INSTANCE.getBoiteMail().addMessage(new Message("Un Match s'est passé, il a opposé "+equipe1.getNom()+" à "
                    +equipe2.getNom(),"Un match s'est déroulé le", getDateDeLEvenement()));
        }
    }

    public void avantEvenement() {
        if(isImportance()){
            PartieSingleton.INSTANCE.getBoiteMail().addMessage(new Message("Un Match arrive, il opposera "+equipe1.getNom()+" à "
                    +equipe2.getNom(),"Un match arrive", getDateDeLEvenement()));
        }
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
        //Information.generateInformation("Un Match arrive, il opposera "+equipe1.getNom()+" à "
        //        +equipe2.getNom(),"Un match arrive", getDateDeLEvenement());
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
