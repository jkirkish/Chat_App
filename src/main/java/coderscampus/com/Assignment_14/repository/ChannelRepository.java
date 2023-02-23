package coderscampus.com.Assignment_14.repository;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import coderscampus.com.Assignment_14.domain.Channel;

@Repository
public class ChannelRepository {
	private LinkedList<Channel> channels = new LinkedList<>();
	
	public ChannelRepository () {
		Channel Main = new Channel();
		Main.setChannelId(1L);
		Main.setName("Main");
		
		channels.add(Main);
	}
	public Optional<Channel> findById (Long channelId) {
		return channels.stream()
					   .filter(channel -> channel.getChannelId().equals(channelId))
					   .findAny();
	}
	public List<Channel> findAll() {
		return channels;
	}
}