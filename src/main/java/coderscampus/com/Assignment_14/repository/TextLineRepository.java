package coderscampus.com.Assignment_14.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import coderscampus.com.Assignment_14.dto.CommunicationLine;
import coderscampus.com.Assignment_14.dto.TextLine;

@Repository
public interface TextLineRepository extends JpaRepository<TextLine, Long>{
	
	List<TextLine> findByChannel_id(Long channelId);
	@Query(value ="SELECT * FROM MESSAGE WHERE channel_Id = ?", nativeQuery = true)
	List<TextLine> findAllByChannelId(Long channelId);
	Optional<CommunicationLine> findMessagesByChannel(Long channelId);
	

}
