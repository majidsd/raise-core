/**
 * 
 */
package sd.majid.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sd.majid.model.Organization;

/**
 * @author MaJiD
 *
 */
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
	
	@Query("FROM Organization where status = ?1")
	public List<Organization> getOrganizationByStatus(Byte status);

}