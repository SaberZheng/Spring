package ecut.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class StudentAspect {
	
	//@Pointcut( "execution(* ecut..StudentController.*(..))" )
	@Pointcut( "execution(* ecut.aop.annotation.StudentController.*(..))" )
	private void myPointcut(){
		// 用声明方法的形式 来声明 一个切点，切点名称就是 方法名 ， 切点表达式在 注解中指定
	}
	
	//在 Pointcut 内部 通过  方法调用的 形式 来引用已经声明的切点
	@Before( "myPointcut()" )
	public void before( JoinPoint point  ) {
		Signature signature = point.getSignature(); // 获得当前的连接点对应的方法的签名
		String name =  signature.getName() ; // 获得方法的名称
		System.out.println( "StudentAspect 的 before 提示你 : 方法[ " + name + " ]将要执行了" );
	}
	
	@Around( "myPointcut()" )
	public Object around( ProceedingJoinPoint point ) throws Throwable {
		System.out.println( "StudentAspect 的 around 提示你  : before" );
		Object result = point.proceed();
		System.out.println( "StudentAspect 的 around 提示你  : after" );
		return result ;
	}
	
	//@AfterReturning( value = "myPointcut()" , returning = "result" )
	@AfterReturning( pointcut = "myPointcut()" , returning = "result" )
	public void afterReturn( JoinPoint point , Object result ) {
		Signature signature = point.getSignature(); // 获得当前的连接点对应的方法的签名
		String name =  signature.getName() ; // 获得方法的名称
		System.out.println( "StudentAspect 的 afterReturn 提示你  : 方法[ " + name + " ]执行后返回: " + result );
	}
	
	@AfterThrowing( pointcut = "myPointcut()" , throwing = "ex" )
	public void afterThrow( JoinPoint point , Throwable ex ) {
		Signature signature = point.getSignature(); // 获得当前的连接点对应的方法的签名
		String name =  signature.getName() ; // 获得方法的名称
		System.out.println( "StudentAspect 的 afterThrow 提示你  : 方法[ " + name + " ]执行时发生异常: " + ex );
	}
	
	@After( "myPointcut()" )
	public void after( JoinPoint point  ) {
		Signature signature = point.getSignature(); // 获得当前的连接点对应的方法的签名
		String name =  signature.getName() ; // 获得方法的名称
		System.out.println( "StudentAspect 的 after 提示你 : 方法[ " + name + " ]执行结束" );
	}

}
