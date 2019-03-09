package ecut.aop.xml;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAdvisor {

	public static void main(String[] args) {
		
		String configLocations = "classpath:ecut/**/xml/advisor.xml" ;
		
		AbstractApplicationContext container = new ClassPathXmlApplicationContext( configLocations );
		
		Monkey m = container.getBean( "wk" , Monkey.class );
		//获取的是代理类的类型，不再是Monkey
		System.out.println( m.getClass() );
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
		m.eat( "苹果" );
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
		m.run();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
		String name = m.getName() ;
		//和filter，interceptor 不一样，需继续传递才会往下执行，而after,before拦截下来之后会继续往下执行，无需继续传递
		System.out.println( "name: " + name );
		
		container.close();

	}

}
