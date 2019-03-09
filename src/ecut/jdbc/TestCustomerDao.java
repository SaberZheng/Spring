package ecut.jdbc;

import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ecut.jdbc.dao.CustomerDao;
import ecut.jdbc.entity.Customer;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCustomerDao {

	private static AbstractApplicationContext container;

	public @BeforeClass static void init() {
		String configLocations = "classpath:ecut/**/jdbc/beans.xml";
		container = new ClassPathXmlApplicationContext(configLocations);
	}

	public @Test void testSaveCustomer() {

		Customer c = new Customer();

		c.setEmail("Amy@ecut.edu.cn");
		c.setPassword("hello2017");

		Date birthdate = new Date();
		c.setBirthdate(birthdate);
		c.setGender('女');

		c.setNickname("Saber");
		c.setMarried(false);

		CustomerDao customerDao = container.getBean("customerDao", CustomerDao.class);

		customerDao.persist(c);

	}

	public @Test void testLoadCustomer() {

		CustomerDao customerDao = container.getBean("customerDao", CustomerDao.class);

		Customer c = customerDao.load(1);

		System.out.println(c.getEmail());

	}

	public @Test void testLoadAllCustomer() {

		CustomerDao customerDao = container.getBean("customerDao", CustomerDao.class);

		List<Customer> list = customerDao.loadAll();

		for (Customer c : list) {
			System.out.println(c.getEmail() + " : " + c.getNickname());
		}

	}

	public @Test void testUpdateCustomer() {

		Customer c = new Customer();

		c.setEmail("Saber@ecut.edu.cn");
		c.setPassword("hello2017");

		Date birthdate = new Date();
		c.setBirthdate(birthdate);
		c.setGender('女');

		c.setNickname("Amy");
		c.setMarried(false);

		CustomerDao customerDao = container.getBean("customerDao", CustomerDao.class);

		customerDao.update(c, 2);

	}
	
	public @Test void  testDeleteCustomer() {

		CustomerDao customerDao = container.getBean("customerDao", CustomerDao.class);

		boolean flag = customerDao.delete(1);
		
		System.out.println(flag);
	}

	public @AfterClass static void destory() {
		container.close();
	}

}
