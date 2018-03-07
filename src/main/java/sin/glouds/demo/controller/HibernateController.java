package sin.glouds.demo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import sin.glouds.demo.entity.User;
import sin.glouds.demo.repository.UserRepository;

@RestController
public class HibernateController {

	@Autowired
	private UserRepository userRepository;
	private Gson gson = new Gson();
	
	@RequestMapping("saveUser")
	public String saveUser() {
		User user = new User();
		user.setUsername("glouds");
		user.setAddress("水清木华");
		user.setBirthDay(new Date());
		user.setSex("男");
		User result = userRepository.save(user);
		return gson.toJson(result);
	}
}
