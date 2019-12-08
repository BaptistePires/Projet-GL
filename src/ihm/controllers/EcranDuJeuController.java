package ihm.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Observateur;
import model.PartieSingleton;

public class EcranDuJeuController implements Observateur {

    @Override
    public void miseAJour(){
        System.out.println("hi");
        dateLabel.setText(PartieSingleton.INSTANCE.getDateCourante().toString());
    }

    @FXML
    GridPane gridMain;

    @FXML
    Label dateLabel;

    @FXML
    Pane pane1_1;

    @FXML
    public void avancerTempsAction(){
        PartieSingleton.INSTANCE.avancerLeTemps();
    }
    @FXML
    public void avancerJusquaAction(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../customDialogDate.fxml"));
        try{
            AnchorPane parent = (AnchorPane) fxmlLoader.load();
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
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
    public void administrationAction(){

        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../administration.fxml"));
            VBox dashboard = (VBox) fxmlLoader.load();
            pane1_1.getChildren().clear();
            pane1_1.getChildren().add(dashboard);
        }catch(Exception e){
            e.printStackTrace();
            System.err.println("Erreur lors de l'affichage du tableau de bord : "+e.getClass()+" "+e.getMessage());
        }
    }

    @FXML
    public void initialize(){
        dateLabel.setText(PartieSingleton.INSTANCE.getDateCourante().toString());
        PartieSingleton.INSTANCE.sabonner(this);
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

    @FXML
    public void testAction(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../strategie.fxml"));
            GridPane dashboard = (GridPane) fxmlLoader.load();
            pane1_1.getChildren().clear();
            pane1_1.getChildren().add(dashboard);
        }catch(Exception e){
            e.printStackTrace();
            System.err.println("Erreur lors de l'affichage du tableau de bord : "+e.getClass()+" "+e.getMessage());
        }
    }
}
