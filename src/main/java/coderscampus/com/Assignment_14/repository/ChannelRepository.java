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
		Channel main = new Channel();
		Channel main2 = new Channel();
		Channel main3 = new Channel();
		main.setChannelId(1L);
		main2.setChannelId(2L);
		main3.setChannelId(3L);
		main.setName("Main Channel");
		main2.setName("Second Channel");
		main3.setName("Third Channel");
		channels.add(main);
		channels.add(main2);
		channels.add(main3);
	}
	public Optional<Channel> findById (Long channelId) {
		return channels.stream()
					   .filter(channel -> channel.getChannelId().equals(channelId))
					   .findAny();
	}
	public List<Channel> findAll() {
		
		
		return channels;
	}
	public void saveChannel(Channel channel) {
		if(!channel.getName().isEmpty()) {
		
		int id = channels.size()+1;
		long index = (long)id;
		channel.setChannelId(index);
		channels.add(channel);
		
		}
	}
	public void deleteChannel() {
	if(channels.size()>0) {
		
		channels.remove();
			
		}	
	}
	
	public Channel getChannel(Long id) {
		long l = id;
		int index = (int)l;
		return channels.get(index);
		
	}
}