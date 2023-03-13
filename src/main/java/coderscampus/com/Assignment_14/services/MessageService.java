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
	
	
	
	public ArrayList<Message> getMessagesByChannel (Long channelId) {
		return (ArrayList<Message>) messageRepo.findMessagesByChannel(channelId).orElse(new ArrayList<>());
	}

	public void addMessageToChannel(Message message) {
		Optional<Channel> channelOpt = channelRepo.findById(message.getChannelId());
		System.out.println("addMessageTOchannel is:" + message.getText());
		System.out.println("Id: " + message.getChannelId());
		System.out.println("channelOpt is " + channelOpt.get());
		if (channelOpt.isPresent()) {
			ArrayList<Message> messagesByChannel = getMessagesByChannel(message.getChannelId());
			messagesByChannel.add(message);
			
			messageRepo.saveMessagesByChannel(message.getChannelId(), messagesByChannel);
			
		}
	}
}
