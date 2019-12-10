package model;

import java.io.Serializable;

public class StrategieTransition extends Strategie implements Serializable {
    public void appliquer() {
        this.setAgressivite(50);
        this.setAttaque(65);
        this.setDefense(50);
        this.setPasses(80);
        this.setMilieu(30);
    }

}
