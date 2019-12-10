package ihm.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import model.Entraineur;
import model.Equipe;
import model.PartieSingleton;
import model.President;

public class AdministrationController {

    @FXML
    private AnchorPane mainPane;

    @FXML
    private Label labelTrasnfert;

    @FXML
    private Label labelMasse;

    @FXML
    private Label labelTeamBuilding;

    @FXML
    private Button btnTrasnfert;

    @FXML
    private Button btnMasse;

    @FXML
    private Button btnTeamBuilding;

    @FXML
    private Button btnRetour;

    @FXML
    private Label etatTransfert;

    @FXML
    private Label etatTeamBuilding;

    @FXML
    private Label etatMasse;

    @FXML
    private Label labelHistoClub;

    @FXML
    private Label labelDateNaissance;

    @FXML
    private Label labelHistoPres;

    @FXML
    private Label labelNomPres;


    public Equipe equipe;

    @FXML
    void augmentationMasse(ActionEvent event) {
        if(equipe.getEntraineur().demanderBudgetMasseSalariale()){
            labelMasse.setText(Integer.toString(equipe.getMasseSalariale()));
            etatMasse.setText("Accepté");
        }else{
            etatMasse.setText("Refusé");
        }
    }

    @FXML
    void augmentationTeamBuilding(ActionEvent event) {
        if(equipe.getEntraineur().demanderBudgetTeamBuilding()) {
            labelTeamBuilding.setText(Integer.toString(equipe.getBudgetTeamBuilding()));
            etatTeamBuilding.setText("Accepté");
        }else{
            etatTeamBuilding.setText("Refusé");
        }
    }

    @FXML
    void augmentationTrasnfert(ActionEvent event) {
        if(equipe.getEntraineur().demanderBudgetTransfert()) {
            labelTrasnfert.setText(Integer.toString(equipe.getBudgetTransferts()));
            etatTransfert.setText("Accepté");
        }else{
            etatTransfert.setText("Refusé");
        }
    }

    @FXML
    void retour(ActionEvent event) {

    }

    @FXML
    public void initialize() {
        Platform.runLater(() -> {

            equipe = PartieSingleton.INSTANCE.getEntraineur().getEquipe();
            labelTrasnfert.setText(Integer.toString(equipe.getBudgetTransferts()));
            labelMasse.setText(Integer.toString(equipe.getMasseSalariale()));
            labelTeamBuilding.setText(Integer.toString(equipe.getBudgetTransferts()));
            labelNomPres.setText(equipe.getPresident().getNom());
            labelDateNaissance.setText(equipe.getPresident().getDateDeNaissance().toString());
            labelHistoPres.setText(equipe.getPresident().getHistoriqueCarriere());
            labelHistoClub.setText(equipe.getHistoireDuClub());
        });
    }
}
