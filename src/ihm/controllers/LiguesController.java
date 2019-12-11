package ihm.controllers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.Accordion;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.*;
import model.Fifa;

public class LiguesController {
    @FXML
     Accordion accordeon;

     Fifa fifa;

    @FXML
    public void initialize() {
        if(fifa==null){
            fifa = PartieSingleton.INSTANCE.getFifa();
        }
        for(Ligue l: fifa.getLigues()){
            AnchorPane ap = new AnchorPane();
            TitledPane tp = new TitledPane();
            tp.setText(l.getNom());
            accordeon.getPanes().add(tp);
            tp.setContent(ap);
            TableView<Equipe> eqTV = new TableView<Equipe>();
            eqTV.setItems(FXCollections.observableArrayList(l.getEquipes()));
            eqTV.setMinWidth(ap.getPrefWidth());
            Button btnGo = new Button("Aller à l'équipe séléctionnée");
        
            VBox vb = new VBox();
            vb.getChildren().addAll(eqTV, btnGo);
            ap.getChildren().add(vb);
        
            btnGo.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Equipe equipeSelectionnee = eqTV.getSelectionModel().getSelectedItem();
                    if(equipeSelectionnee!=null){
                        try{
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("../equipe.fxml"));
                            AnchorPane anchorPane = (AnchorPane)loader.load();
                            EquipeController ec = loader.<EquipeController>getController();
                            ec.setEquipe(equipeSelectionnee);
                            //System.out.println(ec);
                            Pane p = (Pane)accordeon.getParent().getParent();
                            p.getChildren().clear();
                            p.getChildren().add(anchorPane);
                        }catch(Exception e){
                            e.printStackTrace();
                            System.err.println("Erreur lors du chargement de l'équipe sélectionnée");
                        }
                    }
                }
            });
        
            TableColumn<Equipe, String> nomCol = new TableColumn<Equipe, String>("Nom");
            nomCol.setCellValueFactory(new PropertyValueFactory<Equipe, String>("nom"));
        
            TableColumn<Equipe, Integer> nbBMarqu = new TableColumn<Equipe, Integer>("Buts P");
            nbBMarqu.setCellValueFactory(new PropertyValueFactory<Equipe, Integer>("nbButsMarques"));
        
            TableColumn<Equipe, Integer> nbBEncaiss = new TableColumn<Equipe, Integer>("Buts C");
            nbBEncaiss.setCellValueFactory(new PropertyValueFactory<Equipe, Integer>("nbButsEncaisses"));
        
            TableColumn<Equipe, Integer> nbVict = new TableColumn<Equipe, Integer>("Victoires" );
            nbVict.setCellValueFactory(new PropertyValueFactory<Equipe, Integer>("nbVictoires"));
        
            TableColumn<Equipe, Integer> nbNul = new TableColumn<Equipe, Integer>("Nuls");
            nbNul.setCellValueFactory(new PropertyValueFactory<Equipe, Integer>("nbMatchsNuls"));
        
            TableColumn<Equipe, Integer> nbDef = new TableColumn<Equipe, Integer>("Défaites");
            nbDef.setCellValueFactory(new PropertyValueFactory<Equipe, Integer>("nbDefaites"));
        
            TableColumn<Equipe, Strategie> strat = new TableColumn<Equipe, Strategie>("Stratégie");
            strat.setCellValueFactory(new PropertyValueFactory<Equipe, Strategie>("strategie"));
        
            TableColumn<Equipe, Stade> stade = new TableColumn<Equipe, Stade>("Stade");
            stade.setCellValueFactory(new PropertyValueFactory<Equipe, Stade>("stade"));
        
            eqTV.getColumns().addAll(nomCol, nbBMarqu, nbBEncaiss, nbVict, nbNul, nbDef, strat, stade);
        
        
        }
    }

}
