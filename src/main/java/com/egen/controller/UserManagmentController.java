package com.egen.controller;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;
import static spark.Spark.exception;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spark.Request;
import spark.Route;

import com.egen.exception.InvalidDataException;
import com.egen.model.User;
import com.egen.service.UserManagmentService;
import com.egen.util.JsonTransformer;

/**
 * Controller Class responsible for handling Rest API URI and calling their
 * respective functionality.
 * 
 * @author Surbhi Tandon
 *
 */
@Component("userManagmentController")
public class UserManagmentController {

	// base path of API
	private static final String API_PATH = "egenChallange/api/v1";
	private static final String CREATE_PATH = "/users/create";
	private static final String UPDATE_PATH = "/users/update/:id";
	private static final String VIEW_PATH = "/users/view";
	private static final String FIND_PATH = "/users/find/:id";
	private static final String HEADER = "application/json";

	@Autowired
	private UserManagmentService userManagmentService;

	/**
	 * Setting up all the End points of Rest URLs
	 */
	public void setupEndpoints() {
		createUserEndpoint();
		findUserEndpoint();
		viewAllUserEndpoint();
		updateUserEndpoint();
		exceptionEndpoint();
	}

	/**
	 * Method is called when any exception is thrown
	 */
	private void exceptionEndpoint() {
		exception(InvalidDataException.class, (e, req, res) -> {
			res.status(404);
			res.body("{\"error\":\"404\" \n \"message\": \"" + e.getMessage() + "\"}");
		});
	}

	/**
	 * Handling Update URL of application
	 */
	private void updateUserEndpoint() {
		put(API_PATH + UPDATE_PATH, HEADER, (request, response) -> {
			userManagmentService.updateUser(request.params(":id"), request.body());
			response.status(201);
			response.body("{sucess : 201, message: User updated successfully}");
			return response.body();
		});
	}

	/**
	 * Handling View URL of application
	 */
	private void viewAllUserEndpoint() {
		get(API_PATH + VIEW_PATH, HEADER, new Route() {
			@Override
			public Object handle(Request request, spark.Response response) throws Exception {
				List<User> users = userManagmentService.findAllUser();
				return users;
			}
		}, new JsonTransformer());
	}

	/**
	 * Handling find User URL of application
	 */
	private void findUserEndpoint() {
		get(API_PATH + FIND_PATH, HEADER, new Route() {
			@Override
			public Object handle(Request request, spark.Response response) throws Exception {
				User user = userManagmentService.findUserById(request.params(":id"));
				return user;
			}
		}, new JsonTransformer());
	}
	
	/**
	 * Handling create URL of application
	 */
	private void createUserEndpoint() {
		post(API_PATH + CREATE_PATH, HEADER, (request, response) -> {
			userManagmentService.createUser(request.body());
			response.status(201);
			response.body("{sucess : 201, message: User Created successfully}");
			return response.body();
		});
	}

}
