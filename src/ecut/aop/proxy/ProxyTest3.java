package ecut.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest3 {

	public static void main(String[] args) {
		
		// 代理目标 ( 谁将被别人代理 )
		final Object target = new FoxconnFactory();
		
		Class<?> targetClass = target.getClass(); 
		
		ClassLoader loader = targetClass.getClassLoader() ;
		
		Class<?>[] interfaces = targetClass.getInterfaces() ; 
		
		InvocationHandler handler = new InvocationHandler(){
			@Override
			public Object invoke( Object proxy , Method method , Object[] args ) throws Throwable {
				
				System.out.println( "方法[ " + method.getName() +  " ]将要执行了" ); // before
				
				Object result = null ;
				try{
					long start = System.nanoTime(); // around
					result = method.invoke( target , args ) ; // 执行点
					long end = System.nanoTime(); // around
					System.out.println( "执行用时: " + ( end - start ) + " 毫微妙" ); // around
					System.out.println( "执行后并返回: " + result); // after-returing
				} catch ( Throwable t ){
					System.out.println( "发生错误: " + t.getMessage()  ); // after-throwing
				}
				
				System.out.println( "方法[ " + method.getName() +  " ]执行结束" );  // after
				
				return result;
			}
		} ;
		
		Object proxy = Proxy.newProxyInstance( loader , interfaces , handler ) ;
		
		if( proxy instanceof AppleCompany ) {
			AppleCompany ac = (AppleCompany) proxy ;
			System.out.println( ac == proxy );
			//通过create调用了target中create的方法
			IPhone p = ac.create();
			System.out.println( p );
			//代理对象 $Proxy0中的四个方法是可执行的，方法在执行时候就可以视为是一个执行点
			String s = ac.toString() ;
			System.out.println( s );
		}
		
	}

}
