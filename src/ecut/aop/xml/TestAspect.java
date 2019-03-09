package ecut.aop.xml;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAspect {

	public static void main(String[] args) {
		
		String configLocations = "classpath:ecut/**/xml/aspect.xml" ;
		
		AbstractApplicationContext container = new ClassPathXmlApplicationContext( configLocations );
		
		Panda m = container.getBean( "panda" , Panda.class );
		System.out.println(m.getClass());
		//表面上调用的panda的eat，方法实际上m只是一个代理对象
		m.eat( "面条" );
		
		System.out.println( "~~~~~~~~~~~~~~~~~" );
		
		String name = m.getName() ;
		
		System.out.println( "name : " + name  );
		
		System.out.println( "~~~~~~~~~~~~~~~~~" );
		
		int r = m.div( 100 ,  0 );
		
		System.out.println( r );
		
		container.close();

	}

}
