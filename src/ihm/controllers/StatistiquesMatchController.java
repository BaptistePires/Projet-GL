package ihm.controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.*;

public class StatistiquesMatchController {
    @FXML
    Label dateLabel;
    @FXML
    Label stadeLabel;
    @FXML
    Label arbitreLabel;
    @FXML
    Label equipe1Label;
    @FXML
    Label buts1Label;
    @FXML
    Label possession1Label;
    @FXML
    Label passes1Label;
    @FXML
    Label equipe2Label;
    @FXML
    Label buts2Label;
    @FXML
    Label possession2Label;
    @FXML
    Label passes2Label;

    @FXML
    TableView<StatistiquesJoueur> equipeVT1;
    @FXML
    TableView<StatistiquesJoueur> equipeVT2;

    @FXML TableColumn<StatistiquesJoueur, String> nomCol1;
    @FXML TableColumn<StatistiquesJoueur, String> prenomCol1;
    @FXML TableColumn<StatistiquesJoueur, Integer> phyCol1;
    @FXML TableColumn<StatistiquesJoueur, Integer> moralCol1;
    @FXML TableColumn<StatistiquesJoueur, Integer> butsCol1;
    @FXML TableColumn<StatistiquesJoueur, Integer> jauneCol1;
    @FXML TableColumn<StatistiquesJoueur, Integer> rougeCol1;
    @FXML TableColumn<StatistiquesJoueur, Integer> noteCol1;

    @FXML TableColumn<StatistiquesJoueur, String> nomCol2;
    @FXML TableColumn<StatistiquesJoueur, String> prenomCol2;
    @FXML TableColumn<StatistiquesJoueur, Integer> phyCol2;
    @FXML TableColumn<StatistiquesJoueur, Integer> moralCol2;
    @FXML TableColumn<StatistiquesJoueur, Integer> butsCol2;
    @FXML TableColumn<StatistiquesJoueur, Integer> jauneCol2;
    @FXML TableColumn<StatistiquesJoueur, Integer> rougeCol2;
    @FXML TableColumn<StatistiquesJoueur, Integer> noteCol2;

    private Statistiques statistiques;
    private Match match;

    public Statistiques getStatistiques() {
        return statistiques;
    }

    public void setStatistiques(Statistiques statistiques) {
        this.statistiques = statistiques;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    @FXML public void initialize(){
        //TODO Vérifier la validité des objets match et statistiques

        dateLabel.setText(match.getDateDeLEvenement().toString());
        stadeLabel.setText(match.getStade().toString());
        arbitreLabel.setText(match.getArbitre().toString());
        equipe1Label.setText(match.getEquipe1().getNom());
        equipe2Label.setText(match.getEquipe2().getNom());
        buts1Label.setText(String.valueOf(statistiques.getStatistiquesEquipeA().getNombreDeButsMarques()));
        buts2Label.setText(String.valueOf(statistiques.getStatistiquesEquipeB().getNombreDeButsMarques()));
        passes1Label.setText(String.valueOf(statistiques.getStatistiquesEquipeA().getNombreDePasses()));
        passes2Label.setText(String.valueOf(statistiques.getStatistiquesEquipeB().getNombreDePasses()));
        possession1Label.setText(String.valueOf(statistiques.getStatistiquesEquipeA().getPossessionDeBalle()));
        possession2Label.setText(String.valueOf(statistiques.getStatistiquesEquipeB().getPossessionDeBalle()));

        nomCol1.setCellValueFactory(new PropertyValueFactory<StatistiquesJoueur, String>("nom"));
        prenomCol1.setCellValueFactory(new PropertyValueFactory<StatistiquesJoueur, String>("prenom"));
        phyCol1.setCellValueFactory(new PropertyValueFactory<StatistiquesJoueur, Integer>("physique"));
        moralCol1.setCellValueFactory(new PropertyValueFactory<StatistiquesJoueur, Integer>("moral"));
        butsCol1.setCellValueFactory(new PropertyValueFactory<StatistiquesJoueur, Integer>("nombreDeButsMarques"));
        jauneCol1.setCellValueFactory(new PropertyValueFactory<StatistiquesJoueur, Integer>("nombreDeCartonsJaunes"));
        rougeCol1.setCellValueFactory(new PropertyValueFactory<StatistiquesJoueur, Integer>("nombreDeCartonsRouges"));
        noteCol1.setCellValueFactory(new PropertyValueFactory<StatistiquesJoueur, Integer>("noteDuJoueur"));

        nomCol2.setCellValueFactory(new PropertyValueFactory<StatistiquesJoueur, String>("nom"));
        prenomCol2.setCellValueFactory(new PropertyValueFactory<StatistiquesJoueur, String>("prenom"));
        phyCol2.setCellValueFactory(new PropertyValueFactory<StatistiquesJoueur, Integer>("physique"));
        moralCol2.setCellValueFactory(new PropertyValueFactory<StatistiquesJoueur, Integer>("moral"));
        butsCol2.setCellValueFactory(new PropertyValueFactory<StatistiquesJoueur, Integer>("nombreDeButsMarques"));
        jauneCol2.setCellValueFactory(new PropertyValueFactory<StatistiquesJoueur, Integer>("nombreDeCartonsJaunes"));
        rougeCol2.setCellValueFactory(new PropertyValueFactory<StatistiquesJoueur, Integer>("nombreDeCartonsRouges"));
        noteCol2.setCellValueFactory(new PropertyValueFactory<StatistiquesJoueur, Integer>("noteDuJoueur"));

        equipeVT1.setItems(FXCollections.observableArrayList(statistiques.getStatistiquesJoueursA()));
        equipeVT2.setItems(FXCollections.observableArrayList(statistiques.getStatistiquesJoueursB()));

    }

    @FXML public void retourAuTableauDeBordAction(){
        try{
            Main.mainStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../ecranDuJeu.fxml"))));
        }catch(Exception e){
            System.err.println("Echec lors du retour au menu principal : "+e.getClass() + " : "+e.getMessage());
        }
    }
}
