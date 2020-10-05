package com.kk.flightreservation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kk.flightreservation.dto.ReservationUpdateRequest;
import com.kk.flightreservation.entities.Reservation;
import com.kk.flightreservation.repository.ReservationRepository;
import com.kk.flightreservation.util.PDFGenerator;

/**
 * 
 * @crossOrigin In any modern browser, the Cross-Origin Resource Sharing (CORS)
 *              is a relevant specification with the emergence of HTML5 and JS
 *              clients that consume data via REST APIs.
 * 
 *              In many cases, the host that serves the JS (e.g., example.com)
 *              is different from the host that serves the data (e.g.,
 *              api.example.com). In such a case, CORS enables cross-domain
 *              communication.
 * 
 *              Spring provides first-class support for CORS, offering an easy
 *              and powerful way of configuring it in any Spring or Spring Boot
 *              web application.
 *
 */

@RestController
@CrossOrigin
public class ReservationRESTController {

	@Autowired
	private ReservationRepository reservationRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationRESTController.class);

	@RequestMapping("/reservations/{id}")
	public Reservation findReservation(@PathVariable("id") Long id) {
		LOGGER.info("Inside findReservation() for id: " + id);

		return reservationRepository.findById(id).orElse(null);
	}

	@RequestMapping("/reservations")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		LOGGER.info("Inside updateReservation() : " + request);

		Reservation reservation = reservationRepository.findById(request.getId()).orElse(null);
		reservation.setCheckedIn(request.getCheckedIn());
		reservation.setNumberOfBags(request.getNumberOfBags());

		LOGGER.info("Saving Reservation");
		return reservationRepository.save(reservation);
	}

}
