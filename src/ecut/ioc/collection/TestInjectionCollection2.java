package ecut.ioc.collection;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestInjectionCollection2 {

	public static void main(String[] args) {
		
		String configLocations = "classpath:ecut/**/util-injection.xml" ;
		
		AbstractApplicationContext container = new ClassPathXmlApplicationContext( configLocations );
		
		User c = container.getBean( "user" , User.class );
		
		System.out.println( c.getId() + " : " + c.getName() );
		
		Set<String> hobby = c.getHobby();
		System.out.println( hobby );
		
		List<Date> luckDay = c.getLuckDay();
		System.out.println( luckDay );
		
		Map<String, Integer> score = c.getScore() ;
		System.out.println( score );
		
		Properties address = c.getAddress();
		System.out.println( address );
		
		container.close();
		
	}

}
