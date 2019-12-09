package model;

import java.io.Serializable;

public class StrategieDefensive extends Strategie implements Serializable {
    public void appliquer() {
        this.setAgressivite(40);
        this.setAttaque(25);
        this.setDefense(75);
        this.setPasses(50);
        this.setMilieu(50);
    }

}
