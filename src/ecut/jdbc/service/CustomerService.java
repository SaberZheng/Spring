package ecut.jdbc.service;

import ecut.jdbc.dao.CustomerDao;

public class CustomerService {
	
	private CustomerDao customerDao ;

	public CustomerDao getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

}
