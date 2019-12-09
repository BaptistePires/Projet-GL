package model;

import java.io.Serializable;

public class StrategieUltraOffensive extends Strategie implements Serializable {
    public void appliquer() {
        this.setAgressivite(70);
        this.setAttaque(95);
        this.setDefense(5);
        this.setPasses(50);
        this.setMilieu(20);
    }

}
