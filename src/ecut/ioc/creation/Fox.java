package ecut.ioc.creation;

public class Fox {
	
	private String id ;
	
	private String name ;
	
	public Fox() {
		super();
		System.out.println( "Fox 无参构造" );
	}
	
	public Fox(String id , String name) {
		super();
		this.id = id;
		this.name = name;
		System.out.println( "Fox( String , String ) 构造" );
	}
	
	@Override
	public String toString() {
		return "Fox [id=" + id + ", name=" + name + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
