package ecut.aop.xml;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAdvisorOrder {

	public static void main(String[] args) {
		
		String configLocations = "classpath:ecut/**/xml/advisor-order.xml" ;
		
		AbstractApplicationContext container = new ClassPathXmlApplicationContext( configLocations );
		
		Monkey m = container.getBean( "wk" , Monkey.class );
		
		System.out.println( m.getClass() );
		
		m.eat( "苹果" );
		
		container.close();

	}

}
