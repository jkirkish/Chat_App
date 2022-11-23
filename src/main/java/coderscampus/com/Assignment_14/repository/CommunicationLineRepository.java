package coderscampus.com.Assignment_14.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import coderscampus.com.Assignment_14.dto.CommunicationLine;

@Component
public class CommunicationLineRepository {

	private List<CommunicationLine> channels = new ArrayList<>();

	public CommunicationLineRepository() {
		CommunicationLine general = new CommunicationLine();
		general.setChannelId(1L);
		general.setName("General");

		channels.add(general);
	}

	public Optional<CommunicationLine> findById(Long channelId) {
		return channels.stream().filter(channel -> channel.getChannelId().equals(channelId)).findAny();
	}

	public List<CommunicationLine> findAll() {
		return channels;
	}

	
}
