package ecut.ioc.collection;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class User {

	private Integer id;
	private String name;

	private Set<String> hobby;
	
	private List<Date> luckDay ;
	
	private Map<String,Integer> score ;
	
	private Properties address ;

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

	public Set<String> getHobby() {
		return hobby;
	}

	public void setHobby(Set<String> hobby) {
		this.hobby = hobby;
	}

	public List<Date> getLuckDay() {
		return luckDay;
	}

	public void setLuckDay(List<Date> luckDay) {
		this.luckDay = luckDay;
	}

	public Map<String, Integer> getScore() {
		return score;
	}

	public void setScore(Map<String, Integer> score) {
		this.score = score;
	}

	public Properties getAddress() {
		return address;
	}

	public void setAddress(Properties address) {
		this.address = address;
	}

}
