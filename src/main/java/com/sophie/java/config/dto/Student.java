package com.sophie.java.config.dto;

public class Student
{
	String name;
	int age;
	boolean female;
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	public boolean isFemale()
	{
		return female;
	}
	public void setFemale(boolean female)
	{
		this.female = female;
	}
	@Override
	public String toString()
	{
		return "Student [name=" + name + ", age=" + age + ", female=" + female + "]";
	} 
	
}
