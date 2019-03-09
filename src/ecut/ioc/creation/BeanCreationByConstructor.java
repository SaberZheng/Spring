package ecut.ioc.creation;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanCreationByConstructor {

	public static void main(String[] args) {
		
		String configLocations = "classpath:ecut/**/constructor-creation.xml" ;
		
		AbstractApplicationContext container = new ClassPathXmlApplicationContext( configLocations );
		
		//需要有无参构造，不然会抛出BeanCreationException，因为没有指定默认的构造函数
		Fox fox1 = container.getBean( "fox1" ,  Fox.class );
		System.out.println( fox1 );
		
		Fox fox2 = container.getBean( "fox2" ,  Fox.class );
		System.out.println( fox2 );
		
		Fox fox3 = container.getBean( "fox3" ,  Fox.class );
		System.out.println( fox3 );
		
		container.close();
		
	}

}
