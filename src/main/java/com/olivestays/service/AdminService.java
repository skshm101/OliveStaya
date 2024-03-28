package com.olivestays.service;

import com.olivestays.exception.AdminException;
import com.olivestays.model.Admin;

/**
 * Admin Service
* @author Saksham_Garg
* @version 1.0
* @package com.olivestays.service
* @project OliveStays
* @since 28-Mar-2024
 */
public interface AdminService {
	public Admin registerAdmin(Admin admin) throws AdminException;
	
}
