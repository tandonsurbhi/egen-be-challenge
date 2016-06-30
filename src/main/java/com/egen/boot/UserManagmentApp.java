package com.egen.boot;

import static spark.Spark.get;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spark.Request;
import spark.Response;
import spark.Route;

import com.egen.controller.UserManagmentController;

/**
 * Base class of application that start sparkJava framework and load spring
 * application context used for dependency injection
 * 
 * @author Surbhi Tandon
 *
 */
public class UserManagmentApp {
	// path to check is application is running or not
	public static void main(String[] args) {
		get("/", new Route() {

			public Object handle(Request request, Response response) {
				return "Welcome to Egen coding challange !";
			}
		});
		// loading application context
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserManagmentController UserManagmentController = context.getBean("userManagmentController",
				UserManagmentController.class);
		UserManagmentController.setupEndpoints();
	}
}
