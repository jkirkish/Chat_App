package coderscampus.com.Assignment_14.repository;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import coderscampus.com.Assignment_14.dto.User;

@Component
public class UserRepository {

	private ArrayList<User> users = new ArrayList<>();

	public User save(User user) {
		if (users.size() == 0) {
			user.setId(1L);
		} else {
			User Endparticipant = users.get(users.size() - 1);
			user.setId(Endparticipant.getId() + 1L);
		}
		users.add(user);
		return user;
	}

}
