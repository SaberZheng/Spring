package ecut.aop.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

public class AnimalAdvices {
	
	public void before1( JoinPoint point  ) {
		
		Signature signature = point.getSignature(); // 获得当前的连接点对应的方法的签名
		
		String name =  signature.getName() ; // 获得方法的名称
		
		System.out.println( "AnimalAdvices  的 before1 提示你 : 方法[ " + name + " ]将要执行了" );
		
	}
	
	public void before2( JoinPoint point  ) {
		
		Signature signature = point.getSignature(); // 获得当前的连接点对应的方法的签名
		
		String name =  signature.getName() ; // 获得方法的名称
		
		System.out.println( "AnimalAdvices  的 before2 提示你 : 方法[ " + name + " ]将要执行了" );
		
	}

}
