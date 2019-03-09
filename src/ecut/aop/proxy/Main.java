package ecut.aop.proxy;

public class Main {

	public static void main(String[] args) {
		//被代理的目标target， 京东买的手机由富士康生产
		FoxconnFactory factory = new FoxconnFactory();
		//京东是富士康的代理商，代理对象proxy，代理商和代理对象都实现了苹果公司的这个接口（前提），富士康按照苹果公司要求生产，京东按照苹果公司的要求买手机
		JingDong jd = new JingDong();
		
		jd.setFactory(factory);
		//相当于消费者买手机
		IPhone p = jd.create();
		
		System.out.println( p );
		
		p.call();

	}

}
