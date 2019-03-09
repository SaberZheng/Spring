package ecut.ioc.creation;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanCreationByStaticFactory {

	public static void main(String[] args) {
		
		String configLocations = "classpath:ecut/**/static-factory-method.xml" ;
		
		AbstractApplicationContext container = new ClassPathXmlApplicationContext( configLocations );
		
		System.out.println( "~~~~~~~~~~~~~~~~~" );
		//构造方法只执行一次,默认情况下，容器创建就已经创建了这个bean
		Sun s = container.getBean( "sun" ,  Sun.class );
		System.out.println( s );
		
		Sun x = container.getBean( "sun" ,  Sun.class );
		System.out.println( x );
		
		container.close();
		
	}

}
