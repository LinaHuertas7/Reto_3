package com_reto3_ciclo3.reto3.controller;

import com_reto3_ciclo3.reto3.exceptions.ResourceNotFound;
import com_reto3_ciclo3.reto3.model.Reservation;
import com_reto3_ciclo3.reto3.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {
    private ReservationService reservationService;

    @Autowired

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    /*------------------------------------------------------------------------------------------------------*/

    //GET REQUEST
    @GetMapping("/all")
    public ResponseEntity<?> findAllReservations(){
        return ResponseEntity.ok(reservationService.findAllReservations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>findReservationById(@PathVariable Integer id) throws ResourceNotFound {
        Reservation reservation = reservationService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(reservation);
    }

    //POST REQUEST
    @PostMapping("/save")
    public ResponseEntity<Reservation> registrerReservation(@RequestBody Reservation r){
        Reservation reservation = reservationService.saveReservation(r);
        return ResponseEntity.status(HttpStatus.CREATED).body(reservation);
    }
}
