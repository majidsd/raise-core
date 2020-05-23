/**
 * 
 */
package sd.majid.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sd.majid.dto.OrganizationDto;
import sd.majid.model.Organization;
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
	public void addOrganizationUnitTest() {
		ObjectResponse<Organization> response;
		OrganizationDto organizationDto = new OrganizationDto();
		organizationDto.setName("Majid Org");
		organizationDto.setDescription("To make no one need food.");
		organizationDto.setCreater_id(1L);
		response = organizationService.addOrganization(organizationDto);
		System.out.println(response.getResponseMessage());
	}
	
	@Test
	public void getOrganizationByIdUnitTest() {
		ObjectResponse<Organization> response;
		OrganizationDto organizationDto = new OrganizationDto();
		organizationDto.setId(1L);
		response = organizationService.getOrganizationById(organizationDto);
		System.out.println(response.getResponseMessage() + " - " + response.getDto());
	}
	
	@Test
	public void declineOrganizationUnitTest() {
		ObjectResponse<Organization> response;
		OrganizationDto organizationDto = new OrganizationDto();
		organizationDto.setId(1L);
		organizationDto.setCreater_id(1L);
		response = organizationService.declineOrganization(organizationDto);
		System.out.println(response.getResponseMessage());
	}
	
	@Test
	public void activateOrganizationUnitTest() {
		ObjectResponse<Organization> response;
		OrganizationDto organizationDto = new OrganizationDto();
		organizationDto.setId(1L);
		organizationDto.setCreater_id(1L);
		response = organizationService.activateOrganization(organizationDto);
		System.out.println(response.getResponseMessage());
	}
	
	@Test
	public void getAllOrganizationUnitTest() {
		ListResponse<Organization> response;
		response = organizationService.getAllOrganization();
		System.out.println(response);
	}
	
	@Test
	public void getAllActiveOrganizationUnitTest() {
		ListResponse<Organization> response;
		response = organizationService.getAllActiveOrganization();
		System.out.println(response);
	}
	
	@Test
	public void getAllDeclineOrganizationUnitTest() {
		ListResponse<Organization> response;
		response = organizationService.getAllDeclineOrganization();
		System.out.println(response);
	}
	
}
