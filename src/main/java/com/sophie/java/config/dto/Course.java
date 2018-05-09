package com.sophie.java.config.dto;

import java.util.List;

public class Course
{
	String courseName;
	String courseId;
	List<Student> registeredStudent;

	public String getCourseName()
	{
		return courseName;
	}

	public void setCourseName(String courseName)
	{
		this.courseName = courseName;
	}

	public String getCourseId()
	{
		return courseId;
	}

	public void setCourseId(String courseId)
	{
		this.courseId = courseId;
	}

	public List<Student> getRegisteredStudent()
	{
		return registeredStudent;
	}

	public void setRegisteredStudent(List<Student> registeredStudent)
	{
		this.registeredStudent = registeredStudent;
	}

	@Override
	public String toString()
	{
		return "Course [courseName=" + courseName + ", courseId=" + courseId + ", registeredStudent="
				+ registeredStudent + "]";
	}

}
