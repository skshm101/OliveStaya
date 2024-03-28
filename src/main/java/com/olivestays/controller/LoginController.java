package com.olivestays.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olivestays.model.Admin;
import com.olivestays.model.Customer;
import com.olivestays.model.Hotel;
import com.olivestays.repository.AdminDao;
import com.olivestays.repository.CustomerDao;
import com.olivestays.repository.HotelDao;


/**
 * Controller Class for Login
* @author Saksham_Garg
* @version 1.0
* @package com.olivestays.controller
* @project OliveStays
* @since 28-Mar-2024
 */
@RestController
@RequestMapping("/olivestays")
public class LoginController {
    @Autowired
    private AdminDao adminDao;

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private HotelDao hotelDao;

    @PostMapping("/admins/login")
    public ResponseEntity<Admin> getLoggedInAdminDetailsHandler(Authentication auth) {
        Admin admin = adminDao.findByEmail(auth.getName())
                .orElseThrow(() -> new BadCredentialsException("Invalid Username or password"));
        return new ResponseEntity<>(admin, HttpStatus.ACCEPTED);
    }

    @PostMapping("/customers/login")
    public ResponseEntity<Customer> getLoggedInCustomerDetailsHandler(Authentication auth) {
        Customer customer = customerDao.findByEmail(auth.getName())
                .orElseThrow(() -> new BadCredentialsException("Invalid Username or password"));
        return new ResponseEntity<>(customer, HttpStatus.ACCEPTED);
    }

    @PostMapping("/hotels/login")
    public ResponseEntity<Hotel> getLoggedInHotelDetailsHandler(Authentication auth) {
        Hotel hotel = hotelDao.findByHotelEmail(auth.getName())
                .orElseThrow(() -> new BadCredentialsException("Invalid Username or password"));
        return new ResponseEntity<>(hotel, HttpStatus.ACCEPTED);
    }
    
}    
