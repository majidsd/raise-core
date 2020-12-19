/**
 * 
 */
package sd.majid.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sd.majid.dto.UserDto;
import sd.majid.response.ListResponse;
import sd.majid.response.ObjectResponse;
import sd.majid.service.IUserService;

/**
 * @author MaJiD
 *
 */
@RestController
@RequestMapping("/api/user")
public class UserApiController {
	
	@Autowired
	private IUserService userService;
	
	@GetMapping("/all")
	public ListResponse<UserDto> getAllUsers(){
		ListResponse<UserDto> usersDtos = userService.getAllUsers();
		return usersDtos;
	}
	
	@GetMapping("/get/{userId}")
	public ObjectResponse<UserDto> getUser(@PathVariable("userId") Long userId){
		ObjectResponse<UserDto> response = userService.getUserById(userId);
		return response;
	}
}
