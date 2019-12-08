package ihm.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import model.Equipe;

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
        equipe.getPresident().
    }

    @FXML
    void augmentationTeamBuilding(ActionEvent event) {

    }

    @FXML
    void augmentationTrasnfert(ActionEvent event) {

    }

    @FXML
    void retour(ActionEvent event) {

    }

    @FXML
    public void initialize() {
        Platform.runLater(() -> {
            equipe = new Equipe("Test", "ter", 82122,
                    884555,null, null, null, null, null);
            labelTrasnfert.setText(Integer.toString(equipe.getBudgetTransferts()));
            labelMasse.setText(Integer.toString(equipe.getMasseSalariale()));
//            labelTeamBuilding.setText(Integer.toString(equipe.get));
        });
    }
}
