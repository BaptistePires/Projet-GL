package ihm.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import model.*;

import javax.xml.soap.Text;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class StrategieController {
    @FXML
    ChoiceBox<Strategie> strategieDefautChoice;
    @FXML
    CheckBox strategieDefautCheck;
    @FXML
    Spinner<Integer> aggressiviteSpinner;
    @FXML
    Spinner<Integer> passesSpinner;
    @FXML
    Spinner<Integer> defenseSpinner;
    @FXML
    Spinner<Integer> milieuSpinner;
    @FXML
    Spinner<Integer> attaqueSpinner;
    @FXML
    ChoiceBox<Joueur> ajouterJoueurChoice;
    @FXML
    ChoiceBox<Joueur> retirerJoueurChoice;
    @FXML
    TableView<Joueur> joueurSelectViewTab;
    @FXML
    TableColumn<Joueur, Poste> posteCol;
    @FXML
    TableColumn<Joueur,String> nomCol;
    @FXML
    TableColumn<Joueur,String> prenomCol;
    @FXML
    TableColumn<Joueur,Integer> physiqueCol;
    @FXML
    TableColumn<Joueur,Integer> moralCol;
    @FXML
    TableColumn<Joueur,Integer> noteCol;
    @FXML
    TableColumn<Joueur,Integer> cartonJCol;
    @FXML
    TableColumn<Joueur,Integer> butsCol;
    List<Joueur> joueursChoisissables;
    @FXML
    public void initialize(){
        List<Joueur> joueursAChoisir = new ArrayList<Joueur>(PartieSingleton.INSTANCE.getEntraineur().getEquipe().getJoueurs());
        ObservableList<Joueur> observableAjouterJoueur = FXCollections.observableArrayList(joueursAChoisir);
        ajouterJoueurChoice.setItems(observableAjouterJoueur);
        List<Joueur> joueursARetirer = new ArrayList<Joueur>();
        ObservableList<Joueur> observableRetirerJoueur = FXCollections.observableArrayList(joueursARetirer);
        retirerJoueurChoice.setItems(observableRetirerJoueur);

        retirerJoueurChoice.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Joueur>(){
            @Override
            public void changed(ObservableValue<? extends Joueur> selected, Joueur oldJoueur, Joueur newJoueur){
                observableRetirerJoueur.remove(newJoueur);
                observableAjouterJoueur.add(newJoueur);
                for(int i=0;i<observableAjouterJoueur.size();i++){
                    if(observableAjouterJoueur.get(i)==null)observableAjouterJoueur.remove(i);
                }
                for(int i=0;i<observableRetirerJoueur.size();i++){
                    if(observableRetirerJoueur.get(i)==null)observableRetirerJoueur.remove(i);
                }
                System.out.println("A"+joueurSelectViewTab.getItems());
            }
        } );

        ajouterJoueurChoice.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Joueur>(){
            @Override
            public void changed(ObservableValue<? extends Joueur> selected, Joueur oldJoueur, Joueur newJoueur){
                observableRetirerJoueur.add(newJoueur);
                observableAjouterJoueur.remove(newJoueur);

                for(int i=0;i<observableAjouterJoueur.size();i++){
                    if(observableAjouterJoueur.get(i)==null)observableAjouterJoueur.remove(i);
                }
                for(int i=0;i<observableRetirerJoueur.size();i++){
                    if(observableRetirerJoueur.get(i)==null)observableRetirerJoueur.remove(i);
                }
                System.out.println("B"+joueurSelectViewTab.getItems());
            }
        } );

        joueurSelectViewTab.setItems(observableRetirerJoueur);

        ArrayList<Strategie> strategies = new ArrayList<Strategie>();
        strategies.add(new StrategieDefensive());
        strategies.add(new StrategieOffensive());
        strategieDefautChoice.setItems(FXCollections.observableArrayList(strategies));

        posteCol.setCellValueFactory(new PropertyValueFactory<Joueur, Poste>("poste"));
        nomCol.setCellValueFactory(new PropertyValueFactory<Joueur, String>("nom"));
        prenomCol.setCellValueFactory(new PropertyValueFactory<Joueur, String>("prenom"));
        physiqueCol.setCellValueFactory(new PropertyValueFactory<Joueur, Integer>("etatPhysique"));
        moralCol.setCellValueFactory(new PropertyValueFactory<Joueur, Integer>("moral"));
        noteCol.setCellValueFactory(new PropertyValueFactory<Joueur, Integer>("notePerformancesRecentes"));
        cartonJCol.setCellValueFactory(new PropertyValueFactory<Joueur, Integer>("nbCartonJauneSaison"));
        butsCol.setCellValueFactory(new PropertyValueFactory<Joueur, Integer>("nbButsSaison"));

        aggressiviteSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100,100));
        passesSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100,100));
        defenseSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100,100));
        milieuSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100,100));
        attaqueSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100,100));
    }
    @FXML
    public void validerAction(){
        if(strategieDefautCheck.isSelected()){
            PartieSingleton.INSTANCE.getEntraineur().getEquipe().setStrategie(strategieDefautChoice.getValue());
            this.showAlert("Information","Stratégie bien mise en place","Votre stratégie a été associée à votre équipe");

        }else{
            final int aggressivite = aggressiviteSpinner.getValue();
            final int passes = passesSpinner.getValue();
            final int defense = defenseSpinner.getValue();
            final int milieu = milieuSpinner.getValue();
            final int attaque = attaqueSpinner.getValue();
            if(milieu+defense+attaque>100){
                showAlert("Attention","Incohérence","Il ne faut pas que la somme de défense, milieu et attaque soit supérieure à 100");
            }else{
                Strategie s = new Strategie() {
                    @Override
                    public void appliquer() {
                        setAgressivite(aggressivite);
                        setPasses(passes);
                        setDefense(defense);
                        setMilieu(milieu);
                        setAttaque(attaque);
                    }
                };
                PartieSingleton.INSTANCE.getEntraineur().getEquipe().setStrategie(s);
                this.showAlert("Information","Stratégie bien mise en place","Votre stratégie a été associée à votre équipe");
            }
        }
    }
    @FXML
    public void annulerAction(){

    }

    public static void showAlert(String titre, String header,String content){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titre);
        alert.setHeaderText(header);
        alert.setContentText(content);

        alert.showAndWait();
    }

}
