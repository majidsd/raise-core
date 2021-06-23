/**
 * 
 */
package sd.raise.controller.webapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sd.raise.dto.UserDto;
import sd.raise.model.Organization;
import sd.raise.model.User;
import sd.raise.response.BaseResponse;
import sd.raise.response.ListResponse;
import sd.raise.response.ObjectResponse;
import sd.raise.service.IUserService;

/**
 * @author MaJiD
 *
 */
@RestController
@RequestMapping("/api/web/user")
public class UserWebApiController {
	
	@Autowired
	private IUserService userService;
	
	@GetMapping("/getUser")
	public ObjectResponse<UserDto> getUser(@RequestParam("userId") Long userId){
		ObjectResponse<UserDto> response = userService.getUserById(userId);
		return response;
	}
	
	@PutMapping("/revokeUser")
	public BaseResponse revokeUser(@RequestBody User user){
		BaseResponse response = userService.revokeUser(user);
		return response;
	}
	
	@DeleteMapping("/deleteUser")
	public BaseResponse deleteUser(@RequestBody User user) {
		BaseResponse response = userService.deleteUser(user);
		return response;
	}
	
	@GetMapping("/getOrganizationUsers")
	public ListResponse<UserDto> getOrganizationUsers(){
		Organization org = new Organization();
		org.setId(1L);
		ListResponse<UserDto> usersDtos = userService.getOrganizationUsers(org);
		return usersDtos;
	}
	
	@GetMapping("/getAllUsers")
	public ListResponse<UserDto> getAllUsers(){
		ListResponse<UserDto> usersDtos = userService.getAllUsers();
		return usersDtos;
	}

}
