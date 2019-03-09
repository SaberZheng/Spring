package ecut.ioc.autowiring;

public class Person {

	private Integer id;
	private String name;
	
	private Dog wangcai ;
	
	public Person() {
		super();
	}
	
	public Person(Dog wangcai) {
		super();
		this.wangcai = wangcai;
		System.out.println( "public Person(Dog)" );
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Dog getWangcai() {
		return wangcai;
	}

	public void setWangcai(Dog wangcai) {
		this.wangcai = wangcai;
	}

}
