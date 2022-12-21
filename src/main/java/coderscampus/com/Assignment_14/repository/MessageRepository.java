package coderscampus.com.Assignment_14.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import coderscampus.com.Assignment_14.domain.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long>{
	
	List<Message> findByChannel_id(Long channelId);
	@Query(value ="SELECT * FROM MESSAGE WHERE channel_Id = ?", nativeQuery = true)
	List<Message> findAllByChannelId(Long channelId);
	

}
