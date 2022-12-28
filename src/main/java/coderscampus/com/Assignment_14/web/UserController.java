package coderscampus.com.Assignment_14.web;
import java.util.Optional;

//myAssignment14
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import coderscampus.com.Assignment_14.domain.User;
import coderscampus.com.Assignment_14.services.UserService;





@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	
	@GetMapping("/users/validateUsername")
	@ResponseBody
	public Boolean getValidUsername(String name) {
		return true;
	}
	@GetMapping("/validatePassword")
	@ResponseBody
	public Boolean getValidPassword(String password) {
		return true;
		
	}
	@PostMapping("/users")
	public User getRegistered (@RequestBody String username) {
		return userService.createUser(username);
	}
	
	@GetMapping("/register")
	public String getRegister(ModelMap model) {
		User user = new User();
		model.put("user", user);
		return "register";
	}
	@PostMapping("/register")
	public String postRegister(User user) {
		userService.save(user);
		return "redirect:/login";
	}
}

