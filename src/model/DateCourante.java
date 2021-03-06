package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class DateCourante implements Serializable {
    private Date dateDuJour;

    public Date getJourCourant() {
        return dateDuJour;
    }

    public void avancerDUnJour() {
        dateDuJour = new Date(dateDuJour.getTime() + (1000 * 60 * 60 * 24));
    }

    public void setJourCourant(Date date) {
        this.dateDuJour = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DateCourante)) return false;
        DateCourante that = (DateCourante) o;
        return Objects.equals(dateDuJour, that.dateDuJour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateDuJour);
    }

    @Override
    public String toString() {
        return dateDuJour.getDate()+"/"+(dateDuJour.getMonth()+1)+"/"+(dateDuJour.getYear()+1900);
    }

}
