package com.olivestays.service;

import java.util.List;

import com.olivestays.dto.request.HotelRequest;
import com.olivestays.dto.request.UpdatePasswordRequest;
import com.olivestays.dto.request.UpdateRequest;
import com.olivestays.dto.response.HotelResponse;

public interface HotelService {

	public HotelResponse registerHotel(HotelRequest hotelRequest);

	public String updateName(UpdateRequest updateRequest);

	public String updatePassword(UpdatePasswordRequest updatePasswordRequest);

	public String updatePhone(UpdateRequest updateRequest);

	public String updateTelephone(UpdateRequest updateRequest);

	public String updateHotelType(UpdateRequest updateRequest);

	public HotelResponse getHotelById(Long id);

	public List<HotelResponse> getHotelsNearMe();

	public List<HotelResponse> getHotelsInCity(String city);

}
