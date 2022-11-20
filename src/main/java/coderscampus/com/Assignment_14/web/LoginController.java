package coderscampus.com.Assignment_14.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import coderscampus.com.Assignment_14.dto.User;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String getLogin(ModelMap model) {
		User user = new User();
		model.put("user", user);
		return "login";
	}
}
