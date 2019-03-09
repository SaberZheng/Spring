package ecut.ioc.creation;

public class Car {
	
	private String brand ; // 品牌
	
	public Car(){
		super();
		System.out.println( "Car无惨构造执行" );
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
}
