package coderscampus.com.Assignment_14.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coderscampus.com.Assignment_14.domain.User;
import coderscampus.com.Assignment_14.repository.UserRepository;
import coderscampus.com.Assignment_14.repository.UsersRepository;



@Service
public class UserService {
	@Autowired
	private UsersRepository userRepo;//JPA repository
	@Autowired
	private UserRepository userRepo1; //class repository
	
	public User createUser (String name) {
		User user = new User();
		user.setName(name);
		return userRepo.save(user);
	}
    public Long countUsers(String name) {
    	User user = new User();
    	user.setName(name);
    	if(user.getName().equals(name))
    	    userRepo.count();
    	
    	return userRepo.count();
}
	
	public User save(User user) {
		return userRepo.save(user);
	}

	public List<User> findAll() {
		return userRepo.findAll();
	}
	
	public User findByPassword(String password) {
		return userRepo.findByPassword(password);
	}

	public User findByUsername(String username) {
		
		return userRepo.findByUsername(username);
	}
	public User createSessionUser(String name) {
		User user = new User();
		user.setName(name);
		System.out.println("Session " + user.getName());
		return userRepo1.save(user);
	}
	
}