package ecut.aop.xml;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

// org.springframework.aop.BeforeAdvice 接口 继承了 org.aopalliance.aop.Advice
// org.springframework.aop.MethodBeforeAdvice 接口 继承了 BeforeAdvice
public class MonkeyBeforeAdvice implements MethodBeforeAdvice {

	@Override
	public void before( Method method , Object[] args , Object target) throws Throwable {
		System.out.println( "MonkeyBeforeAdvice 提示 : 方法[ " + method.getName() + " ]将要执行了" );
	}

}
