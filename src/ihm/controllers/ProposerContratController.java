package ihm.controllers;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.*;
import model.Joueur;

public class ProposerContratController {
    public static String ALERT_TEXT = "Veuillez rentrer une valeur valide.";

    public String valLabel;

    @FXML
    VBox vb;

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

    private Joueur j;

    private EcranDuJeuController parentController;

    public void setParentController(EcranDuJeuController c) {
        parentController = c;
    }

    public void setJoueur(Joueur joueur) {
        j = joueur;
        nomJoueur.setText("Proposer un contrat à : " + joueur.getNom() + " " + joueur.getPrenom());
    }

    @FXML
    void retour(ActionEvent event) {
        try {
            Pane p = (Pane)(vb.getParent());
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../afficherInfoJoueur"));
            VBox parent = (VBox) loader.load();
            AfficherInfoJoueurController c = loader.<AfficherInfoJoueurController>getController();
            c.setJoueur(j);
            p.getChildren().clear();
            p.getChildren().add(parent);

        } catch (Exception e) {
            System.err.println("Echec lors du retour au menu principal : " + e.getClass() + " : " + e.getMessage());
        }
    }

    @FXML
    void soumettreContrat(ActionEvent event) {
        boolean contratValide = true;

        //System.out.println(j);
        if(inputSalaire.getText().length() <= 0) {
            alertSalaire.setText(ALERT_TEXT);
        }else{
            try{
                int salaire = Integer.parseInt(inputSalaire.getText());
        
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
                int monteantT = Integer.parseInt(inputMontantTransfert.getText());
                if(PartieSingleton.INSTANCE.getEntraineur().getEquipe().getBudgetTransferts() - monteantT < 0){
                    alertMontant.setText("Votre budget transfert n'est pas assez grand.");
                    contratValide = false;
                }
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
            Contrat contrat = new ContratFactory()
                    .generateContract(dateDebutContrat, dateFinContrat, montantContrat, salaireContrat, j, j.getEquipe(),
                            PartieSingleton.INSTANCE.getEntraineur().getEquipe());
            //j.getEquipe().formulerOffreTransfert(contrat, j);
            contrat.getEquipeSource().formulerOffreTransfert(contrat, j);
            //parentController.equipeAction();

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
