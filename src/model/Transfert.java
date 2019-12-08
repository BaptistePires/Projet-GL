package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Transfert extends Evenement implements Serializable {
    private Contrat contrat;

    public void avantEvenement() {
    }

    public void executerEvenement() {
    }

    public void apresEvenement() {
    }

    public Contrat getContrat() {
        return contrat;
    }

    public void setContrat(Contrat contrat) {
        this.contrat = contrat;
    }

    public Transfert(Date date, Contrat contrat) {
        super(false, date);
        this.contrat = contrat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transfert)) return false;
        Transfert transfert = (Transfert) o;
        return Objects.equals(getContrat(), transfert.getContrat());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getContrat());
    }

    @Override
    public String toString() {
        return "Transfert{" +
                        "contrat=" + contrat +
                        '}';
    }

}
