package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Contrat implements Serializable {

    public Contrat(Date dateDebut, Date dateFin, int montantDuTransfert, int salaireAnnuelEuro, Personne personne, Equipe equipeSource, Equipe equipeDestination){
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.montantDuTransfert = montantDuTransfert;
        this.salaireAnnuelEuro = salaireAnnuelEuro;
        this.accepte = false;
        this.equipeSource = equipeSource;
        this.equipeDestination = equipeDestination;
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

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public int getSalaireAnnuelEuro() {
        return salaireAnnuelEuro;
    }

    public void setSalaireAnnuelEuro(int salaireAnnuelEuro) {
        this.salaireAnnuelEuro = salaireAnnuelEuro;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public void setMontantDuTransfert(int montantDuTransfert) {
        this.montantDuTransfert = montantDuTransfert;
    }

    public boolean isAccepte() {
        return accepte;
    }

    public void setAccepte(boolean accepte) {
        this.accepte = accepte;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public List<Contrat> getHistoriqueRenouvellements() {
        return historiqueRenouvellements;
    }

    public void setHistoriqueRenouvellements(List<Contrat> historiqueRenouvellements) {
        this.historiqueRenouvellements = historiqueRenouvellements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contrat)) return false;
        Contrat contrat = (Contrat) o;
        return getSalaireAnnuelEuro() == contrat.getSalaireAnnuelEuro() &&
                getMontantDuTransfert() == contrat.getMontantDuTransfert() &&
                isAccepte() == contrat.isAccepte() &&
                Objects.equals(getDateDebut(), contrat.getDateDebut()) &&
                Objects.equals(getDateFin(), contrat.getDateFin()) &&
                Objects.equals(getPersonne(), contrat.getPersonne()) &&
                Objects.equals(getEquipeDestination(), contrat.getEquipeDestination()) &&
                Objects.equals(getEquipeSource(), contrat.getEquipeSource()) &&
                Objects.equals(getHistoriqueRenouvellements(), contrat.getHistoriqueRenouvellements());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDateDebut(), getSalaireAnnuelEuro(), getDateFin(), getMontantDuTransfert(), isAccepte(), getPersonne(), getEquipeDestination(), getEquipeSource(), getHistoriqueRenouvellements());
    }

    @Override
    public String toString() {
        return "Contrat{" +
                "dateDebut=" + dateDebut +
                ", salaireAnnuelEuro=" + salaireAnnuelEuro +
                ", dateFin=" + dateFin +
                ", montantDuTransfert=" + montantDuTransfert +
                ", accepte=" + accepte +
                ", personne=" + personne +
                ", equipeDestination=" + equipeDestination +
                ", equipeSource=" + equipeSource +
                ", historiqueRenouvellements=" + historiqueRenouvellements +
                '}';
    }
}
