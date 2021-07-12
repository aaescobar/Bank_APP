package com.revature.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.revature.models.Bank;
import com.revature.services.BankServiceRepo;
import com.revature.services.UserService;

public class bankController {
	BankServiceRepo bs;
	Gson gson = new Gson();
	UserService us;
	
	
	public bankController(BankServiceRepo bs) {
		this.bs = bs;
		
	}
	

	


	public io.javalin.http.Handler createBankAcc = (context) -> {
		Bank b = gson.fromJson(context.body(), Bank.class);
		
		b = bs.createBankAccs(b);
		
		
		if(b != null) {
			context.result(gson.toJson(b));
			context.status(201);
			
		}else {
			context.result("{}");
			context.status(404);
			//log.error("missing info");
		}
		
		
	};
	
	
	
	public io.javalin.http.Handler getAllBankAcc= (context) -> {
		
	
		List<Bank> banks = bs.getAllBankAcc();
		context.result(gson.toJson(banks));
		context.status(400);
	};
	

	public io.javalin.http.Handler getBankAcc = (ctx) -> {
		String input = ctx.pathParam("id");
		
		int id;
		
		
		
		try {
			id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			id = -1;
		}
		
		Bank bs1 = bs.getBankAcc(id);
		
		if(bs != null) {
			ctx.result(gson.toJson(bs1));
			ctx.status(200);
		} else {
			ctx.status(404);
		}
		
	};
	
	
	public io.javalin.http.Handler updateBankAcc = (context) -> {
		
		String input = context.pathParam("account_id");
		
		Bank b = gson.fromJson(context.body(), Bank.class);
		
		int accountId;
		
		try {
			accountId = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			accountId = -1;
		}
		b.setId(accountId);
		
		b = bs.updateBank(b);

		if(b != null) {
			context.result(gson.toJson(b));
			context.status(200);
		} else {
			context.result("{}");
			
			context.status(404);
		}
	};
	
	public io.javalin.http.Handler deleteBankAcc = (context) ->{
		String input = context.pathParam("id");
		
		Bank b = gson.fromJson(context.body(), Bank.class);
		int accountId;
		
		try {
			accountId = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			accountId = -1;
		}
		
		b.setId(accountId);
		
	b = bs.deleteBank(b);
	
	if(b != null) {
		context.status(204);
	}else {
		context.status(404);
	}
		
		
	};
	
	public io.javalin.http.Handler withDrawDeposit = (ctx) ->{
		
		
		String uIdInput = ctx.pathParam("userId");
		String aIdInput = ctx.pathParam("accountId[]]");
		
		int userId;
		int userId2;
		
		try {
			userId = Integer.parseInt(uIdInput);
			userId2 = Integer.parseInt(aIdInput);
			
		} catch (NumberFormatException e) {
			userId= -1;
			userId2  = -1;
			//log.warn("User is not an int:");
		}
	};	


	
	
	
	
}
