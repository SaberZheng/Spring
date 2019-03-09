package ecut.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest4 {

	public static void main(String[] args) {
		
		// 代理目标 ( 谁将被别人代理 )
		final Object target = new FoxconnFactory();
		
		Class<?> targetClass = target.getClass(); 
		
		ClassLoader loader = targetClass.getClassLoader() ;
		
		Class<?>[] interfaces = targetClass.getInterfaces() ; 
		
		InvocationHandler handler = new InvocationHandler(){
			@Override
			//只保留了before和after的方位信息，20个连接点里挑选了8个，增加了了判断语句后只对create方法增加Advice，这些筛选条件就是切点
			public Object invoke( Object proxy , Method method , Object[] args ) throws Throwable {
				
				if( "create".equals( method.getName() ) ) {
					System.out.println( "方法[ " + method.getName() +  " ]将要执行了" ); // before
				}
				
				Object result = method.invoke( target , args ) ; // 执行点
				
				if( "create".equals( method.getName() ) ){
					System.out.println( "方法[ " + method.getName() +  " ]执行结束" );  // after
				}
				
				return result;
			}
		} ;
		
		Object proxy = Proxy.newProxyInstance( loader , interfaces , handler ) ;
		
		if( proxy instanceof AppleCompany ) {
			AppleCompany ac = (AppleCompany) proxy ;
			System.out.println( ac == proxy );
			
			IPhone p = ac.create();
			System.out.println( p );
			
			String s = ac.toString() ;
			System.out.println( s );
			
			System.out.println( ac.hashCode() );
		}
		
	}

}
