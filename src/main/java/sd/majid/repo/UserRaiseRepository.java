/**
 * 
 */
package sd.majid.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sd.majid.model.User;

/**
 * @author majid
 * The interface used for the user
 * 
 */
public interface UserRaiseRepository extends JpaRepository<User, Long> {

}
