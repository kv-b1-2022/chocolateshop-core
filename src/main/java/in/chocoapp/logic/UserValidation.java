package in.chocoapp.logic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import in.chocoapp.model.User;

public class UserValidation {
	private static Logger log = LogManager.getLogger(UserValidation.class);

	public static int registerDetailsValidation(User user) {

		int testName = validateName(user.getName());
		int testNumber = validateNumber(user.getMobile());
		int testMail = validateMail(user.getEmail());
		int testPassword = validatePassword(user.getPassword());
		int testAddress = validateAddress(user.getAddress());

		if (testName + testNumber + testMail + testPassword + testAddress == 0) {
			return 1;
		} else {
			return 0;
		}
	}

	// Checking user name
	public static int validateName(String name) {

		if (name.isEmpty() || name.isBlank()) {
			log.error("Given name is empty !");

			return 1;
		}
		return 0;
	}

	// Checking user number
	public static int validateNumber(String number) {
		int count = 0;
		if (number.length() != 10) {
			log.error("Invalid mobile number !!!");

			return 1;
		} else {
			for (int i = 0; i < number.length(); i++) {
				char ch = number.charAt(i);
				if (!Character.isDigit(ch)) {
					count++;
					log.error("Invalid mobile number");

					break;
				}
			}
			return count;
		}
	}

	/*
	 * if(number.length()==10) { int count=0; for (int i = 0; i < number.length();
	 * i++) { char ch = number.charAt(i); if (!Character.isDigit(ch)) { count++; }
	 * if (count!=0) { log.warn("Invalid number !!!");
	 * log.info("Enter mobile number:"); return 1; } else { return 0; }
	 */

	// Checks user password
	public static int validatePassword(String password) {
		if (password.isEmpty() || password.isBlank() || password.length() < 8 || password.length() > 16) {
			log.error("Password entered is less than 8 characters or greater than 16 characters");

			return 1;
		} else
			return 0;
	}

	// Checks user mail
	public static int validateMail(String mail) {
		if (!mail.contains("@") || !mail.contains(".")) {
			log.error("Invalid mail");
			return 1;
		} else
			return 0;
	}

	// Checks user address
	public static int validateAddress(String city) {

		if (city.isEmpty() || city.isBlank()) {
			log.error("Given address is empty !");

			return 1;
		}
		return 0;
	}
}
