/**
 * 
 */
package sd.majid.service;

import java.util.List;

import sd.majid.model.User;

/**
 * @author majid
 *
 */
public interface IUserService {
	
	public Boolean addUser(User user);
	
	public List<User> getAllUsers();
	
	public User getUserById(Long id);
	
	public User updateUser(User user);
	
	public Boolean deleteUser(User user);

}
