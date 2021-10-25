package com.esprit.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/reservations")
public class ReservationRestApi {
@Autowired
private ReservationService ReservationService;
@PostMapping("/addReservation")
@ResponseStatus(HttpStatus.CREATED)
 public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation){
return new ResponseEntity<>(ReservationService.addReservation(reservation),HttpStatus.OK);
}
@PutMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
@ResponseStatus(HttpStatus.OK)
public ResponseEntity<Reservation> updateUser(@PathVariable(value="id") int id ,@RequestBody Reservation reservation){
return new ResponseEntity<>(ReservationService.updateReservation(reservation, id),HttpStatus.OK);

}
@DeleteMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
@ResponseStatus(HttpStatus.OK)
public ResponseEntity<String> deleteReservation(@PathVariable(value="id") int id ){
return new ResponseEntity<>(ReservationService.deleteReservation(id),HttpStatus.OK);

}

}
