package DAO;

import java.util.ArrayList;
import java.util.List;

import module.User;



public class UserService {

	List<User> listOfUser=new ArrayList<User>();
	public User addUser(User user)
	{
		if(listOfUser.add(user))
		{
			return user;
		}
		return null;
		
	}
	public List<User> getAllUser()
	{
		return listOfUser;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
