package ecut.ioc.autowiring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowireByConstructor {

	public static void main(String[] args) {
		
		String configLocations = "classpath:ecut/**/constructor-autowiring.xml" ;
		
		AbstractApplicationContext container = new ClassPathXmlApplicationContext( configLocations );
		
		Person s = container.getBean( "huaan" , Person.class );
		
		System.out.println( s.getId() + " : " + s.getName() );
		
		Dog d = s.getWangcai();
		
		System.out.println( d.getName()  );
		
		container.close();
		
	}

}
