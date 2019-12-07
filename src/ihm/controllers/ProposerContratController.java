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
import model.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class ProposerContratController {

    public ProposerContratController() {
        super();
    }

    public static String ALERT_TEXT = "Veuillez rentrer une valeur valide.";

    @FXML
    private Label alertDebut;

    @FXML
    private Label alertFin;

    @FXML
    private Label alertMontant;

    @FXML
    private Label alertSalaire;

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
    private TextField inputSalaire;


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
        boolean contratValide = true;

        if(inputSalaire.getText().length() <= 0) {
            alertSalaire.setText(ALERT_TEXT);
        }else{
            try{
                Integer.parseInt(inputSalaire.getText());
                alertSalaire.setText("");
            }catch (NumberFormatException e) {
                alertSalaire.setText("Veuillez entrer un entier");
                contratValide = false;
            }

        }

        if(inputMontantTransfert.getText().length() <= 0) {
            alertMontant.setText(ALERT_TEXT);
        }else{
            try {
                Integer.parseInt(inputMontantTransfert.getText());
                alertMontant.setText("");
            }catch (NumberFormatException e) {
                contratValide = false;
                alertMontant.setText("Veuillez entrer un entier.");
            }

        }

        if(!validateDate(dateDebut, alertDebut)){
            contratValide = false;
        }
        if(!validateDate(dateFin, alertFin)){
            contratValide = false;
        }
        if(contratValide) {
            Date dateDebutContrat = Date.from(dateDebut.getValue().atStartOfDay((ZoneId.systemDefault())).toInstant());
            Date dateFinContrat = Date.from(dateFin.getValue().atStartOfDay((ZoneId.systemDefault())).toInstant());
            int montantContrat = Integer.parseInt(inputMontantTransfert.getText());
            int salaireContrat = Integer.parseInt(inputSalaire.getText());
            Contrat contrat = new ContratFactory().generateContract(dateDebutContrat, dateFinContrat, montantContrat, salaireContrat);
            contrat.setEquipeDestination(PartieSingleton.INSTANCE.getEntraineur().getEquipe());
            contrat.setEquipeSource(j.getEquipe());
            j.getEquipe().formulerOffreTransfert(contrat, j);
        }

    }

    private boolean validateDate(DatePicker date, Label alertLabel) {

        LocalDate dateValue = date.getValue();
        if(dateValue != null) {
            alertLabel.setText("");
            return true;
        }else{
            alertLabel.setText(ALERT_TEXT);
            return false;
        }
    }

    @FXML
    private void initialize() {
        Platform.runLater(() -> {
            nomJoueur.setText("Proposer un contrat à " + j.getNom() + " " + j.getPrenom());
        });
    }
}
