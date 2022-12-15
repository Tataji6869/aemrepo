package com.aem.aemfeb;

public class Employees {
	private String name;
	private String email;
	private String age;// this is testing   and changesss upadted sucessfully
	
	private String weight;
	public String getName() {
		return name;
	}
	public void setName(String name) {// this changes are in eclips
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "Employees [name=" + name + ", email=" + email + ", age=" + age + ", weight=" + weight + "]";
	} 
	
	
	

}
