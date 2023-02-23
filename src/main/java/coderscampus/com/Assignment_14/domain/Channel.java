package coderscampus.com.Assignment_14.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.persistence.OneToMany;
//Channel
@Entity
@Table(name = "Channels")
public class Channel {
	
	private Long channelId;
	private String name;
	private List<Message> message = new ArrayList<>();
	private User user;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	@OneToMany(mappedBy = "channel")
	public List<Message> getMessage() {
		return message;
	}
	public void setMessage(List<Message> message) {
		this.message = message;
	}
	@ManyToOne
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Channel [channelId=" + channelId + ", name=" + name + ", message=" + message + ", user=" + user + "]";
	}
}