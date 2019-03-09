package ecut.aop.annotation;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStudentController {

	public static void main(String[] args) {
		
		Student s = new Student();
		s.setId( 100 );
		s.setName( "张三" );
		
		String configLocations = "classpath:ecut/**/annotation/ioc-aop.xml" ;
		
		AbstractApplicationContext container = new ClassPathXmlApplicationContext( configLocations );
		
		StudentController sc = container.getBean( "studentController" , StudentController.class );
		
		System.out.println( sc );
		
		sc.regist( s );
		
		System.out.println( "~~~~~~~~~~~~~~~~~~~~~~" );
		
		sc.logout();
		
		container.close();

	}

}
