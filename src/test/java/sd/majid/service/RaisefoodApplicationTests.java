package sd.majid.service;


import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sd.majid.model.User;

@SpringBootTest
class RaisefoodApplicationTests {

	@Autowired
	private IUserService userService;
	
	@Test
	public void testGetUserById() {
		System.out.println(userService.getUserById(2L).toString());
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
		user.setName("Ali Osman");
		user.setEmail("mail@sd.com");
		user.setPhone("0123456789");
		user.setUserName("hereUser");
		user.setCreatedAt(new Date());
		System.out.println(userService.addUser(user));
	}
	
	@Test
	public void testUpdateUser() {
		User user = userService.getUserById(1L);
		user.setPhone("0123456780");
		System.out.println(userService.updateUser(user).toString());
	}
	
	@Test
	public void testDeleteUser() {
		User user = userService.getUserById(1L);
		System.out.println(userService.deleteUser(user));
	}

}
