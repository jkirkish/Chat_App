package coderscampus.com.Assignment_14.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import coderscampus.com.Assignment_14.domain.RegisteredUsers;

@Repository
public interface UsersRepository extends JpaRepository<RegisteredUsers, Long>{
    
	RegisteredUsers findByUsername(String username);

	RegisteredUsers findByPassword(String password);

	
	
	
	
	
}
