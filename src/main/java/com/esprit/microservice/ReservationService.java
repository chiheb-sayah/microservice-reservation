package com.esprit.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ReservationService {
@Autowired
private ReservationRepository ReservationRepository;

public Reservation addReservation(Reservation r) {
return ReservationRepository.save(r);
}
    public Reservation updateReservation(Reservation newr , int id) {
    if(ReservationRepository.findById(id).isPresent()) {
    Reservation reservation=ReservationRepository.findById(id).get();
    reservation.setBand(newr.getBand());
    reservation.setDate(newr.getDate());
    reservation.setLieu(newr.getLieu());
    return ReservationRepository.save(reservation);
    }
    else return null;
   
    }
    public String deleteReservation(int id)
    { if(ReservationRepository.findById(id).isPresent()) {
    ReservationRepository.deleteById(id);
    return "Reservation  supprime !";
}
    else return "Reservation non supprimé !";
   
    }
}