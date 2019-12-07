package data;

import model.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataGenerator {
    public static Joueur generateRandomJoueurAtt(){
        final Joueur res = generateRandomJoueur();
        if(!res.getPoste().equals(Poste.ATT)){
            res.setAttaque(90);
            res.setMillieu(80);
            res.setDefense(50);
            res.setPoste(Poste.ATT);
        }return res;
    }

    public static Joueur generateRandomJoueurDef(){
        final Joueur res = generateRandomJoueur();
        if(!res.getPoste().equals(Poste.DEF)){
            res.setAttaque(50);
            res.setMillieu(80);
            res.setDefense(90);
            res.setPoste(Poste.DEF);
        }return res;
    }

    public static Joueur generateRandomJoueurMil(){
        final Joueur res = generateRandomJoueur();
        if(!res.getPoste().equals(Poste.MIL)){
            res.setAttaque(70);
            res.setMillieu(90);
            res.setDefense(60);
            res.setPoste(Poste.MIL);
        }return res;
    }

    public static Joueur generateRandomJoueurGb(){
        final Joueur res = generateRandomJoueur();
        if(!res.getPoste().equals(Poste.GB)){
            res.setAttaque(40);
            res.setMillieu(50);
            res.setDefense(80);
            res.setPoste(Poste.GB);
        }return res;
    }

    public static Joueur generateRandomJoueur(){
        final String id="Joueur_"+(int)(Math.random()*100000);
        final String nom = "Nom_"+id;
        final String prenom = "Prenom_"+id;
        final Date dateDeNaissance = Date.from(Instant.now());
        final String historique ="Historique_"+id;
        final int etatPhysique =100;
        final int moral=100;
        final int poste = (int)(Math.random()*4);
        int defense=0;
        int millieu = 0;
        int attaque = 0;
        final int notePerformancesRecentes=0;
        final int nbButsSaison = 0;
        final int nbPasseDecisiveSaison = 0;
        final int nbCartonJauneSaison = 0;
        final int nbCartonRougeSaison = 0;
        final Poste vraiPoste;
        final Equipe  equipe = null;
        final List< StatistiquesSaisonJoueur > historiqueSaisons=new ArrayList<StatistiquesSaisonJoueur>();
        if(poste==0){
            vraiPoste=Poste.GB;
            defense=80;
            millieu=30;
            attaque=10;
        }else if(poste==1){
            vraiPoste=Poste.DEF;
            defense=90;
            millieu=60;
            attaque=30;
        }else if(poste==2){
            vraiPoste=Poste.MIL;
            defense=70;
            millieu=90;
            attaque=80;
        }else{
            vraiPoste=Poste.ATT;
            defense=20;
            millieu=50;
            attaque=90;
        }
        return new Joueur(nom, prenom, dateDeNaissance, historique, etatPhysique, moral, defense, millieu, attaque,
                notePerformancesRecentes, nbButsSaison, nbPasseDecisiveSaison, nbCartonJauneSaison, nbCartonRougeSaison,
                vraiPoste, equipe, historiqueSaisons);
    }

    public static Stade generateRandomStade(){
        final String id = "Stade_"+(int)(Math.random()*10000);
        return new Stade("nom_"+id, (int)(Math.random()*1000000)+4000, "ville_"+id, "histoire_"+id);
    }

    public static Entraineur generateRandomEntraineur(){
        final String id="Entraineur_"+(int)(Math.random()*100000);
        return new Entraineur( "nom_"+id,  "prenom_"+id, Date.from(Instant.now()),
                "historique_"+id,null);
    }

    public static President generateRandomPresident(){
        final String id = "President_"+(int)(Math.random()*100000);
        return new President( "nom_"+id,"prenom_"+id, Date.from(Instant.now()), "historique_"+id,
                null);
    }

    public static Arbitre generateRandomArbitre(){
        final String id="Arbitre_"+(int)(Math.random()*10000);
        return new Arbitre( "nom_"+id,"prenom_"+id,  Date.from(Instant.now()),"historique_"+id,
                (int)(Math.random()*100));
    }

    public static Equipe generateRandomEquipe(){
        final String id = "Equipe_"+(int)(Math.random()*100000);
        final List<Joueur> joueurs = new ArrayList<Joueur>();
        int i=0;
        for(;i<2;i++){
            joueurs.add(generateRandomJoueurGb());
        }for(i=0;i<6;i++){
            joueurs.add(generateRandomJoueurDef());
        }for(i=0;i<5;i++){
            joueurs.add(generateRandomJoueurMil());
        }for(i=0;i<5;i++){
            joueurs.add(generateRandomJoueurAtt());
        }
        Equipe result =  new Equipe("nom_"+id,"histoireDuClub_"+id,(int)(Math.random()*100000000),
                (int)(Math.random()*100000), joueurs, generateRandomEntraineur(), generateRandomPresident(),
                generateRandomStade(), null);
        for(Joueur j:result.getJoueurs()){
            j.setEquipe(result);
        }
        result.getEntraineur().setEquipe(result);
        result.getPresident().setEquipe(result);
        return result;
    }

    public static Ligue generateRandomLigue(){
        final String id = "Ligue_"+(int)(Math.random()*10000);
        final List<Equipe> equipes = new ArrayList<Equipe>();
        final List<Arbitre> arbitres = new ArrayList<Arbitre>();
        for(int i=0;i<20;i++)equipes.add(generateRandomEquipe());
        for(int i=0;i<20;i++)arbitres.add(generateRandomArbitre());
        Ligue result = new Ligue("nom_"+id, equipes, arbitres);
        for(Equipe e:result.getEquipes())e.setLigue(result);
        return result;
    }

    public static Fifa generateRandomFifa(){
        final List<Ligue> ligues = new ArrayList<Ligue>();
        for(int i=0;i<4;i++){
            ligues.add(generateRandomLigue());
        }
        return new Fifa(ligues);
    }
}
