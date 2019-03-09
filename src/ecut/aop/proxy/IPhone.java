package ecut.aop.proxy;

public class IPhone {
	
	public IPhone(){
		super();
		System.out.println( "爱疯" );
	}

	public void charge() {
		System.out.println( "charge" );
	}

	public void call() {
		System.out.println( "call" );
	}

	public void message() {
		System.out.println( "message" );
	}

}
