/**
 * 
 */
package sd.raise.service;

import sd.raise.dto.UserDto;
import sd.raise.model.Organization;
import sd.raise.model.User;
import sd.raise.response.ListResponse;
import sd.raise.response.ObjectResponse;

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
