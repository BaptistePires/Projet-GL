package ihm.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import model.LanceurDePartie;
import model.Main;

public class LanceurDePartieController {
    @FXML
    Button nouvellePartieBouton;

    @FXML
    Button chargerPartieBouton;

    @FXML
    Button quitterBouton;

    public void nouvellePartieCallback(){
    }

    public void chargerPartieCallback(){
    }

    public void quitterCallback(){
        LanceurDePartie.INSTANCE.quitter();
    }
}
