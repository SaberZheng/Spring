package ecut.aop.xml;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class MonkeyAnotherAdvice implements MethodBeforeAdvice {
	
	@Override
	public void before( Method method , Object[] args , Object target) throws Throwable {
		System.out.println( "MonkeyAnotherAdvice 提示 : 方法[ " + method.getName() + " ]将要执行了" );
	}

}
