package model;


import java.io.Serializable;
import java.util.ArrayList;

public class Stade implements Serializable {
    public static ArrayList<Stade> stadesAll=new ArrayList<Stade>();

    private String nom;

    private int nombrePlaces;

    private String ville;

    private String histoire;

    public Stade(String nom, int nombrePlaces, String ville, String histoire){
        this.nom = nom;
        this.nombrePlaces = nombrePlaces;
        this.ville = ville;
        this.histoire = histoire;
        stadesAll.add(this);
    }

}
