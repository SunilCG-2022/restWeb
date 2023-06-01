package com.cg.restservices.restwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	
	private static List<User> users = new ArrayList<>(); 
	
	private static int countUser = 0;
	
	static {
		users.add(new User(++countUser,"Ram",LocalDate.now().minusYears(28)));
		users.add(new User(++countUser,"Sita",LocalDate.now().minusYears(26)));
		users.add(new User(++countUser,"Krishna",LocalDate.now().minusYears(25)));
		users.add(new User(++countUser,"Radha",LocalDate.now().minusYears(24)));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User findOne(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id); 
		return users.stream().filter(predicate).findFirst().orElse(null);
	}
	
	public User saveUser(User user) {
		user.setId(++countUser);
		users.add(user);
		return user;
	}
	
	public void deleteById(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id); 
		 users.removeIf(predicate);
	}

}
