/**
 * 
 */
package sd.majid.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sd.majid.dto.OrganizationDto;
import sd.majid.model.Organization;
import sd.majid.model.User;
import sd.majid.response.ListResponse;
import sd.majid.response.ObjectResponse;

/**
 * @author MaJiD
 *
 */

@SpringBootTest
public class OrganizationServiceUnitTests {

	@Autowired
	private IOrganizationService organizationService;
	
	@Test
	public void testAddOrganization() {
		// Assess
		User createdBy = new User();
		createdBy.setId(1L);
		Organization org = new Organization();
		org.setName("Old Org");
		org.setDescription("To collect food.");
		org.setCreatedBy(createdBy);
		
		// Act
		ObjectResponse<OrganizationDto> response;
		response = organizationService.addOrganization(org);
		
		// Assert
		System.out.println(response);
		System.out.println(response.getDto().getName() + " - " + response.getDto().getDescription() + " - " + response.getDto().getStatus());
	}
	
	@Test
	public void testActivateOrganization() {
		// Asses
		User updateBy = new User();
		updateBy.setId(2L);
		Organization org = organizationService.getOrganizationObjectById(5L).getDto();
		org.setUpdatedBy(updateBy);
		
		// Act
		ObjectResponse<OrganizationDto> response;
		response = organizationService.activateOrganization(org);
		
		// Assert
		System.out.println(response);
		System.out.println(response.getDto().getName() + " - " + response.getDto().getDescription() + " - " + response.getDto().getStatus());
	}
	
	@Test
	public void testDeclineOrganization() {
		// Asses
		User updateBy = new User();
		updateBy.setId(2L);
		Organization org = organizationService.getOrganizationObjectById(3L).getDto();
		org.setUpdatedBy(updateBy);
		
		// Act
		ObjectResponse<OrganizationDto> response;
		response = organizationService.declineOrganization(org);
		
		// Assert
		System.out.println(response);
		System.out.println(response.getDto().getName() + " - " + response.getDto().getDescription() + " - " + response.getDto().getStatus());
	}
	
	@Test
	public void testGetOrganizationById() {
		ObjectResponse<OrganizationDto> response;
		response = organizationService.getOrganizationById(1L);
		
		// Assert
		System.out.println(response);
		System.out.println(response.getDto().getName() + " - " + response.getDto().getDescription() + " - " + response.getDto().getStatus());
	}
	
	@Test
	public void testGetOrganizationObjectById() {
		ObjectResponse<Organization> response;
		response = organizationService.getOrganizationObjectById(1L);
		
		// Assert
		System.out.println(response);
		System.out.println(response.getDto().getName() + " - " + response.getDto().getDescription() + " - " + response.getDto().getStatus());
	}
	
	@Test
	public void testGetAllActiveOrganization() {
		ListResponse<OrganizationDto> response;
		response = organizationService.getAllActiveOrganizations();
		
		// Assert
		System.out.println(response);
		for(OrganizationDto dto : response.getDtos()) {
			System.out.println(dto.getName() + " - " + dto.getDescription() + " - " + dto.getStatus());
		}
	}
	
	@Test
	public void testGetAllDeclineOrganization() {
		ListResponse<OrganizationDto> response;
		response = organizationService.getAllDeclinedOrganizations();
		
		// Assert
		System.out.println(response);
		for(OrganizationDto dto : response.getDtos()) {
			System.out.println(dto.getName() + " - " + dto.getDescription() + " - " + dto.getStatus());
		}
	}
	
	@Test
	public void testGetAllOrganization() {
		ListResponse<OrganizationDto> response;
		response = organizationService.getAllOrganizations();
		
		// Assert
		System.out.println(response);
		for(OrganizationDto dto : response.getDtos()) {
			System.out.println(dto.getName() + " - " + dto.getDescription() + " - " + dto.getStatus());
		}
	}
	
}
