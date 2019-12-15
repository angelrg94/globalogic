package cl.globalogic.bci.test;

import cl.globalogic.bci.entities.User;

public class UserFixture {

	public static User validUser() {
		
		User user = new User();
		user.setEmail("angelgonzalez@gmail.com");
		user.setUsername("angelrg");
		user.setPassword("Argl1594");
		return user;
	}

	public static User validRepeatedUser() {

		User user = new User();
		user.setEmail("globalogic@gmail.com");
		user.setUsername("angelrg");
		user.setPassword("Argl1594");

		return user;
	}

	public static User invalidPasswordFormatUser() {

		User user = new User();
		user.setEmail("globalogic@gmail.com");
		user.setUsername("angelrg");
		user.setPassword("12345");

		return user;
	}

	public static User invalidEmailFormatUser() {

		User user = new User();
		user.setEmail("estono es un correo");
		user.setUsername("angelrg");
		user.setPassword("Argl1594");

		return user;
	}
}
