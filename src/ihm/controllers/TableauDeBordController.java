package ihm.controllers;

import java.util.Date;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.*;

public class TableauDeBordController {
    @FXML
     TableView<Equipe> classementTeamsViewTab;

    @FXML
     TableColumn<Equipe,String> equipeCol;

    @FXML
     TableColumn<Equipe,Integer> ptsCol;

    @FXML
     TableColumn<Equipe,Integer> victCol;

    @FXML
     TableColumn<Equipe,Integer> defCol;

    @FXML
     TableColumn<Equipe,Integer> nulCol;

    @FXML
     TableColumn<Equipe,Integer> bPourCol;

    @FXML
     TableColumn<Equipe,Integer> bContreCol;

    @FXML
     TableView<Match> calendrierViewTab;

    @FXML
     TableColumn<Match,Date> dateCol;

    @FXML
     TableColumn<Match,Equipe> eq1Col;

    @FXML
     TableColumn<Match,Equipe> eq2Col;

    @FXML
     TableColumn<Match,Stade> stadeCol;

    @FXML
     Label nomDuClubLabel;

    @FXML
     Label budgetDesTransfertsLabel;

    @FXML
     Label masseSalarialeLabel;

    @FXML
     Label histoireDuClubLabel;

    @FXML
     Label monNomLabel;

    @FXML
     Label monPrenomLabel;

    @FXML
     Label maDateDeNaissanceLabel;

    @FXML
     Label monHistoireLabel;

    @FXML
     TableView<Joueur> effectifViewTab;

    @FXML
     TableColumn<Joueur,String> nomCol;

    @FXML
     TableColumn<Joueur,String> prenomCol;

    @FXML
     TableColumn<Joueur,Date> neCol;

    @FXML
     TableColumn<Joueur,Poste> posCol;

    @FXML
     TableColumn<Joueur,Integer> phyCol;

    @FXML
     TableColumn<Joueur,Integer> moralCol;

    @FXML
     TableColumn<Joueur,Integer> noteCol;

    @FXML
    public void initialize() {
        equipeCol.setCellValueFactory(new PropertyValueFactory<Equipe, String>("nom"));
        ptsCol.setCellValueFactory(new PropertyValueFactory<Equipe, Integer>("nbPoints"));
        victCol.setCellValueFactory(new PropertyValueFactory<Equipe, Integer>("nbVictoires"));
        defCol.setCellValueFactory(new PropertyValueFactory<Equipe, Integer>("nbDefaites"));
        nulCol.setCellValueFactory(new PropertyValueFactory<Equipe, Integer>("nbMatchsNuls"));
        bPourCol.setCellValueFactory(new PropertyValueFactory<Equipe, Integer>("nbButsMarques"));
        bContreCol.setCellValueFactory(new PropertyValueFactory<Equipe, Integer>("nbButsEncaisses"));
        /*Entraineur e = PartieSingleton.INSTANCE.getEntraineur();
        System.out.println(PartieSingleton.INSTANCE);
        System.out.println(e);
        Equipe eq = e.getEquipe();
        System.out.println(eq);
        Ligue lg = eq.getLigue();
        System.out.println(lg);
        List<Equipe> equi=lg.getEquipes();
        System.out.println(equi);*/
        ObservableList<Equipe> equipesAMontrer = FXCollections.observableArrayList(PartieSingleton.INSTANCE
                .getEntraineur().getEquipe().getLigue().getEquipes());
        classementTeamsViewTab.setItems(equipesAMontrer);
        
        dateCol.setCellValueFactory(new PropertyValueFactory<>("dateDeLEvenement"));
        eq1Col.setCellValueFactory(new PropertyValueFactory<>("equipe1"));
        eq2Col.setCellValueFactory(new PropertyValueFactory<>("equipe2"));
        stadeCol.setCellValueFactory(new PropertyValueFactory<>("stade"));
        
        List<Match> calendrierEquipe = PartieSingleton.INSTANCE.getEntraineur().getEquipe().getMatchsDeLequipe();
        calendrierEquipe.sort((m1,m2)->(m1.getDateDeLEvenement().after(m2.getDateDeLEvenement()))?1:((m2.getDateDeLEvenement().after(m1.getDateDeLEvenement()))?-1:0));
        ObservableList<Match> calendrierAMontrer = FXCollections.observableArrayList(calendrierEquipe);
        calendrierViewTab.setItems(calendrierAMontrer);
        
        nomCol.setCellValueFactory(new PropertyValueFactory<Joueur, String>("nom"));
        prenomCol.setCellValueFactory(new PropertyValueFactory<Joueur, String>("prenom"));
        neCol.setCellValueFactory(new PropertyValueFactory<Joueur, Date>("dateDeNaissance"));
        posCol.setCellValueFactory(new PropertyValueFactory<Joueur, Poste>("poste"));
        phyCol.setCellValueFactory(new PropertyValueFactory<Joueur, Integer>("etatPhysique"));
        moralCol.setCellValueFactory(new PropertyValueFactory<Joueur, Integer>("moral"));
        noteCol.setCellValueFactory(new PropertyValueFactory<Joueur, Integer>("notePerformancesRecentes"));
        
        List<Joueur> joueursEquipe = PartieSingleton.INSTANCE.getEntraineur().getEquipe().getJoueurs();
        ObservableList<Joueur> joueursAAfficher = FXCollections.observableArrayList(joueursEquipe);
        effectifViewTab.setItems(joueursAAfficher);
        
        Entraineur moi = PartieSingleton.INSTANCE.getEntraineur();
        Equipe monEquipe = moi.getEquipe();
        nomDuClubLabel.setText(PartieSingleton.INSTANCE.getEntraineur().getEquipe().getNom());
        budgetDesTransfertsLabel.setText(String.valueOf(monEquipe.getBudgetTransferts()));
        masseSalarialeLabel.setText(String.valueOf(monEquipe.getMasseSalariale()));
        histoireDuClubLabel.setText(monEquipe.getHistoireDuClub());
        monNomLabel.setText(moi.getNom());
        monPrenomLabel.setText(moi.getPrenom());
        maDateDeNaissanceLabel.setText(moi.getDateDeNaissance().toString());
        monHistoireLabel.setText(moi.getHistoriqueCarriere());
    }

}
