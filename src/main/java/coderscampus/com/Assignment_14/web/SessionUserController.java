package coderscampus.com.Assignment_14.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import coderscampus.com.Assignment_14.domain.Channel;
import coderscampus.com.Assignment_14.domain.User;
import coderscampus.com.Assignment_14.services.UserService;


  @RestController  
  public class SessionUserController {
	
	@Autowired
	private UserService userService;
	  
//	@GetMapping("/users")
//	public Long CountUser (@RequestBody String name) {
//		System.out.println(name);
//		return userService.countUsers(name);
//	}
		@PostMapping("/user")
		public String createSessionUser (@RequestBody String name) {
			  userService.createSessionUser(name);
			  return "redirect:/channel";
		}
}
