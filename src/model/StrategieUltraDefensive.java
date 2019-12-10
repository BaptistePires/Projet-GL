package model;

import java.io.Serializable;

public class StrategieUltraDefensive extends Strategie implements Serializable {
    public void appliquer() {
        this.setAgressivite(60);
        this.setAttaque(5);
        this.setDefense(95);
        this.setPasses(27);
        this.setMilieu(30);
    }

}
