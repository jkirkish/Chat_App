package coderscampus.com.Assignment_14.repository;

import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import coderscampus.com.Assignment_14.domain.User;

@Repository
public class UserRepository {

	private Set<User> users = new TreeSet<>();
	
	public User save (User user) {
		if (users.size() == 0) {
			user.setId(1L);
		} else {
			User lastUser = ((TreeSet<User>)users).last();
			user.setId(lastUser.getId() + 1L);
		}
		users.add(user);
		return user;
	}
}
