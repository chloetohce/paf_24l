package paf.lecture.paf_24l.model;

import java.util.Date;

public class Reservation {
    private int id;

    private String name;

    private Date reservationDate;

    public Reservation() {
    }

    public Reservation(int id, String name, Date reservationDate) {
        this.id = id;
        this.name = name;
        this.reservationDate = reservationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    
    
}
