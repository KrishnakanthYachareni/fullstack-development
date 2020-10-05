package com.kk.flightreservation.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.kk.flightreservation.dto.ReservationRequest;
import com.kk.flightreservation.entities.Flight;
import com.kk.flightreservation.entities.Passenger;
import com.kk.flightreservation.entities.Reservation;
import com.kk.flightreservation.repository.FlightRepository;
import com.kk.flightreservation.repository.PassengerRepository;
import com.kk.flightreservation.repository.ReservationRepository;
import com.kk.flightreservation.util.EmailUtility;
import com.kk.flightreservation.util.PDFGenerator;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Value("${com.kk.flightreservation.itinerary.dirpath}")
	private String ITINERARY_DIR;

	@Autowired
	private FlightRepository flightRepository;

	@Autowired
	private PassengerRepository passengerRepository;

	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	private PDFGenerator pdfGenerator;

	@Autowired
	private EmailUtility emailUtility;

	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);

	@Transactional
	@Override
	public Reservation bookFLight(ReservationRequest request) {

		// TODO: Make Payment through Payment gateway.

		LOGGER.info("Inside bookFLight()");

		Long flightId = request.getFlightId();

		LOGGER.info("Fetching the flight for flight id: " + flightId);
		Flight flight = flightRepository.findById(flightId).orElse(null);

		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setEmail((request.getPassengerEmail()));
		passenger.setPhone(request.getPassengerPhone());

		LOGGER.info("Saving the Passenger " + passenger);
		Passenger savedPassenger = passengerRepository.save(passenger);

		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);

		LOGGER.info("Saving the Reservation " + reservation);
		Reservation savedReservation = reservationRepository.save(reservation);

		// PDF Generation
		String pdfPath = ITINERARY_DIR + savedReservation.getId() + ".pdf";
		LOGGER.info("Generating the Itinerary");
		pdfGenerator.generateItinerary(savedReservation, pdfPath);

		LOGGER.info("Emailing the Itinerary");
		// Email sending.
		emailUtility.sendEmailItinerary(passenger.getEmail(), pdfPath);

		return savedReservation;
	}

}
