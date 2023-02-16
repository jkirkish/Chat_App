package coderscampus.com.Assignment_14.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coderscampus.com.Assignment_14.domain.Channel;
import coderscampus.com.Assignment_14.repository.ChannelRepository;
import coderscampus.com.Assignment_14.repository.ChannelRepository1;

@Service
public class ChannelService {
	
	@Autowired
	private ChannelRepository1 channelRepo;
	
	public Channel findChannelById(Long channelId) {
		return channelRepo.findById(channelId).orElse(new Channel());
	}

	public List<Channel> findAll() {
		return channelRepo.findAll();
	}

	public Channel save(Channel channel) {
		return channelRepo.save(channel);
		
	}

	public void deleteChannel(Long channelId) {
		 channelRepo.deleteById(channelId);
		
	}
}

