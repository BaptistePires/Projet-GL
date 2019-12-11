package ihm.controllers;

import java.util.Date;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.*;
import model.Joueur;

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
    private Label alertMerca;

    private Joueur j;

    public void setJoueurIndex(int i) {
        setJoueur(PartieSingleton.INSTANCE.getEntraineur().getEquipe().getJoueurs().get(i));
    }
    public void setJoueur(Joueur j) {
        this.j = j;
        init();
    }

    public Joueur getJoueur() {
        return j;
    }

    private EcranDuJeuController parentController;

    public void setParentController(EcranDuJeuController c) {
        parentController = c;
    }

    @FXML
    void proposerContratCallBack(ActionEvent event) {
        parentController.proposerContrat(j);
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("../proposerContrat.fxml"));
//            Parent root = (Parent) loader.load();
//            ProposerContratController controller = loader.<ProposerContratController>getController();
//            controller.j = j;
//            Scene scene = new Scene(root);
//            Main.mainStage.setScene(scene);
//            Main.mainStage.show();
//        } catch (Exception e) {
//            System.err.println("Echec lors du retour au menu principal : " + e.getClass() + " : " + e.getMessage());
//        //            e.printStackTrace();
//        }
    }

    @FXML
    void retourCallBack(ActionEvent event) {
//        try {
//            Pane p = (Pane).getParent();
//            p.getChildren().clear();

//        } catch (Exception e) {
//            System.err.println("Echec lors du retour au menu principal : " + e.getClass() + " : " + e.getMessage());
//        }
        System.out.println("");
    }

    public void init() {
        nomJoueur.setText(j.getNom() + " " + j.getPrenom());
        etatPhysiqueJoueur.setText(Integer.toString(j.getEtatPhysique()));
        etatMoralJoueur.setText(Integer.toString(j.getMoral()));
        attaque.setText(Integer.toString(j.getAttaque()));
        millieu.setText(Integer.toString(j.getMillieu()));
        defense.setText(Integer.toString(j.getDefense()));
        poste.setText(j.getPoste().toString());
        
        equipe.setText(j.getEquipe().getNom());
        notePerfs.setText(Integer.toString(j.getNotePerformancesRecentes()));
        nbButsSaison.setText(Integer.toString(j.getNbButsSaison()));
        nbPassesDecSaison.setText(Integer.toString(j.getNbPasseDecisiveSaison()));
        nbCartonsJauneSaison.setText(Integer.toString(j.getNbCartonJauneSaison()));
        nbCartonsRougeSaison.setText(Integer.toString(j.getNbCartonRougeSaison()));
    }

    @FXML
    void initialize() {
        if(j!=null)init();
    }

}
