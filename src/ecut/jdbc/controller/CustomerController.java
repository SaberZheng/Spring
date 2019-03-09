package ecut.jdbc.controller;

import ecut.jdbc.service.CustomerService;

public class CustomerController {
	
	private CustomerService customerService ;

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

}
