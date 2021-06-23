/**
 * 
 */
package sd.raise.controller.mobileapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sd.raise.dto.UserDto;
import sd.raise.model.User;
import sd.raise.request.CreateUserRequest;
import sd.raise.response.BaseResponse;
import sd.raise.response.ObjectResponse;
import sd.raise.service.IUserService;
import sd.raise.util.UserType;

/**
 * @author MaJiD
 *
 */
@RestController
@RequestMapping("/api/mobile/user")
public class UserMobileApiController {
	
	@Autowired
	private IUserService userService;
	
	@PostMapping("/createUser")
	public ObjectResponse<UserDto> saveUser(@RequestBody CreateUserRequest createUserRequest){
		User user = new User();
		user.setName(createUserRequest.getName());
		user.setPhone(createUserRequest.getPhone());
		user.setEmail(createUserRequest.getEmail());
		user.setUserName(createUserRequest.getUserName());
		user.setPassword(createUserRequest.getPassword());
		user.setType(UserType.valueOf(createUserRequest.getType()));
		ObjectResponse<UserDto> response = userService.addUser(user);
		return response;
	}
	
	@PutMapping("/activate")
	public BaseResponse activateUser(@PathVariable("token") String token){
		User user = userService.getUserObjectById(1L).getDto();
		BaseResponse response = userService.activateUser(user);
		return response;
	}
	
	
	@PutMapping("/update")
	public ObjectResponse<UserDto> updateUser(@RequestBody CreateUserRequest createUserRequest){
		User user = new User();
		ObjectResponse<UserDto> response = userService.updateUserData(user);
		return response;
	}
}
