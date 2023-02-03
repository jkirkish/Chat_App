package coderscampus.com.Assignment_14.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import coderscampus.com.Assignment_14.domain.User;
//myAssignment14
@Repository
public interface UsersRepository extends JpaRepository<User, Long>{
    
	User findByUsername(String username);

	User findByPassword(String password);

	
	
	
	
	
}
