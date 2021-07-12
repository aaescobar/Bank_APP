package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Bank;

import com.revature.util.ConnectionUtil;

public class BankRepoImpl implements BankRepo {

	//static final Logger log = Logger.getLogger(BankRepoImpl.class);
	
	public static Connection connection = ConnectionUtil.getConnection();
	
	public BankRepo br;

	public BankRepoImpl(BankRepo br) {
		// TODO Auto-generated constructor stub
		this.br = br;
	}

	public BankRepoImpl() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unused")
	@Override
	public Bank createBankAcc(Bank acc) {
		int BankAccCreated = 0;
		
		String sql = "INSERT INTO BANKACC(BANKACC_ID, BANKACC_BALANCE, BANKACC_TYPE, BANKACC_USERID) VALUES (?, ?)";
		
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);){
			
			ps.setInt(1, acc.getId());
			ps.setDouble(2, acc.getBalance());
			ps.setString(3, acc.getType());
			ps.setInt(4, acc.getUserId());
			
			BankAccCreated = ps.executeUpdate();
		
			
		} catch (SQLException e ) {
			e.printStackTrace();
		}
		return null;
		
		
	}

	@Override
	public Bank getBankBAcc(int id) {
		// TODO Auto-generated method stub
		Bank b = null;
		String sql = "SELECT * FROM BANKACC WHERE BANKACC_ID = ?";
		
		ResultSet rs = null;
		try(Connection connection = ConnectionUtil.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql)){
			
			
			//seting info
			//log.info("Setting New Info");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			//results from resultset
			if(rs.next()) {
				//log.info("Setting new Acc")
				int bankAccId = rs.getInt("BANKACC_ID");
				double balance = rs.getDouble("BANKACC_BALANCE");
				String type = rs.getString("DEBIT_CREDIT");
				int bankUserId = rs.getInt("BANKACC_USERID");
				
				b = new Bank(bankAccId, balance, type, bankUserId);
				return b;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			//log.info("Connection to Database ERROR" + e.getMessage());
		}
		return null;
	}

	@Override
	public List<Bank> getAllBankAccs() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM BANKACC WHERE BANKACC_ID";
		//create list to store information
		List<Bank> bankAccs = new ArrayList<Bank>();
		
		try(Connection connection = ConnectionUtil.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();)
		{
			//store info
			
			
			Bank a = new Bank();
			
			while(rs.next()) {
				//building accounts report
				int id = rs.getInt("BANKACC_ID");
				double balance = rs.getDouble("BANKACC_BALANCE");
				String type = rs.getString("DEBIT_CREDIT");
				int userId = rs.getInt("BANKACC_USERID");
				
				a.setId(id);
				a.setBalance(balance);
				a.setType(type);
				a.getUserId(userId);
				
				bankAccs.add(a);
				
			}
		
			
			//log.info("sending created list");
			return bankAccs;
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Bank updateBank(Bank alt) {
		@SuppressWarnings("unused")
		int userUpdates = 0;
		String sql = "UPDATE BANKACC "
					 + "SET BANKACC_BALANCE = ?, "
					 + "BANKACC_BALANCE = ?, "
					 + "DEBIT_OR_CREDIT = ?, "
					 + "SET BANKACC_USERID = ?, ";
		
		//log.info("Updating new Bank Account
		try(Connection connection = ConnectionUtil.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);){
				connection.setAutoCommit(false);
				
				ps.setInt(1, alt.getId());
				ps.setDouble(2,  alt.getBalance());
				ps.setString(3, alt.getType());
				ps.setInt(4, alt.getUserId());
				
				userUpdates = ps.executeUpdate();
				
				connection.commit();
				
				
		} catch (SQLException e) {
			//log.error("Unable to Connect to Database" + e.getMessage());
			e.printStackTrace();
		}
			//log.info("Problem with Setting info");	
		return null;
	}

	@Override
	public Bank deleteBank(Bank bankDelete) {
		String sql = "DELETE FROM BANKACC WHERE BANKACC_ID = ?"; 
		try {
			//preparedstatement 
			PreparedStatement ps = connection.prepareStatement(sql);
			 
			ps.setInt(1, bankDelete.getId());
			ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	
	public Bank deposit(int id, double amount) {
		// TODO Auto-generated method stub
		String sql = ("SET BANKACC_BALANCE = ?, "
				 	  + "BANKACC_BALANCE = ?, "
				 	  + "DEBIT_OR_CREDIT = ?, "
				 	  + "SET BANKACC_USERID = ?, ");
		
		try {
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			Bank b = br.getBankBAcc(id);
			
			
			ps.setDouble(1, getBankBAcc(id).getBalance() + amount);
			
			b = this.updateBank(b);
			
			
		} catch (SQLException e) {
			//log.info("");
			e.printStackTrace();
		}
		
		return null;
}

	public Bank withdrawFromAcc(int id, double amount) {
		Bank b = br.getBankBAcc(id);
		double balance = b.getBalance();
		
		b.setBalance(balance + amount);
		b = this.updateBank(b);
		return null;
		
	}
	

}
