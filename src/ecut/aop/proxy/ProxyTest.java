package ecut.aop.proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyTest {

	public static void main(String[] args) {
		
		// 代理目标 ( 谁将被别人代理 )
		final Object target = new FoxconnFactory();
		
		// 代理目标 的类型 : 获得 被代理的 对象的 运行时 类型，jdk代理的缺陷（前提）代理的目标类得实现接口，Spring提供了子类代理父类(Cglib)
		Class<?> targetClass = target.getClass(); 
		
		/** 用 代理目标 类型对应的类加载器 去加载 运行阶段动态产生的 代理类 */
		ClassLoader loader = targetClass.getClassLoader() ; // 获得 代理目标 对应的 类的 "类加载器"
		
		/** 指示 将来产生 动态代理类 所需要实现的接口 */
		Class<?>[] interfaces = targetClass.getInterfaces() ; // 获得 代理目标 对应的类所直接实现的接口
		System.out.println( Arrays.toString( interfaces ) );
		
		/** 请求指派器 （快递公司），调用的proxy方法的时候调用target方法，给你感觉是proxy调用的实际上target实现的，是使proxy 和 target产生联系，InvocationHandler将请求派给target
		 * method被调用的方法是谁， args 方法中的参数"借尸还魂"匿名内部类 */
		InvocationHandler handler = new InvocationHandler(){
			@Override
			//proxy对象
			public Object invoke( Object proxy , Method method , Object[] args ) throws Throwable {
				//target.method(args);//被调用的是method方法；传入的参数是args；调用的是target所引用的对象的method方法
				Object result = method.invoke( target , args ) ; // target.create();指派给target，由target调用方法
				 
				return result;
			}
		} ;
		// 代理对象 ( 谁将去代理别人 )Proxy动态代理类的父类Proxy.newProxyInstance创建一个代理对象
		Object proxy = Proxy.newProxyInstance( loader , interfaces , handler ) ;
		
		System.out.println( proxy ); // proxy.toString()会被指派，通过InvocationHandler.invoke方法指派给target.toString()，因此返回的是target的tostring方法
		
		// proxy.getClass()不会被指派。代理类 : ( 在 运行阶段 动态产生 ( 没有 .java 文件、没有 .class 文件 ，直接产生字节码放在内存中去) )
		Class<?> proxyClass = proxy.getClass();
		
		System.out.println( proxyClass );
		
		// 所有的 由  java.lang.refrect.Proxy 产生的 动态代理类 的直接父类都是 Proxy
		System.out.println( proxyClass.getSuperclass() );
		
		// 获得 动态代理类 所实现过的 接口 ( 在 创建 代理对象时指定的数组中有哪些接口，这里就有哪些接口 )
		System.out.println( Arrays.toString( proxyClass.getInterfaces() ) );
		
		System.out.println( "~~~构造方法~~~~~~~~~~~~" );
		
		Constructor<?>[] cons = proxyClass.getDeclaredConstructors();
		for( Constructor<?> c : cons ){
			System.out.println( c );
		}
		
		System.out.println( "~~~ 属性 ( Field ) ~~~~~~~~~~~~" );
		//属性都由private static修饰 ,代理对象 $Proxy0继承了父类的Proxy类中的protected  InvocationHandler h属性,其他m0，m1....都与方法相对应
		Field[] fields = proxyClass.getDeclaredFields();
		for( Field c : fields ){
			System.out.println( c );
		}
		
		System.out.println( "~~~ 方法 ( Method ) ~~~~~~~~~~~~" );
		//重写了toString，hashCode，equals方法，都由public final修饰
		Method[] methods = proxyClass.getDeclaredMethods();
		for( Method c : methods ){
			System.out.println( c );
		}
		
		
	}

}
