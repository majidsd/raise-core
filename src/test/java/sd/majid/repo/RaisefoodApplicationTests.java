package sd.majid.repo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sd.majid.model.Raise;
import sd.majid.model.User;
import sd.majid.util.RaiseStatus;

@SpringBootTest
class RaisefoodApplicationTests {
	
	@Autowired
	private ClinetRaiseRepository clinetRaiseRepository;
	
	@Autowired
	private UserRaiseRepository userRaiseRepository;
	
	@Test
	public void testAddRaise() {
		Raise raise = new Raise();
		raise.setName("Abdalmajid Abdalla");
		raise.setPhone("0123456789");
		raise.setDescription("We have some food for you");
		raise.setLatitude("12");
		raise.setLongitude("21");
		raise.setStatus(RaiseStatus.NEW);
		clinetRaiseRepository.save(raise);
	}
	
	@Test
	public void testAddUser() {
		User user = new User();
		user.setName("Abdalmajid Abdalla");
		user.setUserName("majid");
		user.setPhone("0123456789");
		user.setEmail("majid@test.sudan");
		userRaiseRepository.save(user);
	}

}
