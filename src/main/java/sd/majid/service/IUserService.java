/**
 * 
 */
package sd.majid.service;

import sd.majid.dto.UserDto;
import sd.majid.model.Organization;
import sd.majid.model.User;
import sd.majid.response.ListResponse;
import sd.majid.response.ObjectResponse;

/**
 * @author majid
 *
 */
public interface IUserService {
	public ObjectResponse<UserDto> addUser(User user);
	public ObjectResponse<UserDto> activateUser(User user);
	public ObjectResponse<UserDto> revokeUser(User user);
	public ObjectResponse<UserDto> deleteUser(User user);
	public ObjectResponse<UserDto> updateUserData(User user);
	
	public ObjectResponse<UserDto> getUserById(Long id);
	public ObjectResponse<User> getUserObjectById(Long id);
	
	public ListResponse<UserDto> getAllActivateUsers();
	public ListResponse<UserDto> getAllDeclinedUsers();
	public ListResponse<UserDto> getOrganizationUsers(Organization organization);
	public ListResponse<UserDto> getAllUsers();
}
