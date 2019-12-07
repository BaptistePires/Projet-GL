package ihm.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import model.PartieSingleton;

public class EcranDuJeuController {
    @FXML
    GridPane gridMain;

    @FXML
    Label dateLabel;

    @FXML
    Pane pane1_1;

    @FXML
    public void avancerTempsAction(){

    }

    @FXML
    public void boiteReceptionAction(){

    }

    @FXML
    public void equipeAction(){

    }

    @FXML
    public void liguesAction(){

    }

    @FXML
    public void initialize(){
        System.out.println(dateLabel);
        dateLabel.setText(PartieSingleton.INSTANCE.getDateCourante().toString());
    }

    @FXML
    public void dashBoardAction(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../tableauDeBord.fxml"));
            GridPane dashboard = (GridPane) fxmlLoader.load();
            pane1_1.getChildren().clear();
            pane1_1.getChildren().add(dashboard);
        }catch(Exception e){
            e.printStackTrace();
            System.err.println("Erreur lors de l'affichage du tableau de bord : "+e.getClass()+" "+e.getMessage());
        }

    }
}
