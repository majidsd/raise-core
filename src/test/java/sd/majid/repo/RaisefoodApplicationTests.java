package sd.majid.repo;

import java.security.NoSuchAlgorithmException;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sd.majid.model.Raise;
import sd.majid.model.User;
import sd.majid.util.HashData;
import sd.majid.util.UserStatus;

@SpringBootTest
class RaisefoodApplicationTests {
	
	@Autowired
	private RaiseRepository raiseRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void testAddRaise() {
		Raise raise = new Raise();
		raise.setName("Abdalmajid Abdalla");
		raise.setPhone("0123456789");
		raise.setDescription("We have some food for you");
		raise.setLatitude("12");
		raise.setLongitude("21");
		//raise.setStatus(RaiseStatus.NEW);
		raiseRepository.save(raise);
	}
	
	@Test
	public void testAddUser() {
		User user = new User();
		user.setName("Abdalmajid Abdalla");
		user.setUserName("majid");
		user.setPhone("0123456789");
		user.setEmail("majid@test.sudan");
		user.setCreatedAt(new Date());
		user.setUpdatedAt(new Date());
		user.setStatus(UserStatus.ACTIVE.getValue());
		try {
			user.setPassword(HashData.sha1("test"));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		userRepository.save(user);
	}

}
