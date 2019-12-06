package model;

import java.util.Date;

public class President extends Personne {
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

}
