package com.olivestays.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.olivestays.model.Admin;
import com.olivestays.model.Customer;
import com.olivestays.model.Hotel;
import com.olivestays.repository.AdminDao;
import com.olivestays.repository.CustomerDao;
import com.olivestays.repository.HotelDao;

/**
 * Customer Service
* @author Saksham_Garg
* @version 1.0
* @package com.olivestays.service
* @project OliveStays
* @since 28-Mar-2024
 */
@Service
public class CustomDetailsService implements UserDetailsService {

	@Autowired
	private CustomerDao cDao;

	@Autowired
	private AdminDao aDao;

	@Autowired
	private HotelDao hDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Customer> customerOptional = cDao.findByEmail(username);

		Optional<Admin> adminOptional = aDao.findByEmail(username);

		Optional<Hotel> hotelOptional = hDao.findByHotelEmail(username);

		if (!customerOptional.isPresent() && !adminOptional.isPresent() && !hotelOptional.isPresent()) {
			throw new UsernameNotFoundException("User with email " + username + " not found");
		}

		List<GrantedAuthority> authorities = new ArrayList<>();

		if (customerOptional.isPresent()) {
			Customer customer = customerOptional.get();
			SimpleGrantedAuthority sga = new SimpleGrantedAuthority(customer.getRole().toString());
			authorities.add(sga);
			return new User(customer.getEmail(), customer.getPassword(), authorities);

		} else if (adminOptional.isPresent()) {
			Admin admin = adminOptional.get();
			SimpleGrantedAuthority sga = new SimpleGrantedAuthority(admin.getRole().toString());
			authorities.add(sga);
			return new User(admin.getEmail(), admin.getPassword(), authorities);
		} else {
			Hotel hotel = hotelOptional.get();
			SimpleGrantedAuthority sga = new SimpleGrantedAuthority(hotel.getRole().toString());
			authorities.add(sga);
			return new User(hotel.getHotelEmail(), hotel.getPassword(), authorities);
		}
	}
}
