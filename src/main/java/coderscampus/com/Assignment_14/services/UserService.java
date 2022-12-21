package coderscampus.com.Assignment_14.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coderscampus.com.Assignment_14.domain.User;
import coderscampus.com.Assignment_14.repository.UsersRepository;


//myAssignment14
@Service
public class UserService {
	@Autowired
	private UsersRepository userRepo;
	

	public Optional<User> findByUsername(String username) {
		return userRepo.findByUsername(username);
	}
	
	public User createUser (String name) {
		User user = new User();
		user.setName(name);
		return userRepo.save(user);
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
}