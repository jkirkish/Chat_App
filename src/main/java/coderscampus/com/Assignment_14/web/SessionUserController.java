package coderscampus.com.Assignment_14.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import coderscampus.com.Assignment_14.domain.Channel;
import coderscampus.com.Assignment_14.domain.RegisteredUsers;
import coderscampus.com.Assignment_14.services.UserService;


  @RestController  
  public class SessionUserController {
	
	@Autowired
	private UserService userService;
	  

		@PostMapping("/user")
		public RegisteredUsers createSessionUser (@RequestBody String name) {
			  return userService.createSessionUser(name);
			  
		}
}
