package ecut.ioc.creation;

public class CarFactory {
	
	private String brandName ;
	
	public CarFactory() {
		super();
	}

	public CarFactory(String brandName) {
		super();
		this.brandName = brandName;
		System.out.println( "CarFactory( String ) 构造执行" );
	}

	public Car create(){
		System.out.println( "准备创建 Car 的实例" );
		Car c = new Car();
		c.setBrand( brandName );
		return c ;
	}

}
