package coderscampus.com.Assignment_14.repository;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Component;
import com.coderscampus.Assignment14.dto.User;
import org.springframework.stereotype.Component;

	



@Component
public class UserRepository {

	
	private ArrayList<User>users = new ArrayList<>();
	
	public User save (User user) {
		if (users.size() == 0) {
			user.setId(1L);
		} else {
			User Endparticipant = users.get(users.size()-1);    
			user.setId(Endparticipant.getId() + 1L);
		}
		users.add(user);
		return user;
	}
}
