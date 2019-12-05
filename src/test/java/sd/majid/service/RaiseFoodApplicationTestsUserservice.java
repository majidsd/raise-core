package sd.majid.service;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sd.majid.model.User;
import sd.majid.util.HashData;
import sd.majid.util.UserStatus;

@SpringBootTest
public class RaiseFoodApplicationTestsUserservice {

	@Autowired
	private IUserService userService;
	
	@Test
	public void testGetUserById() {
		System.out.println(userService.getUserById(3L).toString());
	}
	
	@Test
	public void getAllUsers() {
		List<User> users = userService.getAllUsers();
		for(User user : users) {
			System.out.println(user.toString());
		}
	}
	
	@Test
	public void testAddUser() {
		User user = new User();
		user.setName("Mohammed Ali");
		user.setEmail("moe@sd.com");
		user.setPhone("0123456788");
		user.setUserName("moesd");
		user.setStatus(UserStatus.NEW);
		try {
			user.setPassword(HashData.sha1("admin"));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		user.setCreatedAt(new Date());
		System.out.println(userService.addUser(user));
	}
	
	@Test
	public void testUpdateUser() {
		User user = userService.getUserById(3L);
		user.setPhone("0123456780");
		System.out.println(userService.updateUser(user).toString());
	}
	
	@Test
	public void testDeleteUser() {
		User user = userService.getUserById(2L);
		System.out.println(userService.deleteUser(user));
	}

	
}
