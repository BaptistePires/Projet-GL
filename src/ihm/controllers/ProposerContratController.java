package ihm.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Joueur;
import model.Main;

public class ProposerContratController {

    public ProposerContratController() {
        super();
    }

    @FXML
    private Label nomJoueur;

    @FXML
    private DatePicker dateDebut;

    @FXML
    private DatePicker dateFin;

    @FXML
    private Label labelDebut;

    @FXML
    private Label labelDebut1;

    @FXML
    private TextField inputMontantTransfert;

    @FXML
    private Label labelDebut11;

    @FXML
    private Label inputSalaireAnnuel;

    @FXML
    private Button soumettreContrat;

    public Joueur j;

    public String valLabel;
    public void setJoueur(Joueur joueur) {
        nomJoueur.setText("Proposer un contrat à : " + joueur.getNom() + " " + joueur.getPrenom());
    }
    @FXML
    void retour(ActionEvent event) {
        try {

            Main.mainStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../afficherInfoJoueur.fxml"))));
        } catch (Exception e) {
            System.err.println("Echec lors du retour au menu principal : " + e.getClass() + " : " + e.getMessage());
        }
    }

    @FXML
    void soumettreContrat(ActionEvent event) {
        System.out.println("Soumettre le contrat au joueur ");
    }

    @FXML
    private void initialize() {
        Platform.runLater(() -> {
            nomJoueur.setText(valLabel);
        });

    }
}
