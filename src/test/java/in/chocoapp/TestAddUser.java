package in.chocoapp;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import in.chocoapp.dao.UserDAO;
import in.chocoapp.logic.UserValidation;
import in.chocoapp.model.User;

public class TestAddUser {

	private static Logger log = LogManager.getLogger(TestAddUser.class);

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Scanner dc = new Scanner(System.in);
		System.out.println("Enter name:");
		String name = sc.next();
		System.out.println("Enter email:");
		String email = sc.next();
		System.out.println("Enter mobile number:");
		String mobile = sc.next();
		System.out.println("Enter password:");
		String password = sc.next();
		System.out.println("Enter address:");
		String address = dc.nextLine();

		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setMobile(mobile);
		user.setAddress(address);
		user.setPassword(password);

		System.out.println(user);

		int detailsCheck = UserValidation.registerDetailsValidation(user);
		UserDAO saveUser = new UserDAO();
		if (detailsCheck == 1) {
			try {
				saveUser.addUser(user);
				log.info("Registration successful for this user "+user);
			} catch (Exception e) {
				//log.error(e.getMessage());
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		} else {
			log.error("Registration failed for this user "+user);
			System.out.println("Enter valid inputs");
		}
		sc.close();
		dc.close();
	}
}
