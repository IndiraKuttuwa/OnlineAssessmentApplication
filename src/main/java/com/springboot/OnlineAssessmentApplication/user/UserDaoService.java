package com.springboot.OnlineAssessmentApplication.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	@Autowired
	UserRepository userRepository;
	
	
	private static List<User> adminsList = new ArrayList<User>();
	
	static User admin1 = new User("roger@gmail.com","wipro@123","Roger","Kutcher","admin");
	static User admin2 = new User("steve@gmail.com","wipro@123","Steve","Martin","admin");
	static {
	adminsList.add(admin1);
	adminsList.add(admin2);

	
	
	}
	public void addAdmins()
	{
		userRepository.save(admin1);
		userRepository.save(admin2);
		
	}
	public User findOne(String email)
	{
		Optional<User> user = userRepository.findById(email);
		if(user.isPresent())
		return user.get();
		else
		return null;
	}
	
	public boolean checkIfAdmin(String email)
	{
		for(User user: adminsList)
		{
			System.out.println(user.getEmail());
			if(user.getEmail().equals(email))
				return true;
		}
		return false;
	}
	
	public void save(User user)
	{
		userRepository.save(user);
		
	}
	
	public ArrayList<User> findAll()
	{
		return (ArrayList<User>) userRepository.findAll();
	}
	

}
