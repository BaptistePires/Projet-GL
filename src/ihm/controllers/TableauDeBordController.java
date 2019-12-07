package ihm.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Entraineur;
import model.Equipe;
import model.Ligue;
import model.PartieSingleton;

import java.util.List;

public class TableauDeBordController {


    @FXML
    TableView classementTeamsViewTab;

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
    public void initialize(){
        equipeCol.setCellValueFactory(new PropertyValueFactory<Equipe, String>("nom"));
        ptsCol.setCellValueFactory(new PropertyValueFactory<Equipe, Integer>("nbPoints"));
        victCol.setCellValueFactory(new PropertyValueFactory<Equipe, Integer>("nbVictoires"));
        defCol.setCellValueFactory(new PropertyValueFactory<Equipe, Integer>("nbDefaites"));
        nulCol.setCellValueFactory(new PropertyValueFactory<Equipe, Integer>("nbMatchsNuls"));
        bPourCol.setCellValueFactory(new PropertyValueFactory<Equipe, Integer>("nbButsMarques"));
        bContreCol.setCellValueFactory(new PropertyValueFactory<Equipe, Integer>("nbButsEncaisses"));
        Entraineur e = PartieSingleton.INSTANCE.getEntraineur();
        /*System.out.println(PartieSingleton.INSTANCE);
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
    }
}
