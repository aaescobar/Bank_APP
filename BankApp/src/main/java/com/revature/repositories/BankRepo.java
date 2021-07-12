package com.revature.repositories;

import java.util.List;

//command shift o
import com.revature.models.Bank;

public interface BankRepo {
	
	//primary functionality create account 
	//open bank account
	public Bank createBankAcc(Bank acc);
		
	//trying to find/filter a bank account through id
	public Bank getBankBAcc(int id);
	
	
	//not searching for specific bank
	public List<Bank> getAllBankAccs();

	//update bank obj
	
	public Bank updateBank(Bank alt);
	//delete obj
	
	public Bank deleteBank(Bank bankDelete);
	
	//deposit 
	public Bank deposit(int id, double amount);
	//withdrawal

	public Bank withdrawFromAcc(int id, double amount);

	
}
