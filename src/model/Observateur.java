package model;


public interface Observateur {
    void miseAJour();
    void miseAJour(NotreObservable emetteur);

}
