/**
 * 
 */
package sd.majid.service;

import sd.majid.dto.UserDto;
import sd.majid.model.User;
import sd.majid.response.BaseResponse;
import sd.majid.response.ListResponse;
import sd.majid.response.ObjectResponse;

/**
 * @author majid
 *
 */
public interface IUserService {
	public ListResponse<UserDto> getAllUsers();
	
	public ObjectResponse<UserDto> getUserById(Long userId);
	
	public ObjectResponse<UserDto> addUser(User user);
	
	public ObjectResponse<UserDto> updateUser(User user);
	
	public ObjectResponse<UserDto> activateUser(User user);
	
	public BaseResponse revokeUser(User user);
	
	public BaseResponse deleteUser(User user);
}
