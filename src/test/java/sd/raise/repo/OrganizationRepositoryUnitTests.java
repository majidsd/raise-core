/**
 * 
 */
package sd.raise.repo;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sd.raise.model.Organization;
import sd.raise.repo.OrganizationRepository;
import sd.raise.util.OrganizationStatus;

/**
 * @author MaJiD
 *
 */
@SpringBootTest
public class OrganizationRepositoryUnitTests {

	@Autowired
	private OrganizationRepository organizationRepository;
	
	@Test
	public void testAddOrganization() {
		Organization organization = new Organization();
		organization.setName("Update This");
		organization.setDescription("This is a old description.");
		organization.setStatus(OrganizationStatus.NEW);
		organization.setCreatedAt(new Date());
		organization.setUpdatedAt(new Date());
		organization.setCreatedBy(null);
		organization.setUpdatedBy(null);
		organizationRepository.save(organization);
	}
	
	@Test
	public void testUpdateOrganization() {
		Organization org = organizationRepository.getOne(1L);
		org.setName("Fox NGO");
		org.setDescription("This is a new description.");
		org.setUpdatedAt(new Date());
		Organization organization = organizationRepository.save(org);
		System.out.println(organization.getName() + " - " + organization.getDescription());
	}
	
	@Test
	public void testGetOrganizationById() {
		Organization organization = organizationRepository.getOne(1L);
		System.out.println(organization.getName() + " - " + organization.getDescription());
	}
	
	@Test
	public void testGetOrganizationByStatus() {
		List<Organization> organizations = organizationRepository.getOrganizationsByStatus(OrganizationStatus.NEW);
		for(Organization organization : organizations) {
			System.out.println(organization.getName() + " - " + organization.getDescription());
		}
	}
	
	@Test
	public void testGetOrganizations() {
		List<Organization> organizations = organizationRepository.findAll();
		for(Organization organization : organizations) {
			System.out.println(organization.getName() + " - " + organization.getDescription());
		}
	}
	
}
