package coderscampus.com.Assignment_14.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import coderscampus.com.Assignment_14.domain.Channel;
import coderscampus.com.Assignment_14.domain.Message;
import coderscampus.com.Assignment_14.services.ChannelService;
import coderscampus.com.Assignment_14.services.MessageService;

@Controller
public class ChannelController {

	@Autowired
	private ChannelService channelService;
	@Autowired
	private MessageService messageService;
	
	@GetMapping("/")
	public String welcomeRedirect() {
		return "redirect:/welcome";
	}
	
	@GetMapping("/channels/{channelId}")
	public String getChannel(ModelMap model, @PathVariable Long channelId) {
		Channel channel = channelService.findChannelById(channelId);
		List<Message> messagesByChannel = messageService.getMessagesByChannel(channelId);
		model.put("channel", channel);
		model.put("messages", messagesByChannel);
		
		return "channel";
	}
	
	@GetMapping("/welcome")
	public String getWelcome (ModelMap model) {
		List<Channel> channels = channelService.findAll();
		Channel channel = new Channel();
		model.put("channels", channels);
		model.put("channel", channel);
		return "welcome";
	}
	@PostMapping("/createChannel")
	public String createChannel(Channel channel) {
		channelService.save(channel);
		return "redirect:/welcome";
	}
}