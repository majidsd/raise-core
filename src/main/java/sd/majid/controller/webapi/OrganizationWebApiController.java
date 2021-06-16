/**
 * 
 */
package sd.majid.controller.webapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sd.majid.dto.OrganizationDto;
import sd.majid.model.Organization;
import sd.majid.request.CreateOrganizationRequest;
import sd.majid.response.ObjectResponse;
import sd.majid.service.IOrganizationService;

/**
 * @author MaJiD
 *
 */
@RestController
@RequestMapping("/api/web/organization")
public class OrganizationWebApiController {
	@Autowired
	private IOrganizationService organizationService;
	
	@PostMapping("/addOrganization")
	public ObjectResponse<OrganizationDto> addOrganization(@RequestBody CreateOrganizationRequest createOrganizationRequest){
		ObjectResponse<OrganizationDto> response;
		
		Organization org = new Organization();
		org.setName(createOrganizationRequest.getName());
		org.setDescription(createOrganizationRequest.getDescription());
		
		response = organizationService.addOrganization(org);
		return response;
	}
	
	@GetMapping("/activateOrganization")
	public ObjectResponse<OrganizationDto> activateOrganization(){
		ObjectResponse<OrganizationDto> response;
		
		Organization organization = organizationService.getOrganizationObjectById(6L).getDto();
		
		response = organizationService.activateOrganization(organization);
		return response;
	}
	
	@GetMapping("/declineOrganization")
	public ObjectResponse<OrganizationDto> declineOrganization(){
		ObjectResponse<OrganizationDto> response;
		
		Organization organization = organizationService.getOrganizationObjectById(5L).getDto();
		
		response = organizationService.declineOrganization(organization);
		return response;
	}
	
	@GetMapping("/deleteOrganization")
	public ObjectResponse<OrganizationDto> deleteOrganization(){
		ObjectResponse<OrganizationDto> response;
		
		Organization organization = organizationService.getOrganizationObjectById(7L).getDto();
		
		response = organizationService.deleteOrganization(organization);
		return response;
	}
}
