package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contrat implements Serializable {
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

}
