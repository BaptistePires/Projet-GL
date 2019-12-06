package ihm.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import model.Entraineur;
import model.Equipe;
import model.Main;
import model.PartieSingleton;

import java.time.ZoneId;
import java.util.Date;

public class CreerNouvellePartieController {
    @FXML
    TextField nomInput;

    @FXML
    TextField prenomInput;

    @FXML
    DatePicker dateDeNaissanceInput;

    @FXML
    ChoiceBox<Equipe> equipeInput;

    @FXML
    TextArea historiqueInput;

    @FXML
    Button validerBouton;

    @FXML
    Button annulerBouton;

    @FXML
    public void initialize(){
        ObservableList<Equipe> equipes = FXCollections.observableArrayList(Equipe.equipesAll);
        equipeInput.setItems(equipes);
    }

    @FXML
    void validerAction(){
        final String nom = nomInput.getText();
        final String prenom = prenomInput.getText();
        final String historique = historiqueInput.getText();
        final Date dateDeNaissance = Date.from(dateDeNaissanceInput.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        final Equipe equipe = equipeInput.getValue();
        Entraineur notreEntraineur = new Entraineur(nom, prenom, dateDeNaissance, historique, equipe);
        PartieSingleton.INSTANCE.initEntraineur(notreEntraineur);
        //TODO lancer le dashboard
    }

    @FXML
    void annulerAction(){
        try{
            Main.mainStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../lanceurDePartie.fxml"))));
        }catch(Exception e){
            System.err.println("Echec lors du retour au menu principal : "+e.getClass() + " : "+e.getMessage());
        }
    }
}
