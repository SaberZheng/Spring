package ecut.aop.xml;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAspectOrder {

	public static void main(String[] args) {
		
		String configLocations = "classpath:ecut/**/xml/aspect-order.xml" ;
		
		AbstractApplicationContext container = new ClassPathXmlApplicationContext( configLocations );
		
		Panda m = container.getBean( "panda" , Panda.class );
		
		m.eat( "面条" );
		
		container.close();

	}

}
