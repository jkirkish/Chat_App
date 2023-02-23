package coderscampus.com.Assignment_14.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coderscampus.com.Assignment_14.domain.Channel;
import coderscampus.com.Assignment_14.domain.Message;
import coderscampus.com.Assignment_14.repository.ChannelRepository;
import coderscampus.com.Assignment_14.repository.MessageRepository;

@Service
public class MessageService {

	@Autowired
	private MessageRepository messageRepo;
	@Autowired
	private ChannelRepository channelRepo;
	
	public List<Message> getMessagesByChannel (Long channelId) {
		return messageRepo.findMessagesByChannel(channelId).orElse(new ArrayList<>());
	}

	public void addMessageToChannel(Message message) {
		Optional<Channel> channelOpt = channelRepo.findById(message.getChannelId());
		if (channelOpt.isPresent()) {
			List<Message> messagesByChannel = getMessagesByChannel(message.getChannelId());
			messagesByChannel.add(message);
			messageRepo.saveMessagesByChannel(message.getChannelId(), messagesByChannel);
		}
	}
}