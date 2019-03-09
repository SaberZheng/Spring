package ecut.hibernate.service;

import java.util.List;

import ecut.hibernate.dao.CustomerDao;
import ecut.hibernate.entity.Customer;

public class CustomerService {
	
	private CustomerDao customerDao ;
	
	public boolean save( Customer c ) {
		System.out.println( "CustomerService # save ." );
		return customerDao.persist( c );
	}
	
	public List<Customer> findAll(){
		return customerDao.loadAll() ;
	}

	public CustomerDao getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

}
