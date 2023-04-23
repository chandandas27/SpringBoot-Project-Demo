package com.chandan.springbootdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chandan.springbootdemo.model.User;

@RestController
public class HomeController {

	@RequestMapping("/")
	public String home() {
		return "Hello world !!";
	}
	
	@GetMapping("/user")
	public User user(){
	
	User user = new User();
    user.setId("1");
	user.setName("Chandan");
	user.setEmailId("chandan@gmail.com");
	
	return user;
	
	}
	
	@GetMapping("/{id}/{id2}")
	public String pathVariable(@PathVariable String id,@PathVariable("id2") String name) {
		
		
		return "The path variable is:"+id+":"+name;
	
	}
	
	@GetMapping("/requestParam")
	public String requestParams(@RequestParam String name, @RequestParam(name="email",required = false, defaultValue="") String emailId) {
		return "Your name is:"+name+" & emailId is:"+emailId;
		
	}
}
