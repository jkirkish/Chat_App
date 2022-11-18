package coderscampus.com.Assignment_14.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coderscampus.com.Assignment_14.dto.User;
import coderscampus.com.Assignment_14.repository.UserRepository;





@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public User createUser (String name) {
		User user = new User();
		user.setName(name);
		return userRepo.save(user);
	}
}

