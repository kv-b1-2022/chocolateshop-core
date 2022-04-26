package in.chocoapp.dao;

import in.chocoapp.model.User;

public interface IUserDAO {

	void addUser(User user) throws Exception;
	// Adds new user into the database

	User userDetails(String mail) throws Exception;
	// Show the details of the user to the details

	int signUpMailValidation(String mail) throws Exception;
	// Checks whether the user is already existing by mail

	int signUpNumberValidation(String mobile) throws Exception;
	// Check whether the user is already existing by number

	String loginMailValidation(String mail, String password) throws Exception;
	// Checks whether the credentials is match by mail

	String loginNumberValidation(String mobile, String password) throws Exception;
	// Checks whether the credentials is match by number

}
