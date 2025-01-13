package paf.lecture.paf_24l.repository;

public class QueryReservations {
    public static final String INSERT_RESERVATION = "insert into reservations(name, reservation_date) values (?, ?);";

    public static final String INSERT_RESERVATION_DETAILS = "insert into reservation_details(book_id, reservation_id) values (?, ?);";
    
}
