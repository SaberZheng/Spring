package ecut.hibernate.controller;

import java.util.List;

import ecut.hibernate.entity.Customer;
import ecut.hibernate.service.CustomerService;

public class CustomerController {
	
	private CustomerService customerService ;
	
	public String regist( Customer c ){
		System.out.println(  "CustomerController # regist ." );
		customerService.save( c );
		return "success" ;
	}
	
	public List<Customer> allCustomer(){
		return customerService.findAll();
	}

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

}
