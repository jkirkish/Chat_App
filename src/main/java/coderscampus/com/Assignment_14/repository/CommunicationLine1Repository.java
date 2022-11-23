package coderscampus.com.Assignment_14.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import coderscampus.com.Assignment_14.dto.CommunicationLine;

public interface CommunicationLine1Repository extends JpaRepository<CommunicationLine, Long> {
	
	CommunicationLine save(Optional<CommunicationLine> comLine);

}
