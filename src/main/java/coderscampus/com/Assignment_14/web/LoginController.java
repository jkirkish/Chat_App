package coderscampus.com.Assignment_14.web;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import coderscampus.com.Assignment_14.dto.User;
import coderscampus.com.Assignment_14.services.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	
	
	@GetMapping("/login/{id}")
	public String getLogin(ModelMap model,@PathVariable Long id) {
		User user = userService.findById(id);
		model.put("users", Arrays.asList(user));
		model.put("user", user);
		String url = "";
		
		return "redirect:/welcome";
	}
	
}
