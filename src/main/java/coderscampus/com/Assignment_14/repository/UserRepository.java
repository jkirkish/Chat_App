package coderscampus.com.Assignment_14.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import coderscampus.com.Assignment_14.domain.User;

@Repository
public class UserRepository {

	private ArrayList<User> users = new ArrayList<>();
	
	public User save(User user) {

		int size = users.size();
		switch(size) {
		case 0:
			user.setId(1L);
			break;
		default:
			User EndParticipant = users.get(users.size()-1);
			user.setId(EndParticipant.getId() + 1L);
		}
		
		users.add(user);
		return user;
		
	}

	public List<User> findAll() {
		
		List<User> tmp = new ArrayList<>();
		for(int i = 0; i<users.size()-1; i++)
		{
			if(!(users.get(i)).equals(null))
				tmp.add(users.get(i));
		}
		
		return tmp;
	}
}

