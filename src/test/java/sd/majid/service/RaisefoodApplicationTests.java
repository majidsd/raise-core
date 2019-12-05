package sd.majid.service;


import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sd.majid.model.Raise;
import sd.majid.model.User;

@SpringBootTest
class RaisefoodApplicationTests {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private IRaiseService raiseService;
	
	@Test
	public void testGetInProgressRaise() {
		List<Raise> raises = raiseService.getInProgressRaise();
		for(Raise ra : raises) {
			System.out.println(ra.toString());
		}
	}
	
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