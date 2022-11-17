package coderscampus.com.Assignment_14.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.Assignment14.dto.User;
import com.coderscampus.Assignment14.services.UserService;



@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/users")
	public User getRegistered (@RequestBody String username) {
		return userService.createUser(username);
	}
}
