package coderscampus.com.Assignment_14.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import coderscampus.com.Assignment_14.dto.User;

@Repository
public interface UsersRepository extends JpaRepository<User, Long>{
    
	//SQL select * from users where username = :username
	User findByUsername(String username);

}
