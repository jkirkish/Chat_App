package coderscampus.com.Assignment_14.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coderscampus.com.Assignment_14.dto.CommunicationLine;
import coderscampus.com.Assignment_14.repository.CommunicationLine1Repository;

@Service
public class ComLineServices {
	
	@Autowired
	private CommunicationLine1Repository lineService;
	
	public CommunicationLine save( Optional comLine) {
		return lineService.save(comLine);
		
	}

}
