package model;

import java.util.Date;

public class Entraineur extends Personne {
    private Equipe equipe;

    public void initEntraineur() {
    }

    public Entraineur(String nom, String prenom, Date dateDeNaissance, String historique){
        super(nom, prenom, dateDeNaissance, historique);
    }

    public Entraineur(String nom, String prenom, Date dateDeNaissance, String historique, Equipe equipe){
        this(nom, prenom, dateDeNaissance, historique);
        this.equipe = equipe;
        equipe.setEntraineur(this);
    }

    public Equipe getEquipe(){
        return this.equipe;
    }

    public void setEquipe(Equipe equipe){
        this.equipe = equipe;
    }
}
