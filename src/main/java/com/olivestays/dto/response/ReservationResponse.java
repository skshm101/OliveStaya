package com.olivestays.dto.response;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.olivestays.dto.Payment;
import com.olivestays.enums.ReservationStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationResponse {

	private Long reservationId;

	private String customerName;

	private Integer roomNumber;

	private String hotelName;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate checkinDate;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate checkoutDate;

	private Integer noOfPerson;

	private Payment payment;

	private ReservationStatus status;

}
