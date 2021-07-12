package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class BankUserRepoImpl implements BankUserRepo {
	
	//initializing logger
	static final Logger log = Logger.getAnonymousLogger();
	
	
	public static Connection connection = ConnectionUtil.getConnection();

	@Override
	public User createUser(User ad) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO USERS VALUES (default, ?, ?, ?, ?) ";

		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1, ad.getFirstName());
			ps.setString(2, ad.getLastName());
			ps.setString(3, ad.getEmail());
			ps.setString(4, ad.getPassword());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return buildUser(rs);
			}
		} catch (SQLException e) {
			// TODO verify desired result
			e.printStackTrace();
		}
		
		return null;

	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM USERS";
		List<User> users = new ArrayList<>();
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				users.add(buildUser(rs));
				
			}
			return users;
			
		}catch (SQLException e) {
			//log.warn("Failed to Connect to Database");
			e.printStackTrace();
		}
		return null;
	}

	
	
	
	
	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM USERS WHERE USER_ID = ?";
		//using movie example as guide
		try {

			PreparedStatement ps = connection.prepareStatement(sql);

		
			log.info("Setting Up Values");
			ps.setInt(1, id);

		
			ResultSet rs = ps.executeQuery();

			// Extract results out of ResultSet
			if (rs.next()) {
				log.info("Creating New Client");
				return buildUser(rs);
			}

		} catch (SQLException e) {
			//log.error("Database Connection Issues";
			e.printStackTrace();
		}
		log.info("Problem with Setting Info");
		return null;
	}

	@Override
	public User updateUser(User alt) {
		// TODO Auto-generated method stub
		//log.info("Running user Updates");
		String sql = "UPDATE USERS SET first_name = ?,"
								   + " last_name = ?, "
								   + " email = ?, "
								   + " password = ?, "
								   + " id = ?, ";
		
		try { PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1, alt.getFirstName());
		ps.setString(2, alt.getLastName());
		ps.setString(3, alt.getEmail());
		ps.setString(4, alt.getPassword());
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			return buildUser(rs);
		}
		
		} catch (SQLException e) {
			//log.warn("Failed to Connect to Database"), e)
			e.printStackTrace();
		}
								   
								   
		return null;
	}

	@Override
	public User deleteUser(int id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM USERS WHERE USER_ID = ?";
		

		try {PreparedStatement ps = connection.prepareStatement(sql);
		
			//log.info("setting up values");
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			log.info("New users");
			return buildUser(rs);
			}
		}catch (SQLException e) {
			e.printStackTrace();
			//log.error("Failed Connecting to DataBase");
		}
	
		
		return null;
	}
	
	
	public User buildUser(ResultSet rs) throws SQLException {
		//log.trace("Run buildUser");
		User user = new User(
				rs.getString("first_name"),
				rs.getString("last_name"),
				rs.getString("email"),
				rs.getString("password"),
				rs.getInt("id"));
			
		return user;
				
	}
	


}
