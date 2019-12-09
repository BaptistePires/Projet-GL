package model;

import java.io.Serializable;

public class StrategieOffensive extends Strategie implements Serializable {
    public void appliquer() {
        this.setAgressivite(40);
        this.setAttaque(75);
        this.setDefense(25);
        this.setPasses(50);
        this.setMilieu(50);
    }
}
