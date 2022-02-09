package com.gcu.business;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.gcu.data.IDataAccess;
import com.gcu.model.CredentialsModel;
import com.gcu.model.UserModel;


/**
 * The Business service for Security and Data Validation
 */
@Service
public class SecurityBusinessService
{
	//Autowired DataAccess interface as DAO
	@Autowired
	IDataAccess<UserModel> DAO;
	/**
	 * Validates that the User logging in is a valid user
	 * @param credentials User model containing username and password
	 * @return true/false if the credentials are valid
	 */
	//Authenticate method is used for logging in or authenticating a user, by returning loadbyUsername
	public boolean authenticate(CredentialsModel credentials) 
	{
		//SecurityBusiness authenticate, call loadByUsername helper method and pass user 
		String username = credentials.getUsername();
		UserModel user = this.loadUserByUsername(username);
		if (user != null && user.getCredentials().getPassword().compareTo(credentials.getPassword()) == 0) {
			System.out.println("User Authenticated");
			return true;
		}
		System.out.println("User Not Authenticated");
		return false;
	}
	/** loads the user by searched username
	 * @param username (searched username)
	 * @return UserDetails of found user/exception
	 */
	//loadByUsername helper method 
	public UserModel loadUserByUsername(String username) {
		//Create new user by finding it in the database by username
		UserModel user = DAO.findByUsername(username);
		return user;
	}
}
