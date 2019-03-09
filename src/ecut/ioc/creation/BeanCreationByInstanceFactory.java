package ecut.ioc.creation;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanCreationByInstanceFactory {

	public static void main(String[] args) {
		
		String configLocations = "classpath:ecut/**/instance-factory-method.xml" ;
		
		AbstractApplicationContext container = new ClassPathXmlApplicationContext( configLocations );
		
		System.out.println( "~~~~~~~~~~~~~~~~~" );
		
		Car c = container.getBean( "car" ,  Car.class );
		System.out.println( c.getBrand() );
		
		container.close();
		
	}

}
