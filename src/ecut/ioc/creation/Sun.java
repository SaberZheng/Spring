package ecut.ioc.creation;

public class Sun {
	/*//"饿汉"式实现单例 
	private static final Sun SUN =new Sun();
	
	private Sun(){
		super();
		System.out.println( "构造方法执行" );
	}
	//调用getInstance()方法获取sun类型实例，调用类的静态方法是主动使用会导致 类被初始化
	public static Sun getInstance(){
		System.out.println( "使用静态方法返回 Sun 类型的实例" );
		//这个Sun 类型的实例是单例的
		return SUN ;
	}*/

	//懒汉式，线程安全实现单例 
	private static Sun SUN ;
	
	private Sun(){
		super();
		System.out.println( "构造方法执行" );
	}
	//调用getInstance()方法获取sun类型实例，调用类的静态方法是主动使用会导致 类被初始化
	public static Sun getInstance(){
		System.out.println( "使用静态方法返回 Sun 类型的实例" ); 
		//同步锁是类对应对象
		synchronized ( Sun.class ) {
			SUN = new Sun();
		}
		//这个Sun 类型的实例是单例的
		return SUN ;
	}

}
