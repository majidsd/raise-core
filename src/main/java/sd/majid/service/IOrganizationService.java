/**
 * 
 */
package sd.majid.service;

import sd.majid.dto.OrganizationDto;
import sd.majid.model.Organization;
import sd.majid.response.ListResponse;
import sd.majid.response.ObjectResponse;

/**
 * @author MaJiD
 *
 */
public interface IOrganizationService {
	
	public ObjectResponse<OrganizationDto> addOrganization(Organization organization);
	public ObjectResponse<OrganizationDto> activateOrganization(Organization organization);
	public ObjectResponse<OrganizationDto> declineOrganization(Organization organization);
	public ObjectResponse<OrganizationDto> deleteOrganization(Organization organization);
	
	public ObjectResponse<OrganizationDto> getOrganizationById(Long id);
	public ObjectResponse<Organization> getOrganizationObjectById(Long id);
	
	public ListResponse<OrganizationDto> getAllActiveOrganizations();
	public ListResponse<OrganizationDto> getAllDeclinedOrganizations();
	public ListResponse<OrganizationDto> getAllOrganizations();
}
