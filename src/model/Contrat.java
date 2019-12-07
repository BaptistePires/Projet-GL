package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contrat implements Serializable {

    public Contrat(Date dateDebut, Date dateFin, int montantDuTransfert, int salaireAnnuelEuro){
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.montantDuTransfert = montantDuTransfert;
        this.salaireAnnuelEuro = salaireAnnuelEuro;
        this.accepte = false;

    }

    private Date dateDebut;

    private int salaireAnnuelEuro;

    private Date dateFin;

    private int montantDuTransfert;

    private boolean accepte;

    private Personne personne;

    private Equipe equipeDestination;

    private Equipe equipeSource;

    private List<Contrat> historiqueRenouvellements = new ArrayList<Contrat> ();

    public Information renouveler(final Date dateDebut, final String dateFin, final int salaireAnnuelEuro, final int montant) {
        // TODO Auto-generated return
        return null;
    }

    public boolean getAccepte() {
        return accepte;
    }

    public void setEquipeDestination(Equipe e) {
        equipeDestination = e;
    }

    public void setEquipeSource(Equipe e) {
        equipeSource = e;
    }

    public Equipe getEquipeDestination() {
        return equipeDestination;
    }

    public Equipe getEquipeSource() {
        return equipeSource;
    }

    public int getMontantDuTransfert() {
        return montantDuTransfert;
    }
}
