package model;

import data.DataGenerator;

import java.io.*;
import java.util.TreeMap;

public class LanceurDePartie {
    public static String dossierDeStockageDesParties="";

    public static String dossierDeStockageDesDonnees="";

    public static LanceurDePartie INSTANCE = new LanceurDePartie();

    private LanceurDePartie(){
        configure();
    }

    public void configure(){
        try{
            BufferedReader br = new BufferedReader(new FileReader("src/data/conf"));
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
            DataGenerator.nbEquiesAGenererAleaParLigue = Integer.parseInt(dictionnaire.get("nbEquiesAGenererAleaParLigue"));
            DataGenerator.nbLiguesAGenererAlea = Integer.parseInt(dictionnaire.get("nbLiguesAGenererAlea"));
            PartieSingleton.avancerAuMaximum = Integer.parseInt(dictionnaire.get("avancerAuMaximum"));
        }catch(Exception e){
            System.err.println("Erreur lors de la lecture du fichier de configurations :"+e.getClass());
        }
    }

    public void lancerNouvellePartie(final String nomFichierSauvegarde) {
        PartieSingleton.INSTANCE.init(nomFichierSauvegarde);
        sauvegarderPartie();
    }

    public void chargerPartieExistante(final String nomFichierDeSauvegarde) {
        PartieSingleton.INSTANCE.chargerPartieDepuis(nomFichierDeSauvegarde);
    }

    public void sauvegarderPartie() {
        try{
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream("src/data/"+LanceurDePartie.dossierDeStockageDesParties+"/"
                            +PartieSingleton.INSTANCE.getNomFichierSauvegarde()));
            out.writeObject(PartieSingleton.INSTANCE);
            out.close();
        }catch (Exception e){
            System.err.println("Erreur lors de l'enregistrement de la partie :"+e.getClass()+" : "+e.getMessage());
        }
    }

    public void quitter() {
        System.exit(0);
    }


}
