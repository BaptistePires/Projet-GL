package ihm.controllers;

import java.sql.Date;
import java.time.ZoneId;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import model.PartieSingleton;

public class CustomDialogDateController {
    @FXML
     DatePicker datePicker;

    @FXML
    public void validerAction() {
        if(PartieSingleton.INSTANCE.getDateCourante().getJourCourant().after(Date.from(datePicker.getValue()
                .atStartOfDay(ZoneId.systemDefault()).toInstant())))return;
        try{
            PartieSingleton.INSTANCE.avancerLeTempsJusqua(Date.from(datePicker.getValue()
                    .atStartOfDay(ZoneId.systemDefault()).toInstant()));
        }catch(Exception e){
            e.printStackTrace();
            System.err.println("Erreur en essayant d'avancer le temps jusqu'à "+datePicker.getValue());
        }
        ((Stage)datePicker.getScene().getWindow()).close();
    }

}
