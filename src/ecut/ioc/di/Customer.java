package ecut.ioc.di;

import java.util.Date;

public class Customer {

	private Integer id;
	private String name;
	private char gender;
	private Date birthdate;
	
	public Customer() {
		super();
		System.out.println( "调用 Customer 无参构造创建对象" );
	}
	
	public Customer(Integer id, String name, char gender) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		System.out.println( "调用 Customer( Integer , String , char ) 创建对象" );
	}

	public Customer(Integer id, String name, char gender, Date birthdate) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.birthdate = birthdate;
		System.out.println( "调用 Customer( Integer , String , char , Date ) 创建对象" );
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
		System.out.println( "为id属性赋值: " + id );
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println( "为name属性赋值: " + name );
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
		System.out.println( "为gender属性赋值: " + gender );
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
		System.out.println( "为birthdate属性赋值: " + birthdate );
	}

}
