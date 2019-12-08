package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class President extends Personne implements Serializable {
    public static ArrayList<President> presidentsAll= new ArrayList<President>();

    private int degreDeSatisfaction;

    private Equipe equipe;

    public boolean objectifFixeALentraineurAtteint() {
        // TODO Auto-generated return
        return false;
    }

    public void limogerEntraineur() {
    }

    public President(String nom, String prenom, Date dateDeNaissance, String historique) {
        super(nom, prenom, dateDeNaissance, historique);
    }

    public President(String nom, String prenom, Date dateDeNaissance, String historique, Equipe e) {
        this(nom, prenom, dateDeNaissance, historique);
        this.equipe = equipe;
        if(equipe!=null){
            if(equipe.getPresident()!=null)equipe.getPresident().setEquipe(null);
            equipe.setPresident(this);
        }
        this.degreDeSatisfaction = 0;
    }

    public Equipe getEquipe() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.equipe;
    }

    public void setEquipe(Equipe value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.equipe = value;
    }

    public int getDegreDeSatisfaction() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.degreDeSatisfaction;
    }

    public void setDegreDeSatisfaction(int value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.degreDeSatisfaction = value;
    }

    public void afficherInfosPresident() {
    }

    public boolean traiterDemanderBudgetTransfert() {
        Random r = new Random();
        if(r.nextBoolean()) {
            int tempBudget = getEquipe().getBudgetTransferts();
            int augmentation = r.nextInt(30 - 10) -10;
            tempBudget *= augmentation;
            getEquipe().setBudgetTransferts(tempBudget);
            return true;
        }else{
            return false;
        }
    }

    public boolean traiterDemandeMasseSalariale() {
        Random r = new Random();
        if(r.nextBoolean()) {
            int tempMasse = getEquipe().getMasseSalariale();
            int augmentation = r.nextInt(30 - 10) -10;
            tempMasse *= augmentation;
            getEquipe().setMasseSalariale(tempMasse);
            return true;
        }else{
            return false;
        }
    }

    public boolean traiterDemandeTeamBuilding() {
        Random r = new Random();
        if(r.nextBoolean()) {
            int tempTeamBuilding = getEquipe().getBudgetTeamBuilding();
            int augmentation = r.nextInt(30 - 10) -10;
            tempTeamBuilding *= augmentation;
            getEquipe().setBudgetTeamBuilding(tempTeamBuilding);
            return true;
        }else{
            return false;
        }
    }
}
