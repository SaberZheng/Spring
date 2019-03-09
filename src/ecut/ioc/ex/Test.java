package ecut.ioc.ex;

import java.util.Date;
import java.util.Map;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		//classpath和classpath下的所有jar包
		System.out.println( System.getProperty( "java.class.path" ) );
		//configLocations为不定参数，classpath当前工程下的bin目录下D:\java_workspace\java\Spring\bin，/**/匹配多级目录
		String configLocations = "classpath:ecut/**/ex/beans.xml" ;
		//String configLocations = "classpath:ecut/ioc/ex/beans.xml" ;
		//String configLocations = "classpath:beans.xml" ;//若配置文件在src目录底下
		
		// AbstractApplicationContext 实现了 org.springframework.context.ApplicationContext 接口
		//	ClassPathXmlApplicationContext 继承了 org.springframework.context.support.AbstractApplicationContext
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(configLocations);
		//name 与xml中的bean标签的ID相对应
		Date date = context.getBean( "birthdate", Date.class );
		
		System.out.println( date );
		
		Map<?,?> map = context.getBean( "map" , Map.class );
		
		System.out.println( map );
		//ApplicationContext没有close方法，AbstractApplicationContext
		context.close();
		
	}

}
