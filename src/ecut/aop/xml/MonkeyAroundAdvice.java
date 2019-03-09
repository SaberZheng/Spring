package ecut.aop.xml;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


// org.aopalliance.intercept.Interceptor 继承了 org.aopalliance.aop.Advice
// org.aopalliance.intercept.MethodInterceptor  继承 org.aopalliance.intercept.Interceptor
public class MonkeyAroundAdvice implements MethodInterceptor{

	@Override
	public Object invoke( MethodInvocation invocation ) throws Throwable {
		
		System.out.println( "around advice : before" );
		Object result = invocation.proceed(); // 让被 "拦截" 的方法执行 
		System.out.println( "around advice : after" );
		
		/*
		Method m = invocation.getMethod(); //获取被连接的 方法 对应的 Method 对象
		
		Object[] args = invocation.getArguments(); // 获得 即将被执行的 方法的参数列表
		
		Object target = invocation.getThis(); // 获取 代理目标 ( 被别的对象所代理的那个对象 )
		// System.out.println( target );
		
		System.out.println( "around advice : before" );
		Object result = m.invoke( target ,  args ); // 调用 target 对象的 m 对应的方法，并传入参数 args
		System.out.println( "around advice : after" );
		*/
		
		return result ;
	}

}
