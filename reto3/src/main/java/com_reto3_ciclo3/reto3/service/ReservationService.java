package com_reto3_ciclo3.reto3.service;

import com_reto3_ciclo3.reto3.exceptions.ResourceNotFound;
import com_reto3_ciclo3.reto3.model.Reservation;
import com_reto3_ciclo3.reto3.repository.IReservationRepository;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Log4j
@Service
public class ReservationService {

    private IReservationRepository reservationRepository;

    @Autowired
    public ReservationService(IReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Collection<Reservation> findAllReservations(){
        log.info("Se buscaron todas las Reservaciones");
        return reservationRepository.findAll();
    }

    public Reservation findById(Integer id) throws ResourceNotFound {
        Optional<Reservation> reservation = reservationRepository.findById(id);
        if (reservation.isEmpty()){
            throw new ResourceNotFound("No se encontro la Reservacion con id: " + id);
        }else{
            log.info("Se busco la Reservacion con id: " + id);
            return reservation.get();
        }
    }

    public Reservation saveReservation(Reservation r){
        r.setIdReservation(null);
        Reservation reservation = reservationRepository.save(r);
        log.info("Se guardo la Reservacion con id : " + reservation.getIdReservation());
        return reservation;
    }
}
