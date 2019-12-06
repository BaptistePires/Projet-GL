package ihm.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import model.Equipe;
import model.Joueur;
import model.Main;
import model.Poste;

import java.util.Date;

public class AfficherInfoJoueurController {

    @FXML
    private Label nomJoueur;

    @FXML
    private Label etatPhysiqueJoueur;

    @FXML
    private Label notePerfs;

    @FXML
    private Label nbButsSaison;

    @FXML
    private Label nbPassesDecSaison;

    @FXML
    private Label nbCartonsJauneSaison;

    @FXML
    private Label nbCartonsRougeSaison;

    @FXML
    private Label etatMoralJoueur;

    @FXML
    private Label attaque;

    @FXML
    private Label millieu;

    @FXML
    private Label defense;

    @FXML
    private Label poste;

    @FXML
    private Label equipe;

    @FXML
    private Button btnRetour;

    @FXML
    private Button btnProposerContrat;

    @FXML
    void proposerContratCallBack(ActionEvent event) {

    }

    @FXML
    void retourCallBack(ActionEvent event) {
        try {
            Main.mainStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../lanceurDePartie.fxml"))));
        } catch (Exception e) {
            System.err.println("Echec lors du retour au menu principal : " + e.getClass() + " : " + e.getMessage());
        }
    }


    @FXML
    void loadJoueur(ActionEvent event) {
        Joueur j = new Joueur("Didier", "Drogba", new Date(), "cc");
        j.configure(2,5,8,46,95, 65, 26, 62, 26, 26, Poste.ATT, null, null);
        nomJoueur.setText(j.getNom() + " " + j.getPrenom());
        etatPhysiqueJoueur.setText(Integer.toString(j.getEtatPhysique()));
        etatMoralJoueur.setText(Integer.toString(j.getMoral()));
        attaque.setText(Integer.toString(j.getAttaque()));
        millieu.setText(Integer.toString(j.getMillieu()));
        defense.setText(Integer.toString(j.getDefense()));
//        poste.setText(Integer.toString(j.getPoste()));

//        equipe.setText(j.getEquipe().getNom());
        notePerfs.setText(Integer.toString(j.getNotePerformancesRecentes()));
        nbButsSaison.setText(Integer.toString(j.getNbButsSaison()));
        nbPassesDecSaison.setText(Integer.toString(j.getNbPasseDecisiveSaison()));
        nbCartonsJauneSaison.setText(Integer.toString(j.getNbCartonJauneSaison()));
        nbCartonsRougeSaison.setText(Integer.toString(j.getNbCartonRougeSaison()));
    }
}
