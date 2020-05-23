/**
 * 
 */
package sd.majid.service;

import sd.majid.dto.UserDto;
import sd.majid.model.User;
import sd.majid.response.ListResponse;
import sd.majid.response.ObjectResponse;

/**
 * @author majid
 *
 */
public interface IUserService {
	
	public ObjectResponse<User> addUser(UserDto userDto);
	
	public ListResponse<User> getAllUsers();
	
	public ObjectResponse<User> getUserById(UserDto userDto);
	
	public ObjectResponse<User> activateUser(UserDto userDto);
	
	public ObjectResponse<Boolean> revokeUser(UserDto userDto);

}
