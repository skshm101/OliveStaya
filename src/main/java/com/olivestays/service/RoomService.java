package com.olivestays.service;

import java.util.List;

import com.olivestays.dto.request.DateRequest;
import com.olivestays.dto.request.RoomRequest;
import com.olivestays.dto.request.UpdateRequest;
import com.olivestays.dto.response.RoomResponse;

public interface RoomService {

	public RoomResponse addRoom(RoomRequest roomRequest);

	public String updateRoomType(UpdateRequest updateRequest, Long roomId);

	public String updateNoOfPerson(UpdateRequest updateRequest, Long roomId);

	public String updatePrice(UpdateRequest updateRequest, Long roomId);

	public String updateAvailable(UpdateRequest updateRequest, Long roomId);

	public String removeRoom(UpdateRequest updateRequest);

	public List<RoomResponse> getAllAvailableRoomsByHotelId(Long hotelId, DateRequest dateRequest);

	public List<RoomResponse> getAllRoomsByHotel();

}
