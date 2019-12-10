package ihm.controllers;

import java.awt.event.ActionEvent;
import java.util.Observable;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.effect.Light;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import model.BoiteMail;
import model.Message;
import model.PartieSingleton;

import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.Observable;

public class AfficherMessagesController {
    @FXML
    private VBox splitPane;

    @FXML
    private SplitPane mainPane;

    @FXML
    private AnchorPane panaListMsgs;

    @FXML
    private ListView<Message> listView;

    @FXML
    private AnchorPane paneAfficherMsg;


    @FXML
    private TextArea contenuMessage;

    @FXML
    private Text titreMsg;

    @FXML private Label labelDateMsg;

    private BoiteMail boiteMail;

    public BoiteMail getBoiteMail() {
        return boiteMail;
    }

    public void setBoiteMail(BoiteMail boiteMail) {
        this.boiteMail = boiteMail;
    }

    @FXML
    private void initialize() {
        if(boiteMail==null){
            boiteMail = PartieSingleton.INSTANCE.getBoiteMail();
        }
        listView.setItems(FXCollections.observableArrayList(boiteMail.getMessages()));
        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Message>() {
            @Override
            public void changed(ObservableValue<? extends Message> observable, Message oldValue, Message newValue) {
                updateAfficherContenu(newValue.getContenu(),newValue.getTitre(),newValue.getDate());
                newValue.setLu();
            }
        });


        /*Platform.runLater(() -> {
//          listView = new ListView<String>();
            ObservableList<Message> items = FXCollections.observableArrayList(boiteMail.getMessages());
            items.addAll(PartieSingleton.INSTANCE.getBoiteMail().getMessages());
            System.out.println(PartieSingleton.INSTANCE.getBoiteMail().getMessages());
            listView.setItems(items);
            if(items.size() == 0) {
                titreMsg.setText("Aucun message");
            }
            listView.setCellFactory(param -> {
                ListCell<Message> cell = new ListCell<Message>() {
                    @Override
                    protected void updateItem(Message item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty || item == null || item.getContenu() == null) {
                            setText(null);
                        } else {
                            setText(item.getTitre());
                        }
                    }
                };
                cell.setOnMouseClicked(e -> {
                    updateAfficherContenu(cell.getItem().getContenu(), cell.getItem().getTitre());
                    cell.getItem().setLu();
                });
                return cell;
            });
        });*/
    }

    public void updateAfficherContenu (String contenu, String titre, Date date){
        contenuMessage.setText(contenu);
        contenuMessage.setEditable(false);
        titreMsg.setText(titre);
        labelDateMsg.setText(String.format("%d-%d-%d",date.getDate(), date.getMonth()+1,date.getYear()+1900));
    }

}


