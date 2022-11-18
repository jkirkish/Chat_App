package coderscampus.com.Assignment_14.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import coderscampus.com.Assignment_14.dto.TextLine;
import coderscampus.com.Assignment_14.services.Communications;





@RestController
public class CommunicationController {
	@Autowired
	private Communications messageService;
	
	@GetMapping("/messages/{channelId}")
	public List<TextLine> getMessagesByChannelId (@PathVariable Long channelId) {
		List<TextLine> channelMessages = messageService.getCommunicationsByLine(channelId);
		return channelMessages;
	}
	
	@PostMapping("/messages") 
	public void postMessagesToUserId (@RequestBody TextLine message) {
		messageService.putCommunicationToLine(message);
	}
}