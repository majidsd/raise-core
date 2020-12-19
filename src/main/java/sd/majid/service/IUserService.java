/**
 * 
 */
package sd.majid.service;

import sd.majid.dto.UserDto;
import sd.majid.response.ListResponse;
import sd.majid.response.ObjectResponse;

/**
 * @author majid
 *
 */
public interface IUserService {
	
	public ObjectResponse<UserDto> addUser(UserDto userDto);
	
	public ListResponse<UserDto> getAllUsers();
	
	public ObjectResponse<UserDto> getUserById(Long userId);
	
	public ObjectResponse<UserDto> activateUser(UserDto userDto);
	
	public ObjectResponse<Boolean> revokeUser(UserDto userDto);

}
