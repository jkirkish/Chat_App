package coderscampus.com.Assignment_14.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





@Service
public class CommunicationLineService {
	
	@Autowired
	private communicationLineRepository channelRepo;
	
	public CommunicationLine findChannelById(Long channelId) {
		return channelRepo.findById(channelId).orElse(new CommunicationLine());
	}

	public List<CommunicationLine> findAll() {
		return channelRepo.findAll();
	}
}