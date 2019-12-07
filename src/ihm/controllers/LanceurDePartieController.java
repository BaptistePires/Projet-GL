package ihm.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.stage.FileChooser;
import model.LanceurDePartie;
import model.Main;

import java.io.File;
import java.net.URL;
import java.util.Optional;

public class LanceurDePartieController {
    @FXML
    Button nouvellePartieBouton;

    @FXML
    Button chargerPartieBouton;

    @FXML
    Button quitterBouton;

    @FXML
    public void nouvellePartieAction(){
        TextInputDialog dialog = new TextInputDialog("partie_"+(int)(Math.random()*1000));
        dialog.setTitle("Nom de la partie");
        dialog.setHeaderText("Inserez le nom de la partie");
        dialog.setContentText("Veuillez entrer le nom sous lequel vous voudrez sauvegarder votre partie :");

        Optional<String> result=dialog.showAndWait();;
        result.ifPresent(name -> {
            LanceurDePartie.INSTANCE.lancerNouvellePartie(name);
            try{
                URL resource = getClass().getResource("../creerNouvellePartie.fxml");
                System.out.println(resource);
                Main.mainStage.setScene(new Scene(FXMLLoader.load(resource)));
            }catch(Exception e){
                e.printStackTrace();
                System.err.println("Erreur lors du lancement de l'initialisation de la partie : "+e.getClass()+" : "+e.getMessage());
            }
        });
    }

    @FXML
    public void chargerPartieAction(){
        final FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(Main.mainStage);
        if(file!=null){
            LanceurDePartie.INSTANCE.chargerPartieExistante("src/data/"+LanceurDePartie.dossierDeStockageDesParties+"/"+file.getName());
            try{
                Main.mainStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../ecranDuJeu.fxml"))));
            }catch(Exception e){
                e.printStackTrace();
                System.err.println("Erreur lors de l'affichage de l'ecran principal du jeu : "+e.getClass()+" "+e.getMessage());
            }
        }
    }

    @FXML
    public void quitterAction(){
        LanceurDePartie.INSTANCE.quitter();
    }
}
