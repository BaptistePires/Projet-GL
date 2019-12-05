package model;

import java.util.Date;

public class DateCourante {
    private Date dateDuJour;

    public Date getJourCourant() {
        return dateDuJour;
    }

    public void avancerDUnJour() {
        dateDuJour = new Date(dateDuJour.getTime() + (1000 * 60 * 60 * 24));
    }

}
