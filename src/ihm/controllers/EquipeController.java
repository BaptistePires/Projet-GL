package ihm.controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.*;

import java.util.Date;

public class EquipeController {
    @FXML Label nomEquipeLabel;
    @FXML Label nomLigueLabel;
    @FXML Label stadeDescLabel;
    @FXML Label nomPresidentLabel;
    @FXML Label nomEntraineurLabel;
    @FXML TextArea histoireTextArea;

    @FXML TableView<Joueur> joueursTV;

    @FXML TableColumn<Joueur, Poste>  posteCol;
    @FXML TableColumn<Joueur, String> nomCol;
    @FXML TableColumn<Joueur, String> prenomCol;
    @FXML TableColumn<Joueur, Date> naissCol;
    @FXML TableColumn<Joueur, Integer> phyCol;
    @FXML TableColumn<Joueur, Integer> moralCol;
    @FXML TableColumn<Joueur, Integer> defCol;
    @FXML TableColumn<Joueur, Integer> milCol;
    @FXML TableColumn<Joueur, Integer> attCol;
    @FXML TableColumn<Joueur, Integer> noteCol;
    @FXML TableColumn<Joueur, Integer> butCol;
    @FXML TableColumn<Joueur, Integer> pdCol;
    @FXML TableColumn<Joueur, Integer> jCol;
    @FXML TableColumn<Joueur, Integer> rCol;

    private Equipe equipe;

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
        init();
    }

    @FXML public void voirJoueurSelectionne(){
        Joueur joueurSelectionne = joueursTV.getSelectionModel().getSelectedItem();
        if(joueurSelectionne!=null){
            try{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../afficherInfoJoueur.fxml"));
                VBox root = loader.load();
                AfficherInfoJoueurController controller = loader.<AfficherInfoJoueurController>getController();
                controller.setJoueur(joueurSelectionne);
                Pane parent = (Pane)nomEquipeLabel.getParent().getParent();
                parent.getChildren().clear();
                parent.getChildren().add(root);
            }catch(Exception e){
                e.printStackTrace();
                System.err.println("Erreur lors du chargement du joueur selectionné");
            }
        }
    }

    @FXML public void toMenuPrincipal(){
        try{
            Main.mainStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../ecranDuJeu.fxml"))));
        }catch(Exception e){
            e.printStackTrace();
            System.err.println("Erreur lors de l'affichage de l'ecran principal du jeu : "+e.getClass()+" "+e.getMessage());
        }
    }

    public void init(){
        if(equipe==null) return;
        nomEquipeLabel.setText(equipe.getNom());
        nomPresidentLabel.setText(equipe.getPresident().getNom() + " " + equipe.getPresident().getPrenom());
        nomLigueLabel.setText(equipe.getLigue().getNom());
        stadeDescLabel.setText(equipe.getStade().getNom()+", "+equipe.getStade().getNombrePlaces()+" places");
        nomEntraineurLabel.setText(equipe.getEntraineur().getNom()+" "+equipe.getEntraineur().getPrenom());
        histoireTextArea.setEditable(false);
        histoireTextArea.setText(equipe.getHistoireDuClub());

        posteCol.setCellValueFactory(new PropertyValueFactory<Joueur, Poste>("poste"));
        nomCol.setCellValueFactory(new PropertyValueFactory<Joueur, String>("nom"));
        prenomCol.setCellValueFactory(new PropertyValueFactory<Joueur, String>("prenom"));
        naissCol.setCellValueFactory(new PropertyValueFactory<Joueur, Date>("dateDeNaissance"));
        phyCol.setCellValueFactory(new PropertyValueFactory<Joueur, Integer>("etatPhysique"));
        moralCol.setCellValueFactory(new PropertyValueFactory<Joueur, Integer>("moral"));
        defCol.setCellValueFactory(new PropertyValueFactory<Joueur, Integer>("defense"));
        milCol.setCellValueFactory(new PropertyValueFactory<Joueur, Integer>("millieu"));
        attCol.setCellValueFactory(new PropertyValueFactory<Joueur, Integer>("attaque"));
        noteCol.setCellValueFactory(new PropertyValueFactory<Joueur, Integer>("notePerformancesRecentes"));
        butCol.setCellValueFactory(new PropertyValueFactory<Joueur, Integer>("nbButsSaison"));
        pdCol.setCellValueFactory(new PropertyValueFactory<Joueur, Integer>("nbPasseDecisiveSaison"));
        jCol.setCellValueFactory(new PropertyValueFactory<Joueur, Integer>("nbCartonJauneSaison"));
        rCol.setCellValueFactory(new PropertyValueFactory<Joueur, Integer>("nbCartonRougeSaison"));

        joueursTV.setItems(FXCollections.observableArrayList(equipe.getJoueurs()));

    }

    @FXML public void initialize(){
        if(equipe!=null)init();

    }
}
