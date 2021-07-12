package com.revature.models;



public class Bank {
	private int id;
	private double balance;
	private int userId;
	private String type; //debit account or credit account 
	
	public Bank() {
		super();
	}

	
	public Bank(int id, double balance, String type, int userId) {
		// TODO Auto-generated constructor stub
		super();
		this.id = id;
		this.balance = balance;
		this.type = type;
		this.userId = userId;
	}

	//auto generated getters and setters 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getUserId() {
		return userId;
	}
	//public void setUserId(int userId) {
	//	this.userId = userId;
	//}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	//auto generated auto toString
	
	@Override
	public String toString() {
		return "Bank [id=" + id + ", balance=" + balance + ", userId=" + userId + ", type=" + type + "]";
	}


	public void getUserId(int userId) {
		// TODO Auto-generated method stub
		this.userId = userId;
	}
	
	

}
