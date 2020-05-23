/**
 * 
 */
package sd.majid.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sd.majid.model.User;

/**
 * @author MaJiD
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
