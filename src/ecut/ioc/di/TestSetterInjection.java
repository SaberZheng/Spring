package ecut.ioc.di;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSetterInjection {

	public static void main(String[] args) {
		//指定configuration metadata配置元数据
		String configLocations = "classpath:ecut/**/di/setter-injection.xml" ;
		//创建spring IOC容器
		AbstractApplicationContext container = new ClassPathXmlApplicationContext( configLocations );
		//ready for use (此时可以从指定的IOC容器中获取指定名称的bean实例了)
		Customer c = container.getBean( "customer" , Customer.class );
		//从容器中获取的bean实例中获取属性值
		System.out.println( c.getId() );
		
		System.out.println( c.getName() );
		
		System.out.println( c.getGender() );
		
		System.out.println( c.getBirthdate() );
		//关闭spring的IOC容器
		container.close();
		
	}

}
