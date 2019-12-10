package ihm.controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Joueur;
import model.Match;
import model.Poste;

public class MatchController {
    @FXML
     Label dateLabel;

    @FXML
     Label stadeLabel;

    @FXML
     Label arbitreLabel;

    @FXML
     Label equipe1Label;

    @FXML
     Label equipe2Label;

    @FXML
     TableView<Joueur> equipe1VT;

    @FXML
     TableColumn<Joueur,Poste> posCol1;

    @FXML
     TableColumn<Joueur,String> nomCol1;

    @FXML
     TableColumn<Joueur,String> prenomCol1;

    @FXML
     TableColumn<Joueur,Integer> phyCol1;

    @FXML
     TableColumn<Joueur,Integer> moralCol1;

    @FXML
     TableView<Joueur> equipe2VT;

    @FXML
     TableColumn<Joueur,Poste> posCol2;

    @FXML
     TableColumn<Joueur,String> nomCol2;

    @FXML
     TableColumn<Joueur,String> prenomCol2;

    @FXML
     TableColumn<Joueur,Integer> phyCol2;

    @FXML
     TableColumn<Joueur,Integer> moralCol2;

    private Match match;

    public void setMatch(Match match) {
        this.match = match;
    }

    public Match getMatch() {
        return match;
    }

    @FXML
    public void initialize() {
        if(match==null || match.getEquipe1()==null || match.getEquipe2()==null || match.getEquipe1().getStrategie()==null
                || match.getEquipe2().getStrategie()==null){
            System.err.println("Impossible d'initialiser ce match car il est invalide (null ou une des équipes ou une " +
                    "des strategies  à null)");
            StrategieController.showAlert("Attention","Erreur","Impossible d'initialiser ce match " +
                    "car il est invalide (null ou une des équipes ou une des strategies à null)");
            return;
        }
        dateLabel.setText(match.getDateDeLEvenement().toString());
        arbitreLabel.setText(match.getArbitre().toString());
        stadeLabel.setText(match.getStade().toString());
        equipe1Label.setText(match.getEquipe1().getNom());
        equipe2Label.setText(match.getEquipe2().getNom());
        equipe1VT.setItems(FXCollections.observableArrayList(match.getEquipe1().getStrategie().getFormation().keySet()));
        equipe2VT.setItems(FXCollections.observableArrayList(match.getEquipe2().getStrategie().getFormation().keySet()));
        
        posCol1.setCellValueFactory(new PropertyValueFactory<Joueur, Poste>("poste"));
        posCol2.setCellValueFactory(new PropertyValueFactory<Joueur, Poste>("poste"));
        
        nomCol1.setCellValueFactory(new PropertyValueFactory<Joueur, String>("nom"));
        nomCol2.setCellValueFactory(new PropertyValueFactory<Joueur, String>("nom"));
        
        prenomCol1.setCellValueFactory(new PropertyValueFactory<Joueur, String>("prenom"));
        prenomCol2.setCellValueFactory(new PropertyValueFactory<Joueur, String>("prenom"));
        
        phyCol1.setCellValueFactory(new PropertyValueFactory<Joueur, Integer>("etatPhysique"));
        phyCol2.setCellValueFactory(new PropertyValueFactory<Joueur, Integer>("etatPhysique"));
        
        moralCol1.setCellValueFactory(new PropertyValueFactory<Joueur, Integer>("moral"));
        moralCol2.setCellValueFactory(new PropertyValueFactory<Joueur, Integer>("moral"));
    }

    @FXML
    public void lancerMatchAction() {
    }

}
