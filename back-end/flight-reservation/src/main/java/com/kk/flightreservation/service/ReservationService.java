package com.kk.flightreservation.service;

import com.kk.flightreservation.dto.ReservationRequest;
import com.kk.flightreservation.entities.Reservation;

public interface ReservationService {
	
	Reservation bookFLight(ReservationRequest request);

}
