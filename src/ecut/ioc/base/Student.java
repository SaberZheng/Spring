package ecut.ioc.base;

import java.util.Date;

public class Student {

	private Integer id;
	private String name;
	private char gender;
	private Date birthdate;
	
	public Student() {
		super();
		System.out.println( "调用 Student 无参构造创建对象" );
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
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
		System.out.println( "为birthdate属性赋值: " + birthdate );
	}

}
