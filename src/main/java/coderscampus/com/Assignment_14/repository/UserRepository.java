package coderscampus.com.Assignment_14.repositorimport

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Component;

import com.coderscampus.Assignment14.dto.User;

org.springframework.stereotype.Component;

	



@Component
public class UserRepository {

	private Set<User> users = new LinkedHashSet<>();
	
	public User save (User user) {
		if (users.size() == 0) {
			user.setId(1L);
		} else {
			User EndUser = ((TreeSet<User>)users).last();
			user.setId(EndUser.getId() + 1L);
		}
		users.add(user);
		return user;
	}
}
