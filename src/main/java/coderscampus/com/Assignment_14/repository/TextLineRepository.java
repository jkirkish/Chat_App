package coderscampus.com.Assignment_14.repository;


	import java.util.HashMap;
	import java.util.List;
	import java.util.Map;
	import java.util.Optional;

	import org.springframework.stereotype.Component;

import coderscampus.com.Assignment_14.dto.TextLine;




	@Component
	public class TextLineRepository {
		private Map<Long, List<TextLine>> messages = new HashMap<>();
		
		public Optional<List<TextLine>> findMessagesByChannel (Long channelId) {
			List<TextLine> messagesByChannel = messages.get(channelId);
			return Optional.ofNullable(messagesByChannel);
		}
		
		public void saveMessagesByChannel(Long channelId, List<TextLine> messagesByChannel) {
			messages.put(channelId, messagesByChannel);
		}
	}

