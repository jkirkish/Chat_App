package coderscampus.com.Assignment_14.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coderscampus.com.Assignment_14.domain.User;
import coderscampus.com.Assignment_14.repository.UserRepository;




@Service
public class UserService {
	
	
	@Autowired
	private UserRepository userRepo1; 
	
	public User createUser (String name) {
		User user = new User();
		user.setName(name);
		return userRepo1.save(user);
	}
    
	
	public User save(User user) {
		return userRepo1.save(user);
	}

	public List<User> findAll() {
		return userRepo1.findAll();
	}
	
	public User createSessionUser(String name) {
		User user = new User();
		user.setName(name);
		return userRepo1.save(user);
	}
	
}
