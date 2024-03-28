package com.olivestays.service;

import java.util.List;

import com.olivestays.dto.request.ReservationRequest;
import com.olivestays.dto.response.ReservationResponse;

public interface ReservationService {

	public ReservationResponse createReservation(Long roomId, ReservationRequest reservationRequest);

	public String cancelReservation(Long reservationId);

	public List<ReservationResponse> getAllReservationsOfHotel();

	public List<ReservationResponse> getAllReservationsOfCustomer();

	public ReservationResponse getReservationById(Long ReservationId);

}
