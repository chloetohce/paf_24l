package paf.lecture.paf_24l.repository;

import java.sql.Date;
import java.sql.PreparedStatement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import paf.lecture.paf_24l.model.Reservation;
import paf.lecture.paf_24l.model.ReservationDetails;

@Repository
public class ReservationRepository {
    @Autowired
    private JdbcTemplate template;

    /**
     * Adds the specified reservation to the SQL database and returns the primary key of the object added. 
     * @param r reservation object to be created
     * @return primary key of the reservation added
     */
    public int createReservation(Reservation r) {
        KeyHolder key = new GeneratedKeyHolder();
        template.update(con -> {
            PreparedStatement ps = con.prepareStatement(QueryReservations.INSERT_RESERVATION);
            ps.setString(1, r.getName());
            ps.setDate(2, new Date(r.getReservationDate().getTime()));
            return ps;
            }, 
            key);

        int rid = key.getKey().intValue();

        return rid;
    }

    public boolean createReservationDetails(ReservationDetails r) {
        int added = template.update(QueryReservations.INSERT_RESERVATION_DETAILS, r.getBook().getId(), r.getReservation().getId());
        return added > 0;
    }
}
