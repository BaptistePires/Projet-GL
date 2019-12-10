package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Entraineur extends Personne implements Serializable {
    private Equipe equipe;

    public static ArrayList<Entraineur> entraineursAll = new ArrayList<Entraineur>();

    public void initEntraineur() {
    }

    public Entraineur(String nom, String prenom, Date dateDeNaissance, String historique) {
        super(nom, prenom, dateDeNaissance, historique);
        entraineursAll.add(this);
    }

    public Entraineur(String nom, String prenom, Date dateDeNaissance, String historique, Equipe equipe) {
        this(nom, prenom, dateDeNaissance, historique);
        this.equipe = equipe;
        if(equipe!=null){
            if(equipe.getEntraineur()!=null)equipe.getEntraineur().setEquipe(null);
            equipe.setEntraineur(this);
            for(Match m : equipe.getMatchsDeLequipe())m.setImportance(true);
        }
    }

    public Equipe getEquipe() {
        return this.equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entraineur)) return false;
        Entraineur that = (Entraineur) o;
        return Objects.equals(getEquipe(), that.getEquipe());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEquipe());
    }

    @Override
    public String toString() {
        return getNom();
    }

    public boolean demanderBudgetTransfert() {
        return this.getEquipe().getPresident().traiterDemanderBudgetTransfert();
    }

    public boolean demanderBudgetMasseSalariale() {
        return getEquipe().getPresident().traiterDemandeMasseSalariale();
    }

    public boolean demanderBudgetTeamBuilding() {
        return getEquipe().getPresident().traiterDemandeTeamBuilding();
    }

}
