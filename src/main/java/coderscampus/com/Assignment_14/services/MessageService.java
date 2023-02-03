package coderscampus.com.Assignment_14.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coderscampus.com.Assignment_14.domain.Channel;
import coderscampus.com.Assignment_14.domain.Message;
import coderscampus.com.Assignment_14.domain.User;
import coderscampus.com.Assignment_14.repository.MessageRepository;

//Assignment14

@Service
public class MessageService {
	@Autowired
	private MessageRepository messageRepo;
	@Autowired
	private UserService userService;
	@Autowired
	private ChannelService channelService;
	public List<Message> findAll() {
		return messageRepo.findAll();
	}

	public Message save(Message message) {
		return messageRepo.save(message);
	}

	public List<Message> findAllByChannelId(Long channelId) {
		return messageRepo.findByChannel_id(channelId);
	}


	public void saveMess(User user) {
		String username = user.getUsername();
		String[] usernameData = username.split(":");
		String usernameInfo = null;
		for(String data: usernameData) {
			usernameInfo = data;
		}
		int lengthOfUsername = usernameInfo.length();
		usernameInfo= usernameInfo.substring(1, lengthOfUsername - 2);
		List<User> allUsers = userService.findAll();
		User userPresent = null;
		for(User checkUser: allUsers) {
			String userInfo = checkUser.getUsername();
			if(usernameInfo.equals(userInfo)) {
				userPresent = checkUser;
				break;
			}
		}
		String mess = user.getMessage().get(0).getMessage();
		Message fullMess = new Message();
		Optional<Channel> channelFound = channelService.findById(user.getId());
		Channel fullChannel = channelFound.get();
		fullMess.setChannel(fullChannel);
		fullMess.setMessage(user.getMessage().get(0).getMessage());
		fullMess.setUser(userPresent);
		save(fullMess);
	}
	
}
