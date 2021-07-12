package com.revature.repositories;

import java.util.List;

import com.revature.models.User;

public interface BankUserRepo {
	//same format as movie example
	public User createUser(User ad);
	
	//get all users
	public List<User> getAllUsers();
	
	//get user
	public User getUserById(int id);
	
	//update user
	public User updateUser(User alt);
	
	//delete user
	public User deleteUser(int id);
}
