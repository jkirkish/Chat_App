package coderscampus.com.Assignment_14.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coderscampus.com.Assignment_14.domain.Channel;
import coderscampus.com.Assignment_14.repository.ChannelRepository;

@Service
public class ChannelService {

	@Autowired
	private ChannelRepository channelRepo;

	public List<Channel> findAll() {
		return channelRepo.findAll();
	}

	public Optional<Channel> findById(Long channelId) {
		return channelRepo.findById(channelId);
	}

	public Channel save(Channel channel) {
		return channelRepo.save(channel);
	}


}