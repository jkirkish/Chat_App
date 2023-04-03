package coderscampus.com.Assignment_14.services;
//Jose_14_Assignment
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coderscampus.com.Assignment_14.domain.Channel;
import coderscampus.com.Assignment_14.repository.ChannelRepository;


@Service
public class ChannelService {
	
	
	
	
	@Autowired
	private ChannelRepository channelRepo;//class repository
	
	public Channel findChannelById(Long channelId) {
		return channelRepo.findById(channelId).orElse(new Channel());
		
	}

	public List<Channel> findAll() {
		
		return channelRepo.findAll();
	}

	public void save(Channel channel) {
		 channelRepo.saveChannel(channel);
		
	}

	public void deleteChannel() {
		  channelRepo.deleteChannel();
	}
		 
}
