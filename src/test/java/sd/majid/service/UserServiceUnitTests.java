/**
 * 
 */
package sd.majid.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sd.majid.dto.UserDto;
import sd.majid.response.ObjectResponse;


/**
 * @author MaJiD
 *
 */
@SpringBootTest
public class UserServiceUnitTests {
	
	@Autowired
	private IUserService userService;
	
	@Test
	public void testGetUser() {
		ObjectResponse<UserDto> userDto = userService.getUserById(1L);
		System.out.println(userDto.toString());
	}
	
}
