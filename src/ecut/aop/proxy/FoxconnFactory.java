package ecut.aop.proxy;

public class FoxconnFactory implements AppleCompany {
	//需要实现苹果公司接口
	@Override
	public IPhone create() {
		System.out.println( "富士康" );
		IPhone phone = new IPhone();
		return phone ;
	}

	@Override
	public String toString() {
		return "FoxconnFactory";
	}
	
}
