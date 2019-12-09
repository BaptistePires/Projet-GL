package ihm.controllers;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.effect.Light;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import model.Message;
import model.PartieSingleton;

import java.awt.event.ActionEvent;
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

    @FXML
    private void initialize() {
        Platform.runLater(() -> {
//            listView = new ListView<String>();
            ObservableList<Message> items = FXCollections.observableArrayList();
            items.addAll(PartieSingleton.INSTANCE.getBoiteMail().getMessages());
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


        });
    }

        public void updateAfficherContenu (String contenu, String titre){
            contenuMessage.setText(contenu);
            titreMsg.setText(titre);
            ;
        }

    }

