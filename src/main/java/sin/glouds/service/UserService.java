package sin.glouds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sin.glouds.entity.sins.User;
import sin.glouds.repository.sins.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	public User getByUsername(String username) {
		return userRepository.findOneByUsername(username);
	}
	
}
