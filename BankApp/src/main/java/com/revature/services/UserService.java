package com.revature.services;

import java.util.List;

import com.revature.models.User;

public interface UserService {
	public User createUser(User user);
	public List<User> getAllUsers();
	public User getUser(int id);
	public User update(User update);
	public User deleteUser(int id);
	
	
}
