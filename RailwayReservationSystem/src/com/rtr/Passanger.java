package com.rtr;

public class Passanger {
	static int i = 0;
	int Id = i++;
	String name ;
	String gender;
	int age;
	String berthpref;
	
	public Passanger()
	{	
		
	}
	public Passanger(int id)
	{	
		this.Id=id;
	}
	public Passanger(String name, String gender, int age, String berthpref) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.berthpref = berthpref;
	}
	
	
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getBerthpref() {
		return berthpref;
	}
	public void setBerthpref(String berthpref) {
		this.berthpref = berthpref;
	}
	@Override
	public String toString() {
		return "Passanger [Id=" + Id + " name=" + name + ", gender=" + gender + ", age=" + age + ", berthpref=" + berthpref + "]";
	}
}



