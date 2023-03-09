package coderscampus.com.Assignment_14.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Channel {
	
	private Long channelId;
	private String name;
	
	public Long getChannelId() {
		return channelId;
	}
	public void setChannelId(Long id) {
		this.channelId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String channelName) {
		this.name = channelName;
	}
	@Override
	public String toString() {
		return "Channel [channelId=" + channelId + ", name=" + name + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(channelId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Channel other = (Channel) obj;
		return Objects.equals(channelId, other.channelId);
	}
	

}