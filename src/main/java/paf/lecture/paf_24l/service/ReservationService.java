package paf.lecture.paf_24l.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import paf.lecture.paf_24l.model.Reservation;
import paf.lecture.paf_24l.model.ReservationDetails;
import paf.lecture.paf_24l.repository.ReservationRepository;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository repository;

    @Transactional
    public boolean createReservationRecord(Reservation reservation, ReservationDetails details) {
        int rid = repository.createReservation(reservation);

        // Reservation details originally does not contain the id. Need to set manually.
        details.setId(rid);
        repository.createReservationDetails(details);
        return true;
    }
}
