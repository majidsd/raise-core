/**
 * 
 */
package sd.majid.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sd.majid.model.Raise;
import sd.majid.model.User;

/**
 * @author MaJiD
 *
 */
public interface RaiseRepository extends JpaRepository<Raise, Long> {
	
	@Query("From Raise where user = ?1")
	public List<Raise> getMyAllRaises(User user);
	
	@Query("From Raise where status != ?1")
	public List<Raise> getRaiseByNotStatus(Byte status);
	
	@Query("From Raise where status = ?1")
	public List<Raise> getRaiseByStatus(Byte status);
	
	@Query("From Raise where status = ?1 and user = ?2")
	public List<Raise> getRaiseByUserAndStatus(User user, Byte status);
	
	@Query("From Raise where status != ?1 and user = ?2")
	public List<Raise> getRaiseByUserAndNotStatus(User user, Byte status);

}
