package com.egen.dao.impl;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.egen.dao.UserDao;
import com.egen.model.User;

@Repository ("userDao")
public class UserDaoImpl implements UserDao {

	// Using MongoDB datastore created by Morphia
	@Autowired
	private Datastore datastore;

	@Override
	public List<User> getAllUsers() {
		List<User> users= datastore.find(User.class).asList();
		for (User user : users) {
			System.out.println(user.toString());
		}
		return users;
	}

	@Override
	public void addUser(User user) {
		datastore.save(user);

	}

	@Override
	public User getUserById(String id) {
		User user= datastore.get(User.class, id);
		return user;
	}
	
	public void delUser(String id){
		datastore.delete(User.class, id);
	}


}
