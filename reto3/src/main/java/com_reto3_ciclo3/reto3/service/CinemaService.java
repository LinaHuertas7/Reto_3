package com_reto3_ciclo3.reto3.service;

import com_reto3_ciclo3.reto3.exceptions.ResourceNotFound;
import com_reto3_ciclo3.reto3.model.Cinema;
import com_reto3_ciclo3.reto3.repository.ICinemaRepository;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Log4j
@Service
public class CinemaService {

    private ICinemaRepository cinemaRepository;

    @Autowired

    public CinemaService(ICinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    public Collection<Cinema> findAllCinemas(){
        log.info("Se buscaron todos los cinemas");
        return cinemaRepository.findAll();
    }

    public Cinema findById(Integer id) throws ResourceNotFound {
        Optional<Cinema> cinema = cinemaRepository.findById(id);
        if (cinema.isEmpty()){
            throw new ResourceNotFound("No se encontro el cinema con id: " + id);
        }else{
            log.info("Se busco el cinema con id: " + id);
            return cinema.get();
        }
    }

    public Cinema saveCinema(Cinema c){
        c.setIdCinema(null);
        Cinema cinema = cinemaRepository.save(c);
        log.info("Se guardo el cinema con nombre: " + cinema.getName());
        return cinema;
    }



}
