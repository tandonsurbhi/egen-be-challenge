package com.egen.service.impl;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.egen.exception.InvalidDataException;
import com.egen.model.User;
import com.egen.service.UserManagmentService;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-test.xml")
public class UserManagmentServiceImplTest {

	@Autowired
	private UserManagmentService userManagmentService;
	
	@After
	public void tear() {
		userManagmentService.delUser("101");
	}
	
	@Test
	public void createUserTest() throws InvalidDataException{
		userManagmentService.createUser("{\"id\":\"101\",\"firstName\":\"Jack\",\"lastName\":\"Dawson\",\"email\":\"jack@gmail.com\",\"address\":{\"street\":\"2\",\"city\":\"Newark\",\"zip\":19713,\"state\":\"DE\",\"country\":\"USA\"},\"dateCreated\":\"Apr 24, 2016 12:00:00 AM\",\"company\":{\"name\":\"ABC\",\"website\":\"www.abc.com\"},\"profilePic\":\"/path/to/pic\"}");
		User user=userManagmentService.findUserById("101");	
		Assert.assertNotNull(user);
		Assert.assertEquals(user.getFirstName(), "Jack");
		userManagmentService.delUser("101");
	}
	
	@Test(expected = InvalidDataException.class)
	public void createUserTestInvalidJson() throws InvalidDataException{
		userManagmentService.createUser("{\"id\":\"101\",\"firstName\":\"Jack\",\"lastName\":\"Dawson\",\"email\":\"jack@gmail.com\",\"address\":{\"street\":\"2\",\"city\":\"Newark\",\"zip\":19713,\"state\":\"DE\",\"country\":\"USA\"},\"dateCreated\":\"Apr 24, 2016 12:00:00 AM\",\"company\":{\"name\":\"ABC\",\"website\":\"www.abc.com\"},}");
	}
	
	@Test
	public void findAllUserTest(){
		try {
			userManagmentService.createUser("{\"id\":\"101\",\"firstName\":\"Jack\",\"lastName\":\"Dawson\",\"email\":\"jack@gmail.com\",\"address\":{\"street\":\"2\",\"city\":\"Newark\",\"zip\":19713,\"state\":\"DE\",\"country\":\"USA\"},\"dateCreated\":\"Apr 24, 2016 12:00:00 AM\",\"company\":{\"name\":\"ABC\",\"website\":\"www.abc.com\"},\"profilePic\":\"/path/to/pic\"}");
		} catch (InvalidDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<User> users= userManagmentService.findAllUser();
		Assert.assertNotNull(users);
		userManagmentService.delUser("101");
	}
	
	@Test
	public void findUserByIdTest() throws InvalidDataException{
		try {
			userManagmentService.createUser("{\"id\":\"101\",\"firstName\":\"Jack\",\"lastName\":\"Dawson\",\"email\":\"jack@gmail.com\",\"address\":{\"street\":\"2\",\"city\":\"Newark\",\"zip\":19713,\"state\":\"DE\",\"country\":\"USA\"},\"dateCreated\":\"Apr 24, 2016 12:00:00 AM\",\"company\":{\"name\":\"ABC\",\"website\":\"www.abc.com\"},\"profilePic\":\"/path/to/pic\"}");
		} catch (InvalidDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		User users= userManagmentService.findUserById("101");
		Assert.assertNotNull(users);
		Assert.assertEquals(users.getFirstName(), "Jack");
		userManagmentService.delUser("101");
	}
	
	@Test(expected = InvalidDataException.class)
	public void findUserByIdTestIsEmpty() throws InvalidDataException{
		
		User users= userManagmentService.findUserById("");
	}
	
	@Test
	public void updateUserTest() throws InvalidDataException{
		try {
			userManagmentService.createUser("{\"id\":\"101\",\"firstName\":\"Jack\",\"lastName\":\"Dawson\",\"email\":\"jack@gmail.com\",\"address\":{\"street\":\"2\",\"city\":\"Newark\",\"zip\":19713,\"state\":\"DE\",\"country\":\"USA\"},\"dateCreated\":\"Apr 24, 2016 12:00:00 AM\",\"company\":{\"name\":\"ABC\",\"website\":\"www.abc.com\"},\"profilePic\":\"/path/to/pic\"}");
		} catch (InvalidDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userManagmentService.updateUser("101","{\"id\":\"101\",\"firstName\":\"Surbhi\",\"lastName\":\"Dawson\",\"email\":\"jack@gmail.com\",\"address\":{\"street\":\"2\",\"city\":\"Newark\",\"zip\":19713,\"state\":\"DE\",\"country\":\"USA\"},\"dateCreated\":\"Apr 24, 2016 12:00:00 AM\",\"company\":{\"name\":\"ABC\",\"website\":\"www.abc.com\"},\"profilePic\":\"/path/to/pic\"}");
		User user=userManagmentService.findUserById("101");	
		Assert.assertNotNull(user);
		Assert.assertEquals(user.getFirstName(), "Surbhi");
		userManagmentService.delUser("101");
	}
	
	@Test(expected = InvalidDataException.class)
	public void updateUserTestUnhappy() throws InvalidDataException{
		
		userManagmentService.updateUser("1000","{\"id\":\"101\",\"firstName\":\"Surbhi\",\"lastName\":\"Dawson\",\"email\":\"jack@gmail.com\",\"address\":{\"street\":\"2\",\"city\":\"Newark\",\"zip\":19713,\"state\":\"DE\",\"country\":\"USA\"},\"dateCreated\":\"Apr 24, 2016 12:00:00 AM\",\"company\":{\"name\":\"ABC\",\"website\":\"www.abc.com\"},\"profilePic\":\"/path/to/pic\"}");
		
	}
}
