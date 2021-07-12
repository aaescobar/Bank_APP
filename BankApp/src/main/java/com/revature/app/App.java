package com.revature.app;

import com.revature.controllers.UserController;
import com.revature.controllers.bankController;
import com.revature.repositories.BankRepo;
import com.revature.repositories.BankRepoImpl;
import com.revature.repositories.BankUserRepo;
import com.revature.repositories.BankUserRepoImpl;
import com.revature.services.BankServiceRepo;
import com.revature.services.BankServiceRepoImpl;
import com.revature.services.UserService;
import com.revature.services.UserServiceImpl;

import io.javalin.Javalin;

public class App {
	
	public static void main(String [] arg) {
		//instantiate javalin object
		
		Javalin app = Javalin.create().start();
		//establish the endpoints javalin will manage
		establishRoutes(app);
		//starting javalin object
		app.start(7000);
		
		
		
	}
	
	private static void establishRoutes(Javalin app) {
		
		//will deine list of endpoints javalin will manage user, services, bank
		BankRepo br = new BankRepoImpl();
		BankServiceRepo bsr = new BankServiceRepoImpl(br);
		
		BankUserRepo bur = new BankUserRepoImpl();
		UserService us = new UserServiceImpl(bur);
		
		//bank account services
		bankController bc = new bankController(bsr);
		//user services
		UserController uc = new UserController(us);
		
		
		//establishes routes to landing page
		
		app.get("/", (ctx) -> ctx.result("This is the Bank Application"));
		
		app.get("/hello", (ctx) -> ctx.result("WELCOME!"));
		
		//establish user endpoints
		
		app.post("/users", uc.createUser);
		
		

		
		
		//establish bank account endpoints
		
		app.post("/account", bc.createBankAcc);
		
		
		
		
	}

}
