package model;

import java.io.Serializable;
import java.util.Date;

public class ContratFactory implements Serializable {
    public Contrat generateContract(final Date dateDebut, final Date dateFin, final int montantDuTransfert,
                                    final int salaireAnnuelEuro, final Personne personne, final Equipe equipeSource,
                                    final Equipe equipeDestination) {
        return new Contrat(dateDebut, dateFin, montantDuTransfert, salaireAnnuelEuro, personne, equipeSource, equipeDestination);
    }

}
