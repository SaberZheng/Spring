package ecut.aop.proxy;

public class JingDong implements AppleCompany {
	
	private FoxconnFactory factory ;
	
	@Override
	public IPhone create() {
		System.out.println( "京东" );
		return factory.create() ;
	}
	//通过getter , setter 方法注入FoxconnFactory
	public FoxconnFactory getFactory() {
		return factory;
	}

	public void setFactory(FoxconnFactory factory) {
		this.factory = factory;
	}

}
