package coderscampus.com.Assignment_14.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "channels")
public class CommunicationLine {
	private Long channelId;
	private String name;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getChannelId() {
		return channelId;
	}
	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}
	public String getName() {
		return name;
	}
	public void setName(String channelName) {
		this.name = channelName;
	}
}
