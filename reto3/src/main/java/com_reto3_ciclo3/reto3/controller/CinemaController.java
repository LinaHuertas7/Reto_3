package com_reto3_ciclo3.reto3.controller;

import com_reto3_ciclo3.reto3.exceptions.ResourceNotFound;
import com_reto3_ciclo3.reto3.model.Cinema;
import com_reto3_ciclo3.reto3.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Cinema")
public class CinemaController {

    private CinemaService cinemaService;

    @Autowired
    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    /*------------------------------------------------------------------------------------------------------*/

    //GET REQUEST
    @GetMapping("/all")
    public ResponseEntity<?>findAllCinemas(){
        return ResponseEntity.ok(cinemaService.findAllCinemas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>findCinemaById(@PathVariable Integer id) throws ResourceNotFound {
        Cinema cinema = cinemaService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(cinema);
    }

    //POST REQUEST
    @PostMapping("/save")
    public ResponseEntity<Cinema> registrerCinema(@RequestBody Cinema c){
        Cinema cinema = cinemaService.saveCinema(c);
        return ResponseEntity.status(HttpStatus.CREATED).body(cinema);
    }
}
