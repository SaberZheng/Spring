package ecut.ioc.base;


import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringContainer {

	public static void main(String[] args) {
		//指定configuration metadata配置元数据
		String configLocations = "classpath:ecut/**/base/ioc.xml" ;
		//创建spring IOC容器，在容器创建的时候调用无参构造
		AbstractApplicationContext container = new ClassPathXmlApplicationContext( configLocations );
		//ready for use (此时可以从指定的IOC容器中获取指定名称的bean实例了)
		Student s = container.getBean( "s" , Student.class );
		//从容器中获取的bean实例中获取属性值
		System.out.println( s.getId() );
		
		System.out.println( s.getName() );
		
		System.out.println( s.getGender() );
		
		System.out.println( s.getBirthdate() );
		//关闭spring的IOC容器
		container.close();
		
	}

}
