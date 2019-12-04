package sd.majid.service;


import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sd.majid.model.User;

@SpringBootTest
class RaisefoodApplicationTests {

	@Autowired
	private IUserService userService;
	@Test
	public void testAddUser() {
		User user = new User();
		user.setName("Abdalmajid Abdalla");
		user.setEmail("mail@sd.com");
		user.setPhone("0123456789");
		user.setUserName("majidsd");
		user.setCreatedAt(new Date());
		System.out.println(userService.addUser(user));
	}
	

}
