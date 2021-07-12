package com.revature.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.revature.models.User;
import com.revature.util.FakeDB;

public class BankUserRepoDBImpl implements BankUserRepo{
 
	public BankUserRepoDBImpl() {
		super();
	}

	@Override
	public User createUser(User ad) {
		// TODO Auto-generated method stub
		ad.setId(FakeDB.idCountUser++);
		
		FakeDB.users.put(ad.getId(), ad);
		return ad;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> userList = new ArrayList<User>();
		Set<Integer> keys = FakeDB.users.keySet();
		
		keys.forEach(key -> userList.add(FakeDB.users.get(key)));
		
		// TODO Auto-generated method stub
		return userList;
	}

	
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return FakeDB.users.get(id);
	}

	@Override
	public User updateUser(User alt) {
		// TODO Auto-generated method stub
		FakeDB.users.replace(alt.getId(), alt);
		return alt;
	}

	@Override
	public User deleteUser(int id) {
		// TODO Auto-generated method stub
	
		return FakeDB.users.remove(id);
	}
}
