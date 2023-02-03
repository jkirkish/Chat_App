package coderscampus.com.Assignment_14.web;
//Assignment14
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import coderscampus.com.Assignment_14.domain.Channel;
import coderscampus.com.Assignment_14.domain.Message;
import coderscampus.com.Assignment_14.domain.User;
import coderscampus.com.Assignment_14.services.ChannelService;
import coderscampus.com.Assignment_14.services.MessageService;
import coderscampus.com.Assignment_14.services.UserService;


@Controller
public class WelcomeController {

	@Autowired
	private ChannelService channelService;
	@Autowired
	private UserService userService;
	@Autowired 
	private MessageService messageService;

	@GetMapping("/welcome")
	public String getWelcomePage(ModelMap model) {
		List<Channel> allChannels = channelService.findAll();
		Channel channel = new Channel();
		model.put("channels", allChannels);
		model.put("channel", channel);
		return "welcome";
	}
	
	
	@PostMapping("/channel/{channelId}")
	public String postChannelPage(Message message) {
		Message messagesSaved = messageService.save(message);
		return "redirect:/channel";
	}
	
	@PostMapping("/saveUser")
	@ResponseBody
	public Boolean saveUser (@RequestBody User user) {
		user = userService.save(user);
		return (user != null);		
	}
	@PostMapping("/saveMess")
	@ResponseBody
	public Boolean saveMess(@RequestBody User user){
		messageService.saveMess(user);
		return true;
	}
	
	
	@GetMapping("")
	public String redirectToWelcome() {
		return "redirect:/welcome";
	}
	
	@PostMapping("/createChannel")
	public String createChannel(Channel channel) {
		channelService.save(channel);
		return "redirect:/welcome";
	}
	@PostMapping("/welcome/{channelId}/delete")
	public String deleteOneChannel(@PathVariable Long channelId) {
		channelService.delete(channelId);
		return "redirect:/welcome";
	}
}