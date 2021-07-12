package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.models.User;
import com.revature.services.UserService;

public class UserController {
	Gson gson = new Gson();
	UserService us;
	
	public UserController(UserService us) {
		this.us = us;
	}
	
	
	public io.javalin.http.Handler createUser = (context) -> {
			
			User u = gson.fromJson(context.body(), User.class);
			
			u = us.createUser(u);
			
			System.out.append("User Created");
			
			if(u != null) {
				context.result(gson.toJson(u));
				context.status(201);
			}else {
				context.status(404);
			}
			
					
		};
}
