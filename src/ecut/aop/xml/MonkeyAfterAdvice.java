package ecut.aop.xml;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class MonkeyAfterAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning( Object returnValue , Method method , Object[] args , Object target ) 
			throws Throwable {
		System.out.println( "方法[ " + method.getName() + " ]执行后返回了: " + returnValue );
	}


}
