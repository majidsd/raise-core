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
 * @author majid
 * The interface used for all actions that done by the client who upload foods
 * 
 */
public interface ClinetRaiseRepository extends JpaRepository<Raise, Long> {
	
	@Query("From Raise where user != ?1")
	public List<Raise> getMyAllRaises(User user);
	
	@Query("From Raise where status != ?1")
	public List<Raise> getNotDoneRaise(Integer status);
	
	@Query("From Raise where status != ?1 and user = ?2")
	public List<Raise> getMyNotDoneRaise(Integer status, Long user);
	
	@Query("From Raise where status = ?1")
	public List<Raise> getInProgressRaise(Integer status);
	
	@Query("From Raise where status = ?1 and user = ?2")
	public List<Raise> getMyInProgressRaise(Integer status, Long user);
	
	@Query("From Raise where status = ?1")
	public List<Raise> getDoneRaise(Integer status);
	
	@Query("From Raise where status = ?1 and user = ?2")
	public List<Raise> getMyDoneRaise(Integer status, Long user);
	
	@Query("From Raise where status = ?1")
	public List<Raise> getNewRaise(Integer status);
	
	@Query("From Raise where status = ?1 and user = ?2")
	public List<Raise> getMyNewRaise(Integer status, Long user);
	
}
