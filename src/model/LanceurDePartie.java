package model;

import java.io.*;
import java.util.TreeMap;
import javax.swing.*;
import javax.swing.JFrame;

public class LanceurDePartie {
    private static String dossierDeStockageDesParties = "";

    private static String dossierDeStockageDesDonnees = "";

    public static LanceurDePartie INSTANCE = new LanceurDePartie();

    public static JFrame fenetrePrincipale;

    public void lancerNouvellePartie(final String nomFichierSauvegarde) {
        PartieSingleton.INSTANCE.init(nomFichierSauvegarde);
        sauvegarderPartie();
    }

    public void chargerPartieExistante(final String nomFichierDeSauvegarde) {
        PartieSingleton.INSTANCE.chargerPartieDepuis(nomFichierDeSauvegarde);
    }

    public void sauvegarderPartie() {
        try{
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(PartieSingleton.INSTANCE.getNomFichierSauvegarde()));
            out.writeObject(PartieSingleton.INSTANCE);
            out.close();
        }catch (Exception e){
            System.err.println("Erreur lors de l'enregistrement de la partie :"+e.getClass());
        }
    }

    public void quitter() {
    }

    public void menuPrincipal() {
    }

    private LanceurDePartie() {
        configure();
    }

    public void configure() {
        try{
            BufferedReader br = new BufferedReader(new FileReader("data/conf"));
            String line;
            TreeMap<String, String> dictionnaire = new TreeMap<String, String>();
            String[] keyValue;
            while((line=br.readLine())!=null){
                keyValue = line.split("=");
                dictionnaire.put(keyValue[0],keyValue[1]);
            }
            br.close();
            dossierDeStockageDesDonnees = dictionnaire.get("dossierDeStockageDesDonnees");
            dossierDeStockageDesParties = dictionnaire.get("dossierDeStockageDesParties");
            System.out.println(dossierDeStockageDesDonnees + " "+dictionnaire);
        }catch(Exception e){
            System.err.println("Erreur lors de la lecture du fichier de configurations :"+e.getClass());
        }
    }

}
