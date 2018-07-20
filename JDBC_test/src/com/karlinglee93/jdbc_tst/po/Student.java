package com.karlinglee93.jdbc_tst.po;

public class Student {
    private int Id;
    private String Name;
    private String Sex;
    private int Age;
    
	public Student(String name, String sex, int age) {
		super();
		Name = name;
		Sex = sex;
		Age = age;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSex() {
		return Sex;
	}

	public void setSex(String sex) {
		Sex = sex;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}
}