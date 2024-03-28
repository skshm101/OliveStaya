package com.olivestays.service.impl;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olivestays.enums.Role;
import com.olivestays.exception.AdminException;
import com.olivestays.model.Admin;
import com.olivestays.repository.AdminDao;
import com.olivestays.service.AdminService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Admin Service Implementation
* @author Saksham_Garg
* @version 1.0
* @package com.olivestays.service.impl
* @project OliveStays
* @since 28-Mar-2024
 */
@Service
@Slf4j
@AllArgsConstructor
@Transactional
public class AdminServiceImpl implements AdminService {

	private AdminDao aDao;
	private PasswordEncoder passwordEncoder;

	@Override
	public Admin registerAdmin(Admin admin) throws AdminException {
		Optional<Admin> adminExist = aDao.findByEmail(admin.getEmail());

		if (adminExist.isPresent()) {
			throw new AdminException("Admin already registered with this email!");
		}

		String hashedPassword = passwordEncoder.encode(admin.getPassword());
		admin.setPassword(hashedPassword);
		admin.setRole(Role.ROLE_ADMIN);

		return aDao.save(admin);
	}

}
