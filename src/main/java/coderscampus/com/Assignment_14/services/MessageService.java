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
	private ChannelService channelService;
	
	
	
	public ArrayList<Message> getMessagesByChannel (Long channelId) {
		return (ArrayList<Message>) messageRepo.findMessagesByChannel(channelId).orElse(new ArrayList<>());
	}

	public void addMessageToChannel(Message message) {
		Channel channelOpt = channelService.findChannelById(message.getChannelId());
		if (channelOpt != null) {
			ArrayList<Message> messagesByChannel = getMessagesByChannel(message.getChannelId());
			messagesByChannel.add(message);
			
			messageRepo.saveMessagesByChannel(message.getChannelId(), messagesByChannel);
			
		}
	}
}
