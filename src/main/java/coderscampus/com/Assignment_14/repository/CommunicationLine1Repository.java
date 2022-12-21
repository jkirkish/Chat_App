package coderscampus.com.Assignment_14.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import coderscampus.com.Assignment_14.dto.CommunicationLine;
@Repository
public interface CommunicationLine1Repository extends JpaRepository<CommunicationLine, Long> {
	
	CommunicationLine save(Optional<CommunicationLine> comLine);

}
