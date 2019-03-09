package ecut.aop.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

public class PandaAdvices {
	
	/**
	 * 不要静态的，所有Advices都是实例化之后去植入这个方法
	 * 通过 JoinPoint 类型的对象 可以访问连接点 信息
	 * 如果不需要访问连接点信息，那么 可以不写 这个参数
	 * @param point
	 */
	public void before( JoinPoint point  ) {
		//方法签名方法签名int ecut.aop.xml.Panda.div(int,int)
		Signature signature = point.getSignature(); // 获得当前的连接点对应的方法的签名
				
		String name =  signature.getName() ; // 获得方法的名称
		
		System.out.println( "PandaAdvices 提示你 : 方法[ " + name + " ]将要执行了" );
		
	}
	
	// ProceedingJoinPoint 是 JoinPoint 接口的子接口 ,可以通过 ProceedingJoinPoint访问连接点 信息，也可以通过ProceedingJoinPoint使方法执行
	public Object around( ProceedingJoinPoint point ) throws Throwable {
		System.out.println( "around : before" );
		Object result = point.proceed();
		System.out.println( "around : after" );
		return result ;//得将值返回，不然没法往后传值了
	}

	public void afterReturn( JoinPoint point , Object result ) {
		
		Signature signature = point.getSignature(); // 获得当前的连接点对应的方法的签名
		
		String name =  signature.getName() ; // 获得方法的名称
		
		System.out.println( "方法[ " + name + " ]执行后返回: " + result );
		
	}
	
	public void afterThrow( JoinPoint point , Throwable ex ) {
		
		Signature signature = point.getSignature(); // 获得当前的连接点对应的方法的签名
		
		String name =  signature.getName() ; // 获得方法的名称
		
		System.out.println( "方法[ " + name + " ]执行时发生异常: " + ex );
		
	}
	
	public void after( JoinPoint point  ) {
		
		Signature signature = point.getSignature(); // 获得当前的连接点对应的方法的签名
		
		String name =  signature.getName() ; // 获得方法的名称
		
		System.out.println( "方法[ " + name + " ]执行结束" );
		
	}

}
