package coderscampus.com.Assignment_14.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CommunicationLine")
public class CommunicationLine {
	private Long channelId;
	private String name;
	private List<TextLine> message = new ArrayList<>();
	private User user;
	
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
	public List<TextLine> getMessage() {
		return message;
	}
	public void setMessage(List<TextLine> message) {
		this.message = message;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
