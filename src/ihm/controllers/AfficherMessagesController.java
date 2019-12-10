package ihm.controllers;

import java.awt.event.ActionEvent;
import java.util.Observable;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.effect.Light;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import model.Message;

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
    private Label contenuMessage;

    @FXML
    private void initialize() {
        Platform.runLater(() -> {
        //            listView = new ListView<String>();
            ObservableList<Message> items = FXCollections.observableArrayList();
            items.add(new Message("Msg 1"));
            items.add(new Message("Msg 2"));
            items.add(new Message("Msg 3eeeeeeeeeeeeffffffffffffffffffffffffffffffffffeeeeeeeeeeeeeeeeeeeeeeeee"));
            items.add(new Message("Msg 4"));
            items.add(new Message("Msg 5"));
            listView.setItems(items);
            listView.setCellFactory(param -> {
                ListCell<Message> cell = new ListCell<Message>() {
                    @Override
                    protected void updateItem(Message item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty || item == null || item.getContenu() == null) {
                            setText(null);
                        } else {
                            setText(item.getContenu());
                        }
                    }
                };
                cell.setOnMouseClicked(e -> {
                    updateAfficherContenu(cell.getItem().getContenu());
                    cell.getItem().setLu();
                });
                return cell;
            });
        
        
        });
    }

    public void updateAfficherContenu(String contenu) {
        contenuMessage.setText(contenu);
        ;
    }

}
