package com.olivestays.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olivestays.model.Admin;
import com.olivestays.service.AdminService;

import lombok.AllArgsConstructor;

/**
 * Controller class for Admin
* @author Saksham_Garg
* @version 1.0
* @package com.olivestays.controller
* @project OliveStays
* @since 28-Mar-2024
 */
@RestController
@RequestMapping("/olivestays/admins")
@AllArgsConstructor
public class AdminController {

	private AdminService adminService;
	
	@PostMapping("/register")
	public ResponseEntity<Admin> registerAdmin(@RequestBody Admin admin){
		
		Admin res = adminService.registerAdmin(admin);
		
		return new ResponseEntity<Admin>(res,HttpStatus.CREATED);
	}
}
