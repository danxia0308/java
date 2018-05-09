package com.sophie.java.config;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sophie.java.config.dto.Course;
import com.sophie.java.config.dto.Student;

public class ConfigWithJson
{
	private static final String PREFIX = "src/main/resources/config/";
	private static final Logger log = LoggerFactory.getLogger(ConfigWithJson.class);
	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
		ConfigWithJson config = new ConfigWithJson();
		config.generateJson();
	}
	
	/**
	 * 使用ObjectMapper读取json文件进行解析
	 * @throws Exception
	 */
	private void parseJsonFile_Simple() throws Exception
	{
		//方法1:直接使用readValue，获得Student对象。
		File file1 = new File(PREFIX+"student1.json");
		ObjectMapper mapper = new ObjectMapper();
		Student student1 = mapper.readValue(file1, Student.class);
		log.info("Student1={}",student1.toString());
		
		//方法2:使用readTree获得JsonNode，再分别读取相应的field。
		File file2 = new File(PREFIX+"student2.json");
		JsonNode node = mapper.readTree(file2);
		log.info("Student2:name={},age={},femal={}",node.get("name").asText(),node.get("age").asInt(),node.get("female").asBoolean());
	}
	
	private void parseJsonFile_With_Array() throws Exception
	{
		//方法1:直接使用readValue，获得Course对象。
		File file1 = new File(PREFIX+"course1.json");
		ObjectMapper mapper = new ObjectMapper();
		Course course1 = mapper.readValue(file1, Course.class);
		log.info("Course1={}",course1.toString());
		
		//方法2:使用readTree获得JsonNode，再分别读取相应的field。
		File file2 = new File(PREFIX+"course1.json");
		JsonNode node = mapper.readTree(file2);
		log.info("courseName={},courseId={}",node.get("courseName").asText(),node.get("courseId").asText());
		JsonNode students = node.get("registeredStudent");
		Iterator<?> it = students.elements();
		while(it.hasNext())
		{
			log.info("student={}",it.next().toString());
		}
	}
	
	private void generateJson() throws Exception
	{
		Course course = new Course();
		course.setCourseId("yuwen");
		course.setCourseName("语文");
		List<Student> registeredStudent = new ArrayList<Student>();
		Student student = new Student();
		student.setAge(19);
		student.setFemale(false);
		student.setName("Jack");
		registeredStudent.add(student);
		course.setRegisteredStudent(registeredStudent);
		
		ObjectMapper mapper = new ObjectMapper();
		String courseStr = mapper.writeValueAsString(course);
		log.info("courseStr={}",courseStr);
		
		File file1 = new File(PREFIX+"course2.json");
		FileOutputStream output = new FileOutputStream(file1);
		output.write(courseStr.getBytes());
		output.flush();
		output.close();
	}

}
