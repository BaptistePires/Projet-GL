package model;


public abstract class Strategie {
    private int agressivite;

    private int passes;

    private int defense;

    private int milieu;

    private int attaque;

    private String nbDefenseurs;

    private String nbMilieux;

    private String nbAttaquant;

    public void placerJoueur(final Joueur joueur, final int indexPosition) {
    }

    public int indexDuJoueur(final Joueur joueur) {
        // TODO Auto-generated return
        return 0;
    }

    public void permuterJoueurs(final Joueur joueur1, final Joueur joueur2) {
    }

    public abstract void appliquer();

}
