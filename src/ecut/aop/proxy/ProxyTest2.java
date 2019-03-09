package ecut.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest2 {

	public static void main(String[] args) {
		
		// 代理目标 ( 谁将被别人代理 )
		final Object target = new FoxconnFactory();
		
		// 代理目标 的类型 : 获得 被代理的 对象的 运行时 类型
		Class<?> targetClass = target.getClass(); 
		
		/** 用 代理目标 类型对应的类加载器 去加载 运行阶段动态产生的 代理类 */
		ClassLoader loader = targetClass.getClassLoader() ; // 获得 代理目标 对应的 类的 "类加载器"
		
		/** 指示 将来产生 动态代理类 所需要实现的接口 */
		Class<?>[] interfaces = targetClass.getInterfaces() ; // 获得 代理目标 对应的类所实现的接口
		
		/** 请求指派器  */
		InvocationHandler handler = new InvocationHandler(){
			@Override
			public Object invoke( Object proxy , Method method , Object[] args ) throws Throwable {
				System.out.println( "方法[ " + method.getName() +  " ]将要执行了" ); // Advice
				Object result = method.invoke( target , args ) ; // target.create();
				System.out.println( "方法[ " + method.getName() +  " ]执行结束并返回了: " + result );  // Advice
				return result;
			}
		} ;
		
		// 代理对象 ( 谁将去代理别人 )，这四个方法执行其前后就被我们拦截下来了 ，方法前后增加了输出语句，没有动方法，只是在动态代理类handler里面增加了代码
		//我们所增加的代码如果按照规范来封装好就是Advice
		Object proxy = Proxy.newProxyInstance( loader , interfaces , handler ) ;
		
		if( proxy instanceof AppleCompany ) {
			AppleCompany ac = (AppleCompany) proxy ;
			System.out.println( ac == proxy );
			
			IPhone p = ac.create();
			System.out.println( p );
			
			System.out.println( ac.toString() );
			
			System.out.println( ac.hashCode() );
			
			System.out.println( ac.equals(target) );//target.equals(target);
		}
		
	}

}
