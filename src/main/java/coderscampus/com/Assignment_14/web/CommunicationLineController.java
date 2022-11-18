package coderscampus.com.Assignment_14.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import coderscampus.com.Assignment_14.dto.CommunicationLine;
import coderscampus.com.Assignment_14.dto.TextLine;
import coderscampus.com.Assignment_14.services.CommunicationLineService;
import coderscampus.com.Assignment_14.services.Communications;




@Controller
public class CommunicationLineController {

	@Autowired
	private CommunicationLineService commsService;
	@Autowired
	private Communications messageService;
	
	@GetMapping("/")
	public String welcomeRedirect() {
		return "redirect:/welcome";
	}
	
	@GetMapping("/commLines/{channelId}")
	public String getChannel(ModelMap model, @PathVariable Long channelId) {
		CommunicationLine communicationLine = commsService.findChannelById(channelId);
		ArrayList<TextLine> messagesByChannel = (ArrayList<TextLine>) messageService.getCommunicationsByLine(channelId);
		model.put("communicationLine", communicationLine);
		model.put("messages", messagesByChannel);
		
		return "communicationLine";
	}
	
	@GetMapping("/welcome")
	public String getWelcome (ModelMap model) {
		List<CommunicationLine> commLines = commsService.findAll();
		model.put("commLines", commLines);
		return "welcome";
	}
}