/**
 * 
 */
package sd.majid.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sd.majid.model.Raise;

/**
 * @author majid
 * The interface used for all actions that done by the client who upload foods
 * 
 */
public interface ClinetRaiseRepository extends JpaRepository<Raise, Long> {

}
