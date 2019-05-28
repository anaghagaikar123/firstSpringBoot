package com.example.demo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mapper.User;
import com.example.mapper.UserMapper;

@RestController
@RequestMapping("/home")
public class ServiceController {
	
	@Autowired
	private UserMapper userMapper;
	
	private static Logger log = LoggerFactory.getLogger(ServiceController.class);
	
	@GetMapping("/print")
	public void print()
	{
		log.info("print..");
	}

	@GetMapping("/getAll")
	public List<User> getAll()
	{
		log.info("***getAll***");
		return userMapper.findAll();
	}
	
	@GetMapping("/addUser/{name}")
	public List<User> addUser(@PathVariable String name)
	{
		log.info("***addUser***");
		User user = new User();
		user.setName(name);
		userMapper.insert(user);
		return userMapper.findAll();
	}
	
	@GetMapping("/findOne/{id}")
	public User findOne(@PathVariable Long id)
	{
		log.info("***findOne***");
		User user = userMapper.findOne(id);
		return user ;
	}
	
	@GetMapping("/update/{id}/{name}")
	public User update(@PathVariable Long id ,@PathVariable String name)
	{
		log.info("***findOne***");
		User user = userMapper.findOne(id);
		user.setName(name);
		userMapper.update(user);
		return userMapper.findOne(id);
	}
	
}
