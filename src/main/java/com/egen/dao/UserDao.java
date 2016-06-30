package com.egen.dao;

import java.util.List;

import com.egen.model.User;

/**
 * Responsible for all Data CURD operation on User Class
 * 
 * @author Surbhi Tandon
 *
 */
public interface UserDao {

	/**
	 * Adding user to database
	 * 
	 * @param user
	 *            - User to add
	 */
	void addUser(User user);

	/**
	 * Getting all users from database
	 * 
	 * @return - list of user from data base
	 */
	List<User> getAllUsers();

	/**
	 * Check if user Exist in database
	 * 
	 * @param id
	 *            - to find user
	 * @return - User if userid exist in data base
	 */
	User getUserById(String id);

	/**
	 * Deleting user from database
	 * 
	 * @param id
	 *            - User id for deleting user
	 */
	void delUser(String id);

}
