/**
 * 
 */
package sd.majid.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sd.majid.model.Raise;
import sd.majid.model.User;
import sd.majid.util.RaiseStatus;

/**
 * @author MaJiD
 *
 */
public interface RaiseRepository extends JpaRepository<Raise, Long> {
	
	@Query("From Raise where user = ?1")
	public List<Raise> getMyAllRaises(User user);
	
	@Query("From Raise where status != ?1")
	public List<Raise> getRaiseByNotStatus(RaiseStatus status);
	
	@Query("From Raise where status = ?1")
	public List<Raise> getRaiseByStatus(RaiseStatus status);
	
	@Query("From Raise where status = ?1 and user = ?2")
	public List<Raise> getRaiseByUserAndStatus(User user, RaiseStatus status);
	
	@Query("From Raise where status != ?1 and user = ?2")
	public List<Raise> getRaiseByUserAndNotStatus(User user, RaiseStatus status);

}
