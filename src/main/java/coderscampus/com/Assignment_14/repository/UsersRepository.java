package coderscampus.com.Assignment_14.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import coderscampus.com.Assignment_14.dto.User;
//myAssignment14
@Repository
public interface UsersRepository extends JpaRepository<User, Long>{
    
	//SQL select * from users where username = :username
	User findByUsername(String username);
	//SQL select * from users where password = :password
	User findByPassword(String password);
    //select * from users where username = :username and password = :password
	List<User> findByUsernameAndUsername(String username,String password);
	
	
	
	
}
