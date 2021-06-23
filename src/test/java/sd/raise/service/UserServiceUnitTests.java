/**
 * 
 */
package sd.raise.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sd.raise.dto.UserDto;
import sd.raise.model.Organization;
import sd.raise.model.User;
import sd.raise.response.ListResponse;
import sd.raise.response.ObjectResponse;
import sd.raise.service.IUserService;
import sd.raise.util.HashData;
import sd.raise.util.UserType;


/**
 * @author MaJiD
 *
 */
@SpringBootTest
public class UserServiceUnitTests {
	
	@Autowired
	private IUserService userService;
	
	@Test
	public void testAddUser() {
		// Asses
		User creater = new User();
		creater.setId(3L);
		Organization org = new Organization();
		org.setId(1L);
		
		User user = new User();
		user.setName("A B");
		user.setPhone("0123455789");
		user.setEmail("majid@t.sd");
		user.setUserName("abc");
		user.setType(UserType.NGO_MANAGEMENT);
		user.setCreatedBy(creater);
		user.setUpdatedBy(creater);
		user.setOrganization(org);
		try {
			user.setPassword(HashData.sha1("sssss"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Act
		ObjectResponse<UserDto> response = userService.addUser(user);
		
		// Assert
		System.out.println(response);
		System.out.println(response.getDto().getName() + " - " + response.getDto().getUserName() + " - " + response.getDto().getEmail() + " - " + response.getDto().getStatus());
	}
	
	
	@Test
	public void testActivateUser() {
		// Asses
		User user = userService.getUserObjectById(2L).getDto();
		
		// Act
		ObjectResponse<UserDto> response = userService.activateUser(user);
		
		// Assert
		System.out.println(response);
		System.out.println(response.getDto().getName() + " - " + response.getDto().getUserName() + " - " + response.getDto().getEmail() + " - " + response.getDto().getStatus());
	}
	
	
	@Test
	public void testRevokeUser() {
		// Asses
		User user = userService.getUserObjectById(3L).getDto();
		
		// Act
		ObjectResponse<UserDto> response = userService.revokeUser(user);
		
		// Assert
		System.out.println(response);
		System.out.println(response.getDto().getName() + " - " + response.getDto().getUserName() + " - " + response.getDto().getEmail() + " - " + response.getDto().getStatus());
	}
	
	
	@Test
	public void testDeleteUser() {
		// Asses
		User user = userService.getUserObjectById(3L).getDto();
		
		// Act
		ObjectResponse<UserDto> response = userService.deleteUser(user);
		
		// Assert
		System.out.println(response);
		System.out.println(response.getDto().getName() + " - " + response.getDto().getUserName() + " - " + response.getDto().getEmail() + " - " + response.getDto().getStatus());
	}
	
	
	@Test
	public void testUpdateUserData() {
		// Asses
		User user = userService.getUserObjectById(1L).getDto();
		user.setName("Abdalmajid A. Ishag");
		
		// Act
		ObjectResponse<UserDto> response = userService.updateUserData(user);
		
		// Assert
		System.out.println(response);
		System.out.println(response.getDto().getName() + " - " + response.getDto().getUserName() + " - " + response.getDto().getEmail() + " - " + response.getDto().getStatus());
	}
	
	
	@Test
	public void testGetUserById() {
		// Act
		ObjectResponse<UserDto> response = userService.getUserById(1L);
		
		// Assert
		System.out.println(response);
		System.out.println(response.getDto().getName() + " - " + response.getDto().getUserName() + " - " + response.getDto().getEmail() + " - " + response.getDto().getStatus());
	}
	
	
	@Test
	public void testGetUserObjectById() {
		// Act
		ObjectResponse<User> response = userService.getUserObjectById(1L);
		
		// Assert
		System.out.println(response);
		System.out.println(response.getDto().getName() + " - " + response.getDto().getUserName() + " - " + response.getDto().getEmail() + " - " + response.getDto().getStatus());
	}
	
	
	@Test
	public void testGetAllActivateUsers() {
		// Act
		ListResponse<UserDto> response = userService.getAllActivateUsers();
		
		// Assert
		System.out.println(response);
		for(UserDto dto : response.getDtos()) {
			System.out.println(dto.getName() + " - " + dto.getUserName() + " - " + dto.getEmail() + " - " + dto.getStatus());
		}
	}
	
	
	@Test
	public void testGetAllDeclinedUsers() {
		// Act
		ListResponse<UserDto> response = userService.getAllDeclinedUsers();
		
		// Assert
		System.out.println(response);
		for(UserDto dto : response.getDtos()) {
			System.out.println(dto.getName() + " - " + dto.getUserName() + " - " + dto.getEmail() + " - " + dto.getStatus());
		}
	}
	
	@Test
	public void testGetOrganizationUsers() {
		// Asses
		Organization organization = new Organization();
		organization.setId(1L);
		
		// Act
		ListResponse<UserDto> response = userService.getOrganizationUsers(organization);
		
		// Assert
		System.out.println(response);
		for(UserDto dto : response.getDtos()) {
			System.out.println(dto.getName() + " - " + dto.getUserName() + " - " + dto.getEmail() + " - " + dto.getStatus());
		}
	}
	
	@Test
	public void testGetAllUsers() {
		// Act
		ListResponse<UserDto> response = userService.getAllUsers();
		
		// Assert
		System.out.println(response);
		for(UserDto dto : response.getDtos()) {
			System.out.println(dto.getName() + " - " + dto.getUserName() + " - " + dto.getEmail() + " - " + dto.getStatus());
		}
	}
}
