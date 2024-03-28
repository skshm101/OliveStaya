package com.olivestays.service;

import java.util.List;

import com.olivestays.dto.request.CustomerRequest;
import com.olivestays.dto.request.UpdatePasswordRequest;
import com.olivestays.dto.request.UpdateRequest;
import com.olivestays.dto.response.CustomerResponse;

/**
 * Customer Service
* @author Saksham_Garg
* @version 1.0
* @package com.olivestays.service
* @project OliveStays
* @since 28-Mar-2024
 */
public interface CustomerService {

	public CustomerResponse registerCustomer(CustomerRequest customerRequest);

	public String updateName(UpdateRequest updateRequest);

	public String updatePassword(UpdatePasswordRequest updatePasswordRequest);

	public String updatePhone(UpdateRequest updateRequest);

	public String deleteCustomer(UpdateRequest updateRequest);

	public List<CustomerResponse> getToBeDeletedCustomers();

	public CustomerResponse viewProfile();

}
