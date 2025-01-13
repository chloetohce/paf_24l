package paf.lecture.paf_24l.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import paf.lecture.paf_24l.service.ReservationService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import paf.lecture.paf_24l.model.ReservationDetails;


@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    @Autowired
    private ReservationService service;

    @PostMapping("")
    public ResponseEntity<Boolean> addReservation(@RequestBody ReservationDetails details) {
        boolean b = service.createReservationRecord(details.getReservation(), details);
        return ResponseEntity.ok(b);
    }
    
}
