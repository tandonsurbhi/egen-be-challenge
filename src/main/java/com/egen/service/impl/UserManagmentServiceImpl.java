package com.egen.service.impl;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egen.dao.UserDao;
import com.egen.exception.InvalidDataException;
import com.egen.model.User;
import com.egen.service.UserManagmentService;
import com.google.gson.Gson;

@Service("userManagmentService")
public class UserManagmentServiceImpl implements UserManagmentService {

	private final org.slf4j.Logger logger = LoggerFactory
			.getLogger(UserManagmentServiceImpl.class);
	@Autowired
	UserDao userDao;

	@Override
	public void createUser(String body) throws InvalidDataException {
		try {
			User user = new Gson().fromJson(body, User.class);
			if (user == null && user.getId() == null && user.getId().isEmpty()) {
				throw new InvalidDataException("User Id is required");
			}
			User existingUser = userDao.getUserById(user.getId());
			if (!isUserPresent(existingUser)) {
				userDao.addUser(user);
			} else {
				logger.error("User Already exist in data store");
				throw new InvalidDataException(
						"User Already exist in data store");
			}
		} catch (com.google.gson.JsonSyntaxException ex) {
			throw new InvalidDataException("Error While Parsing Json");
		}
	}

	@Override
	public List<User> findAllUser() {
		return userDao.getAllUsers();
	}

	@Override
	public User findUserById(String userId) throws InvalidDataException {
		if (userId != null && !userId.isEmpty()) {
			return userDao.getUserById(userId);
		} else {
			throw new InvalidDataException("User Id is required");
		}
	}

	@Override
	public void updateUser(String userId, String body)
			throws InvalidDataException {
		User user = findUserById(userId);
		try {
			if (isUserPresent(user)) {
				User userToUpdate = new Gson().fromJson(body, User.class);
				if (userToUpdate == null && userToUpdate.getId() == null
						&& userToUpdate.getId().isEmpty()) {
					throw new InvalidDataException(
							"User Id is required for update");
				}
				userDao.addUser(userToUpdate);
			} else {
				throw new InvalidDataException("No user Found with user Id "
						+ userId);
			}
		} catch (com.google.gson.JsonSyntaxException ex) {
			throw new InvalidDataException("Error While Parsing Json");
		}
	}

	private boolean isUserPresent(User user) {
		boolean isUserPresent = false;
		if (user != null && user.getId() != null && !user.getId().equals("")) {
			isUserPresent = true;
		}
		return isUserPresent;
	}

	@Override
	public void delUser(String userId) {
		userDao.delUser(userId);
		
	}
}
