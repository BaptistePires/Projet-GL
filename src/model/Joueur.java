package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Joueur extends Personne {
    private int etatPhysique;

    private int moral;

    private int defense;

    private int millieu;

    private int attaque;

    private int notePerformancesRecentes;

    private String nbButsSaison;

    private String nbPasseDecisiveSaison;

    private int nbCartonJauneSaison;

    private int nbCartonRougeSaison;

    private List<Poste> poste = new ArrayList<Poste> ();

    private Equipe equipe;

    private List<StatistiquesSaisonJoueur> historiqueSaisons = new ArrayList<StatistiquesSaisonJoueur> ();

    public boolean etudierOffreTransfert(final Contrat contratPropose) {
        // TODO Auto-generated return
        return false;
    }

    public void initJoueur() {
    }

    public Joueur(String nom, String prenom, Date dateDeNaissance, String historique,int etatPhysique, int moral,
                  int defense, int millieu, int attaque, int notePerformancesRecentes, String nbButsSaison,
                  String nbPasseDecisiveSaison, int nbCartonJauneSaison, int nbCartonRougeSaison, List<Poste> poste,
                  Equipe equipe, List<StatistiquesSaisonJoueur> historiqueSaisons){
        super(nom, prenom, dateDeNaissance, historique);
        configure(etatPhysique, moral, defense, millieu, attaque, notePerformancesRecentes, nbButsSaison,
                nbPasseDecisiveSaison, nbCartonJauneSaison, nbCartonRougeSaison,
                poste, equipe, historiqueSaisons);
    }

    public Joueur(String nom, String prenom, Date dateDeNaissance, String historique){
        super(nom, prenom, dateDeNaissance, historique);
    }

    public void configure(int etatPhysique, int moral, int defense, int millieu, int attaque, int notePerformancesRecentes,
                     String nbButsSaison, String nbPasseDecisiveSaison, int nbCartonJauneSaison, int nbCartonRougeSaison,
                     List<Poste> poste, Equipe equipe, List<StatistiquesSaisonJoueur> historiqueSaisons){
        this.etatPhysique = etatPhysique;
        this.moral = moral;
        this.defense = defense;
        this.millieu = millieu;
        this.attaque = attaque;
        this.notePerformancesRecentes = notePerformancesRecentes;
        this.nbButsSaison = nbButsSaison;
        this.nbPasseDecisiveSaison = nbPasseDecisiveSaison;
        this.nbCartonJauneSaison = nbCartonJauneSaison;
        this.nbCartonRougeSaison = nbCartonRougeSaison;
        this.poste = poste;
        this.equipe = equipe;
        this.historiqueSaisons = historiqueSaisons;
    }

}
