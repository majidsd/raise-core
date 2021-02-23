/**
 * 
 */
package sd.majid.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sd.majid.model.Organization;
import sd.majid.model.User;
import sd.majid.util.UserStatus;
import sd.majid.util.UserType;

/**
 * @author MaJiD
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {
	@Query("FROM User where status = ?1")
	public List<User> getUsersByStatus(UserStatus status);
	
	@Query("FROM User where type = ?1")
	public List<User> getUserByType(UserType type);
	
	@Query("FROM User where organization = ?1")
	public List<User> getOrganizationUsers(Organization organization);
}
