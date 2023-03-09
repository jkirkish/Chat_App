package coderscampus.com.Assignment_14.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coderscampus.com.Assignment_14.domain.RegisteredUsers;
import coderscampus.com.Assignment_14.repository.UserRepository;
import coderscampus.com.Assignment_14.repository.UsersRepository;



@Service
public class UserService {
	@Autowired
	private UsersRepository userRepo;//JPA repository
	@Autowired
	private UserRepository userRepo1; //class repository
	
	public RegisteredUsers createUser (String name) {
		RegisteredUsers user = new RegisteredUsers();
		user.setName(name);
		return userRepo.save(user);
	}
    public Long countUsers(String name) {
    	RegisteredUsers user = new RegisteredUsers();
    	user.setName(name);
    	if(user.getName().equals(name))
    	    userRepo.count();
    	
    	return userRepo.count();
}
	
	public RegisteredUsers save(RegisteredUsers user) {
		return userRepo.save(user);
	}

	public List<RegisteredUsers> findAll() {
		return userRepo.findAll();
	}
	
	public RegisteredUsers findByPassword(String password) {
		return userRepo.findByPassword(password);
	}

	public RegisteredUsers findByUsername(String username) {
		
		return userRepo.findByUsername(username);
	}
	public RegisteredUsers createSessionUser(String name) {
		RegisteredUsers user = new RegisteredUsers();
		user.setName(name);
		System.out.println("Session " + user.getName());
		return userRepo1.save(user);
	}
	
}
