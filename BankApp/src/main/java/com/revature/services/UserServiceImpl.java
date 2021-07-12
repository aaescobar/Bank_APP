package com.revature.services;

import java.util.List;

import com.revature.models.User;
import com.revature.repositories.BankUserRepo;

public class UserServiceImpl implements UserService {

	public BankUserRepo bur;
	
	public UserServiceImpl(BankUserRepo bur) {
		this.bur = bur;
	}
	
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return bur.createUser(user);
	}
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return bur.getAllUsers();
	}

	public User getUser(int id) {
		// TODO Auto-generated method stub
		return bur.getUserById(id);
	}

	public User update(User update) {
		// TODO Auto-generated method stub
		return bur.updateUser(update);
	}

	public User deleteUser(int id) {
		// TODO Auto-generated method stub
		return bur.deleteUser(id);
	}

	

}
