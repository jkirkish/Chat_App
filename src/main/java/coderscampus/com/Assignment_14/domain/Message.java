package coderscampus.com.Assignment_14.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class Message {
	private String text;
	private LocalDateTime createdDate;
	private Long channelId;
	private User user;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public Long getChannelId() {
		return channelId;
	}
	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Message [text=" + text + ", createdDate=" + createdDate + ", channelId=" + channelId + ", user=" + user
				+ "]";
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
		Message other = (Message) obj;
		return Objects.equals(channelId, other.channelId);
	}
}