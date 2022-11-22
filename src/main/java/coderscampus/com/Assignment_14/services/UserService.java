package coderscampus.com.Assignment_14.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coderscampus.com.Assignment_14.dto.User;
import coderscampus.com.Assignment_14.repository.UserRepository;
import coderscampus.com.Assignment_14.repository.UsersRepository;





@Service
public class UserService {

	//this userRepo variable is for the session of users who are participating in the chatBox
	@Autowired
	private UserRepository userRepo;
	
	//this usersRepo variable is for the database of users who register 
	@Autowired
	private UsersRepository usersRepo;
	
	public User createUser (String name) {
		User user = new User();
		user.setName(name);
		return userRepo.save(user);
	}
	
	public User save(User user) {
		return usersRepo.save(user);
	}

	public User findByUsername(String username) {
		
		return usersRepo.findByUsername(username);
	}

	public User findById(Long userId) {
		Optional<User> userOpt = usersRepo.findById(userId);
		return userOpt.orElse(new User());
	
	}
}

