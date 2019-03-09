package ecut.hibernate;


import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ecut.hibernate.controller.CustomerController;
import ecut.hibernate.entity.Customer;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCustomerController {
	
	private static AbstractApplicationContext container ;
	
	public @BeforeClass static void init(){
		String configLocations = "classpath:ecut/**/hibernate/beans.xml";
		container = new ClassPathXmlApplicationContext( configLocations );
	}
	
	public @Test void testRegist(){
		
		Customer c = new Customer();
		
		c.setEmail( "lao@ecut.edu.cn" );
		c.setPassword( "hello2017" );
		
		Date birthdate = new Date() ;
		c.setBirthdate( birthdate );
		c.setGender( '男' );
		
		c.setNickname( "老王" );
		c.setMarried( false );
		
		CustomerController cc = container.getBean( "customerController" , CustomerController.class );
		
		cc.regist( c );
		
	}
	
	public @Test void all(){
		
		CustomerController cc = container.getBean( "customerController" , CustomerController.class );
		
		List<Customer> list = cc.allCustomer();
		
		for( Customer c : list ){
			System.out.println( c.getEmail() + " : " + c.getNickname() );
		}
		
	}
	
	public @AfterClass static void destory(){
		container.close();
	}

}
