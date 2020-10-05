package com.kk.flightreservation.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kk.flightreservation.entities.Flight;
import com.kk.flightreservation.repository.FlightRepository;

@Controller
public class FlightController {

	@Autowired
	private FlightRepository flightRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(FlightController.class);

	@RequestMapping(value = "/findFlights", method = RequestMethod.POST)
	public String findFlights(@RequestParam("from") String from, @RequestParam("to") String to,
			@RequestParam("departureDate") @DateTimeFormat(pattern = "MM-dd-yyyy") Date departureDate, ModelMap model) {
		LOGGER.info("Inside findFlights() From " + from + " TO:" + to + " Departure Date " + departureDate);

		List<Flight> flights = flightRepository.findFlights(from, to, departureDate);
		model.addAttribute("flights", flights);

		LOGGER.info("Flights Found are: " + flights);
		return "displayFlights";
	}

	@RequestMapping("/admin/showAddFLight")
	public String showAddFLight() {
		// TODO: Update the flights in db
		return "addFlight";
	}
}
