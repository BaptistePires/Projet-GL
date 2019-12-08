package ihm.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import model.Entraineur;
import model.Equipe;
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

    public Equipe equipe;

    @FXML
    void augmentationMasse(ActionEvent event) {
        if(equipe.getEntraineur().demanderBudgetMasseSalariale()){
            labelMasse.setText(Integer.toString(equipe.getMasseSalariale()));
        }
    }

    @FXML
    void augmentationTeamBuilding(ActionEvent event) {
        if(equipe.getEntraineur().demanderBudgetTeamBuilding()) {
            labelTeamBuilding.setText(Integer.toString(equipe.getBudgetTeamBuilding()));
        }
    }

    @FXML
    void augmentationTrasnfert(ActionEvent event) {
        if(equipe.getEntraineur().demanderBudgetTransfert()) {
            labelTrasnfert.setText(Integer.toString(equipe.getBudgetTransferts()));
        }
    }

    @FXML
    void retour(ActionEvent event) {

    }

    @FXML
    public void initialize() {
        Platform.runLater(() -> {
//            Entraineur e = new Entraineur("Nom", "Prenom", null, "");
//            President p = new President("Nom", "Prenom", null, "", equipe);
//            p.setEquipe(equipe);
//            e.setEquipe(equipe);
//            equipe = new Equipe("Test", "ter", 82122,
//                    884555,null, e, p , null, null);

            labelTrasnfert.setText(Integer.toString(equipe.getBudgetTransferts()));
            labelMasse.setText(Integer.toString(equipe.getMasseSalariale()));
//            labelTeamBuilding.setText(Integer.toString(equipe.get));
        });
    }
}
