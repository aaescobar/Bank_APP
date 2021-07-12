package com.revature.services;

import java.util.List;

import com.revature.models.Bank;
import com.revature.repositories.BankRepo;

public class BankServiceRepoImpl implements BankServiceRepo {
	
	public BankRepo br;
	
	//constructor with parameter
	public BankServiceRepoImpl(BankRepo br) {
		this.br = br;
	}
	
	/* implemented methods from Ryan Movie example
	 * 
	 * */

	public Bank createBankAccs(Bank acc) {
		// TODO Auto-generated method stub
		return br.createBankAcc(acc);
	}

	
	public Bank getBankAcc(int id) {
		// TODO Auto-generated method stub
		return br.getBankBAcc(id);
	}

	
	public List<Bank> getAllBankAcc() {
		// TODO Auto-generated method stub
		return br.getAllBankAccs();
	}

	public Bank deleteBank(Bank del) {
		// TODO Auto-generated method stub
		return br.deleteBank(del);
	}

	
	public Bank updateBank(Bank alt) {
		// TODO Auto-generated method stub
		return br.updateBank(alt);
	}

	@Override
	public Bank deposit(int id, double amount) {
		return br.deposit(id, amount);
	}

	@Override
	public Bank withdrawFromAcc(int id, double amount) {
		// TODO Auto-generated method stub
		return br.withdrawFromAcc(id, amount);
	}
	


}
