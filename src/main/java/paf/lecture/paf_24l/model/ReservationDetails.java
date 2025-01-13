package paf.lecture.paf_24l.model;

public class ReservationDetails {
    private int id;

    private Book book;

    private Reservation reservation;

    public ReservationDetails() {
    }

    public ReservationDetails(int id, Book book, Reservation reservation) {
        this.id = id;
        this.book = book;
        this.reservation = reservation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    
    
}
