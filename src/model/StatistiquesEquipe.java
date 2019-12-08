package model;

import java.io.Serializable;

public class StatistiquesEquipe implements Serializable {
    private int nombreDeButsMarques;

    private int possessionDeBalle;

    private int nombreDePasses;

    private Equipe equipe;

    public int getNombreDePasses() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.nombreDePasses;
    }

    public void setNombreDePasses(final int value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.nombreDePasses = value;
    }

}
