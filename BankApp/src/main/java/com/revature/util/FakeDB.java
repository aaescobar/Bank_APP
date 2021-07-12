package com.revature.util;

import java.util.HashMap;
import java.util.Map;

import com.revature.models.Bank;
import com.revature.models.User;

public class FakeDB {
	public static Map<Integer, Bank> banks = new HashMap<Integer, Bank>();
	public static Map<Integer, User> users = new HashMap<Integer, User>();
	
	public static int idCount = 0;
	public static int idCountUser = 0;
	
	//initializer style will run when class is loaded will get executed whenever the class is first loaded
	//static block
	static {
		Bank b1 = new Bank(1, 42.23, "DEBIT", 1192);
		banks.put(++idCount, b1);
		
		Bank b2 = new Bank(2, 100.00, "CREDIT", 0001);
		banks.put(++idCount, b2);
		
		Bank b3 = new Bank(3, 283.00, "DEBIT", 8913);
		banks.put(++idCount, b3);
		
		
		
		User u1 = new User("Rachel", "Smith", "rachsmith@pabo.net", "crazyness", 0523);
		users.put(++idCountUser, u1);
		
		User u2 = new User("Pablo" , "Escobar", "pab@rev.net", "hellomoto", 0212);
		users.put(++idCountUser, u2);
		
		
	
		
		
	}
}
