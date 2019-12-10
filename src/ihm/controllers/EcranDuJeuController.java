package ihm.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Equipe;
import model.LanceurDePartie;
import model.Observateur;
import model.PartieSingleton;

public class EcranDuJeuController implements Observateur {
    @FXML
     GridPane gridMain;

    @FXML
     Label dateLabel;

    @FXML
     Pane pane1_1;

    @Override
    public void miseAJour(){
        dateLabel.setText(PartieSingleton.INSTANCE.getDateCourante().toString());
        if(PartieSingleton.INSTANCE.getBoiteMail().getNombreDeMessagesNonLus()!=0){
            msgNL.setVisible(true);
            msgNLV.setText(String.valueOf(PartieSingleton.INSTANCE.getBoiteMail().getNombreDeMessagesNonLus()));
        }else{
            msgNL.setVisible(false);
            msgNLV.setVisible(false);
        }
    }

    @FXML
    Label msgNL;
    @FXML
    Label msgNLV;


    @FXML
    public void avancerTempsAction(){
        PartieSingleton.INSTANCE.avancerLeTemps();
    }

    @FXML
    public void avancerJusquaAction() {
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
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../afficherMessages.fxml"));
            VBox dashboard = (VBox) fxmlLoader.load();
            pane1_1.getChildren().clear();
            pane1_1.getChildren().add(dashboard);
        }catch(Exception e){
            e.printStackTrace();
            System.err.println("Erreur lors de l'affichage du tableau de bord : "+e.getClass()+" "+e.getMessage());
        }
    }

    @FXML
    public void equipeAction(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../equipe.fxml"));
            AnchorPane equipe = (AnchorPane) fxmlLoader.load();
            EquipeController ec = fxmlLoader.<EquipeController>getController();
            ec.setEquipe(PartieSingleton.INSTANCE.getEntraineur().getEquipe());
            pane1_1.getChildren().clear();
            pane1_1.getChildren().add(equipe);
        }catch(Exception e){
            e.printStackTrace();
            System.err.println("Erreur lors de l'affichage du tableau de bord : "+e.getClass()+" "+e.getMessage());
        }
    }

    @FXML
    public void liguesAction(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../ligues.fxml"));
            AnchorPane ligues = (AnchorPane) fxmlLoader.load();
            pane1_1.getChildren().clear();
            pane1_1.getChildren().add(ligues);
        }catch(Exception e){
            e.printStackTrace();
            System.err.println("Erreur lors de l'affichage du tableau de bord : "+e.getClass()+" "+e.getMessage());
        }
    }

    @FXML
    public void administrationAction() {
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
    public void initialize() {
        dateLabel.setText(PartieSingleton.INSTANCE.getDateCourante().toString());
        PartieSingleton.INSTANCE.sabonner(this);
        miseAJour();
    }
    @FXML
    public void dashBoardAction() {
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
    public void strategieAction(){
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

    @FXML
    public void sauvegarderAction(){
        LanceurDePartie.INSTANCE.sauvegarderPartie();
        StrategieController.showAlert("Sauvegarde","Partie sauvegardée", "On a sauvegardée votre" +
                " partie sous le nom "+PartieSingleton.INSTANCE.getNomFichierSauvegarde());
    }
}
