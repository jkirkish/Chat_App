package coderscampus.com.Assignment_14.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coderscampus.com.Assignment_14.dto.CommunicationLine;
import coderscampus.com.Assignment_14.dto.TextLine;
import coderscampus.com.Assignment_14.repository.CommunicationLineRepository;
import coderscampus.com.Assignment_14.repository.TextLineRepository;

//Assignment14

@Service
public class CommunicationService {

	@Autowired
	private TextLineRepository textLineRepo;
	@Autowired
	private CommunicationLineRepository communicationRepo;

	public List<TextLine> getCommunicationsByLine(Long channelId) {
		return textLineRepo.findMessagesByChannel(channelId);
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
