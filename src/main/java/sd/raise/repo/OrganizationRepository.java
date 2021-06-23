/**
 * 
 */
package sd.raise.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sd.raise.model.Organization;
import sd.raise.util.OrganizationStatus;

/**
 * @author MaJiD
 *
 */
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
	
	@Query("FROM Organization where status = ?1")
	public List<Organization> getOrganizationsByStatus(OrganizationStatus status);

}
