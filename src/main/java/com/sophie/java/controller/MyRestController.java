package com.sophie.java.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class MyRestController
{

	@RequestMapping(value="/hello")
	public String hello()
	{
		return "Hello Amanda!";
	}
}
