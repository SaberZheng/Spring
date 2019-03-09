package ecut.aop.xml;

public class Monkey {
	
	private String name ;
	
	public void eat( String food ) {
		System.out.println( this.name +  " 吃 " + food );
	}
	
	public void run(){
		System.out.println( this.name +  " 在跑步 " );
	}
	
	public void sleep(){
		System.out.println( this.name +  " 在睡觉 " );
	}
	
	public void fly(){
		System.out.println( this.name +  " 很牛逼，可以腾云驾雾 " );
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
