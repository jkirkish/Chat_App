package coderscampus.com.Assignment_14.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.Assignment14.dto.CommunicationLine;
import com.coderscampus.Assignment14.dto.TextLine;
import com.coderscampus.Assignment14.repository.communicationLineRepository;
import com.coderscampus.Assignment14.repository.textLineRepository;



@Service
public class Communications {

	@Autowired
	private textLineRepository textLineRepo;
	@Autowired
	private communicationLineRepository communicationRepo;
	
	public List<TextLine> getCommunicationsByLine (Long channelId) {
		return textLineRepo.findMessagesByChannel(channelId).orElse(new ArrayList<>());
	}

	public void putCommunicationToLine(TextLine message) {
		Optional<CommunicationLine> channelOpt = communicationRepo.findById(message.getChannelId());
		if (channelOpt.isPresent()) {
			List<TextLine> communicationByLine = getCommunicationsByLine(message.getChannelId());
			communicationByLine.add(message);
			textLineRepo.saveMessagesByChannel(message.getChannelId(), communicationByLine);
		}
	}
}
