package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import model.User;

class UserTest {

	@Test
	void test() {
		User joseLuis = new User("joseluis@mail.com", "joseluishozg", "pass", false);
		User andres = new User("andres@gmail.com", "andres", "Pasw0rd", false);
		User alonso = new User("alonsos@gmail.com", "alonso", "Pasw0rd", false);
		assertEquals(joseLuis.getUserId(), 1);
		assertEquals(andres.getUserId(), 2);
		assertEquals(alonso.getUserId(), 3);
		System.out.println(andres.getLastLogin());
	}

}
