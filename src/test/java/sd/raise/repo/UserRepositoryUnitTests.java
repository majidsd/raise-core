/**
 * 
 */
package sd.raise.repo;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sd.raise.model.Organization;
import sd.raise.model.User;
import sd.raise.repo.UserRepository;
import sd.raise.util.HashData;
import sd.raise.util.UserStatus;
import sd.raise.util.UserType;

/**
 * @author MaJiD
 *
 */

@SpringBootTest
public class UserRepositoryUnitTests {

	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void testAddUser() {
		// For updated by user
		User updateUser = new User();
		updateUser.setId(1L);
		
		User user = new User();
		user.setName("Update This");
		user.setUserName("testsd");
		user.setPhone("0123456787");
		user.setEmail("majid@test.com");
		user.setCreatedAt(new Date());
		user.setUpdatedAt(new Date());
		user.setStatus(UserStatus.NEW);
		user.setType(UserType.NGO_FULL);
		user.setUpdatedBy(updateUser);
		user.setCreatedBy(updateUser);
		try {
			user.setPassword(HashData.sha1("test"));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		userRepository.save(user);
	}
	
	@Test
	public void testUpdateUser() {
		User user = userRepository.getOne(3L);
		user.setName("Ahmed Musa");
		Organization org = new Organization();
		org.setId(1L);
		user.setOrganization(org);
		User newUser = userRepository.save(user);
		System.out.println(newUser.getName() + " - " + newUser.getPhone());
	}
	
	
	@Test
	public void testGetUserById() {
		User user = userRepository.getOne(1L);
		System.out.println(user.getName() + " - " + user.getPhone());
	}
	
	@Test
	public void testGetUsersByStatus() {
		List<User> users = userRepository.getUsersByStatus(UserStatus.ACTIVE);
		for(User user : users) {
			System.out.println(user.getName() + " - " + user.getPhone());
		}
	}
	
	@Test
	public void testGetUserByType() {
		List<User> users = userRepository.getUserByType(UserType.ADMIN);
		for(User user : users) {
			System.out.println(user.getName() + " - " + user.getPhone());
		}
	}
	
	@Test
	public void testGetOrganizationUsers() {
		Organization org = new Organization();
		org.setId(1L);
		List<User> users = userRepository.getOrganizationUsers(org);
		for(User user : users) {
			System.out.println(user.getName() + " - " + user.getPhone());
		}
	}
	
	@Test
	public void testGetUsers() {
		List<User> users = userRepository.findAll();
		for(User user : users) {
			System.out.println(user.getName() + " - " + user.getPhone());
		}
	}
}
