package com.esprit.microservice;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReservationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservationsApplication.class, args);
	}
	@Bean
	ApplicationRunner init(ReservationRepository repository) {
	return args ->{
	Stream.of("sidibou","gamarth","centre ville").forEach(lieu ->{
	repository.save(new Reservation(lieu));
	});
	repository.findAll().forEach(System.out::println);
	};
	}

}
