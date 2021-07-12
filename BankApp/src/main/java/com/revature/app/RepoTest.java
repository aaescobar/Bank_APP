package com.revature.app;

import java.util.List;

import com.revature.models.Bank;
import com.revature.repositories.BankRepo;
import com.revature.repositories.BankRepoDBImpl;


public class RepoTest {
	public static void main(String[] args) {
		BankRepo br = new BankRepoDBImpl();
		
		List<Bank> banks = br.getAllBankAccs();
		
		System.out.println(banks);
		
		System.out.println(br.getBankBAcc(2));
		
		
		System.out.println(br.getBankBAcc(1));
		
		Bank bank = new Bank(4, 139.0, "Debit", 0001);
		bank = br.createBankAcc(bank);
		System.out.println("----ADDING MOVIE-----");
		System.out.println(bank);
		
		
	
		
	}
}
