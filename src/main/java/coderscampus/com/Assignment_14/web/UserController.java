package coderscampus.com.Assignment_14.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import coderscampus.com.Assignment_14.dto.User;
import coderscampus.com.Assignment_14.services.UserService;




@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/exists")
	public Boolean getExists(String username) {
		return true;
	}
	
	@GetMapping("/users/validateUsername")
	public Boolean getValidUsername(String name) {
		return true;
	}
	@GetMapping("/validatePassword")
	public Boolean getValidPassword(String password) {
		return true;
		
	}
	@PostMapping("/users")
	public User getRegistered (@RequestBody String username) {
		return userService.createUser(username);
	}
}
