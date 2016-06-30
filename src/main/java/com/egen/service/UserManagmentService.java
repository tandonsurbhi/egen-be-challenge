package com.egen.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.egen.exception.InvalidDataException;
import com.egen.model.User;

/**
 * Service class Responsible for handling logic of application
 * 
 * @author Surbhi Tandon
 *
 */
public interface UserManagmentService {

	/**
	 * Create User if User is not exist in database
	 * 
	 * @param body
	 *            - JSON to create User
	 * @throws InvalidDataException
	 *             - Throw Exception when JSON is invalid or userId already
	 *             exist
	 */
	public void createUser(String body) throws InvalidDataException;

	/**
	 * Method List of all users from database
	 * 
	 * @return - List of all users from database
	 */
	public List<User> findAllUser();

	/**
	 * Find user from database if user is present.
	 * 
	 * @param userId
	 *            - User id to search in database
	 * @return - User exist in database
	 * @throws InvalidDataException
	 *             - Throw Exception when User is not found
	 */
	public User findUserById(String userId) throws InvalidDataException;

	/**
	 * Update User when user is found in database
	 * 
	 * @param userId
	 *            - User id to search in database
	 * @param Body
	 *            - Updated User JSON String
	 * @throws InvalidDataException
	 *             - Throw Exception when User is not found
	 */
	public void updateUser(String userId, String Body) throws InvalidDataException;

	/**
	 * User to delete using UserId
	 * 
	 * @param userId
	 *            - UserId to delete
	 */
	public void delUser(String userId);

}
