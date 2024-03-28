package com.olivestays.dto.response;

import java.util.List;

import com.olivestays.enums.HotelType;
import com.olivestays.model.Address;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HotelResponse {

	private Long hotelId;

	private String name;

	private String hotelTelephone;

	private Address address;

	@Enumerated(EnumType.STRING)
	private HotelType hotelType;

	private List<String> amenities;

}
