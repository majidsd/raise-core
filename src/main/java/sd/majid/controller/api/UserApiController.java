/**
 * 
 */
package sd.majid.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sd.majid.dto.UserDto;
import sd.majid.model.User;
import sd.majid.response.BaseResponse;
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
	
	@PostMapping("/save")
	public ObjectResponse<UserDto> saveUser(@RequestBody User user){
		ObjectResponse<UserDto> response = userService.addUser(user);
		return response;
	}
	
	@PutMapping("/update")
	public ObjectResponse<UserDto> updateUser(@RequestBody User user){
		ObjectResponse<UserDto> response = userService.updateUser(user);
		return response;
	}
	
	@PutMapping("/revoke")
	public BaseResponse revokeUser(@RequestBody User user){
		BaseResponse response = userService.revokeUser(user);
		return response;
	}
	
	@PutMapping("/activate")
	public ObjectResponse<UserDto> activateUser(@RequestBody User user){
		ObjectResponse<UserDto> response = userService.activateUser(user);
		return response;
	}
	
	@DeleteMapping("/delete")
	public BaseResponse deleteUser(@RequestBody User user) {
		BaseResponse response = userService.deleteUser(user);
		return response;
	}
}
