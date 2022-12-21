package coderscampus.com.Assignment_14.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import coderscampus.com.Assignment_14.dto.CommunicationLine;
import coderscampus.com.Assignment_14.dto.TextLine;
import coderscampus.com.Assignment_14.services.ComLineServices;
import coderscampus.com.Assignment_14.services.CommunicationLineService;
import coderscampus.com.Assignment_14.services.CommunicationService;




@Controller
public class CommunicationLineController {

	@Autowired
	private CommunicationLineService commsService;
	@Autowired
	private CommunicationService messageService;
	@Autowired
	private ComLineServices comService;
	
	@GetMapping("/")
	public String welcomeRedirect() {
		return "redirect:/welcome";
	}
	
	
	
	@GetMapping("/welcome")
	public String getWelcome (ModelMap model) {
		List<CommunicationLine> commLines = commsService.findAll();
		model.put("commLines", commLines);
		return "welcome";
	}
	@PostMapping("/createChannel")
	public String createChannel(CommunicationLine comline) {
		comService.save(comline);
		return "redirect:/welcome";
	}
}