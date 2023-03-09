package coderscampus.com.Assignment_14.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import coderscampus.com.Assignment_14.domain.RegisteredUsers;
import coderscampus.com.Assignment_14.services.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/ErrorLogin")
	public String getError() {
		return "/ErrorLogin";
	}
	
	//pulls up the login.html view
	@GetMapping("/login")
	public String getLogin(ModelMap model) {
		RegisteredUsers user = new RegisteredUsers();
		model.put("user", user);
		return "login";
	}
	
	@PostMapping("/login")
	public String postLogin(String username, String password) {
		List<RegisteredUsers> users = userService.findAll();
		String url = "redirect:/ErrorLogin";
		for (int i = 0; i < users.size(); i++) {
			{
				if (users.get(i).getUsername().equalsIgnoreCase(username)&& users.get(i).getPassword().equals(password))
				{
					url = "redirect:/welcome";
				}

			}
		}
		return url;
	}
}
