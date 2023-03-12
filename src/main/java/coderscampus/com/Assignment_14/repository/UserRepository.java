package coderscampus.com.Assignment_14.repository;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import coderscampus.com.Assignment_14.domain.RegisteredUsers;

@Repository
public class UserRepository {

	private ArrayList<RegisteredUsers> users = new ArrayList<>();
	
	public RegisteredUsers save(RegisteredUsers user) {
//		if (users.size() == 0) {
//			user.setId(1L);
//		} else {
//			RegisteredUsers EndParticipant = users.get(users.size()-1);
//			user.setId(EndParticipant.getId() + 1L);
//		}
		int size = users.size();
		switch(size) {
		case 0:
			user.setId(1L);
			break;
		default:
			RegisteredUsers EndParticipant = users.get(users.size()-1);
			user.setId(EndParticipant.getId() + 1L);
		}
		
		users.add(user);
		return user;
		
	}
}

