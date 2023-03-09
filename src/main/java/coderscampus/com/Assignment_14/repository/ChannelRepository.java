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
		Channel general = new Channel();
		general.setChannelId(1L);
		general.setName("Main");
		
		channels.add(general);
	}
	public Optional<Channel> findById (Long channelId) {
		return channels.stream()
					   .filter(channel -> channel.getChannelId().equals(channelId))
					   .findAny();
	}
	public List<Channel> findAll() {
		
			System.out.println("Channel size is: " + channels.size());
		
		return channels;
	}
	public void saveChannel(Channel channel) {
		if(!channel.getName().isEmpty()) {
		System.out.println("size" + channels.size());
		int id = channels.size()+1;
		long index = (long)id;
		channel.setChannelId(index);
		channels.add(channel);
		System.out.println("Channels linklist size is now: " + channels.size());
		}
	}
	public void deleteChannel() {
	if(channels.size()>0) {
		System.out.println("size" + channels.size());
		
		//long id = channels.size();
		//long index = id;
		//channel.setChannelId(index);
		channels.remove();
		System.out.println("Channels linklist size is now: " + channels.size());
		
			
		}	
	}
	
	
	public Channel getChannel(Long id) {
		long l = id;
		int index = (int)l;
		return channels.get(index);
	}
}