package ecut.ioc.creation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanCreationByFactoryBean {

	public static void main(String[] args) {
		
		String configLocations = "classpath:ecut/**/factory-bean-creation.xml" ;
		
		AbstractApplicationContext container = new ClassPathXmlApplicationContext( configLocations );
		
		Date d = container.getBean( "birthdate" ,  Date.class );
		System.out.println( d );
		
		DateFormat df = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
		
		System.out.println( df.format( d ) );
		
		container.close();
		
	}

}
