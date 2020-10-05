package com.kk.flightreservation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kk.flightreservation.dto.ReservationRequest;
import com.kk.flightreservation.entities.Flight;
import com.kk.flightreservation.entities.Reservation;
import com.kk.flightreservation.repository.FlightRepository;
import com.kk.flightreservation.service.ReservationService;

@Controller
public class ReservationController {

	@Autowired
	private FlightRepository flightRepository;

	@Autowired
	private ReservationService reservationService;

	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);

	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap model) {
		LOGGER.info("Inside showCompleteReservation() invoked with the flight id: " + flightId);

		Flight flight = flightRepository.findById(flightId).orElse(null);
		model.addAttribute("flight", flight);

		LOGGER.info("FLight is " + flight);
		return "completeReservation";
	}

	@RequestMapping(value = "/completeReservation", method = RequestMethod.POST)
	public String completeReservation(ReservationRequest reservationRequest, ModelMap model) {
		LOGGER.info("completeReservation() " + reservationRequest);

		Reservation reservation = reservationService.bookFLight(reservationRequest);
		model.addAttribute("msg", "Reservation has created successfully and the id is " + reservation.getId());

		return "reservationConfirmation";
	}
}
