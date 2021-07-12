package com.revature.services;

import java.util.List;

import com.revature.models.Bank;

public interface BankServiceRepo {
	//services of creating and managing bank account 
	public Bank createBankAccs(Bank acc);
	
	public Bank getBankAcc(int id);
	
	public List<Bank> getAllBankAcc();
	
	public Bank deleteBank(Bank del);
	
	public Bank updateBank(Bank alt);
//

	Bank deposit(int id, double amount);

	Bank withdrawFromAcc(int id, double amount);


}