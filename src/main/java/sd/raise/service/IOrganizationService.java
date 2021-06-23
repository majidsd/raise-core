/**
 * 
 */
package sd.raise.service;

import sd.raise.dto.OrganizationDto;
import sd.raise.model.Organization;
import sd.raise.response.ListResponse;
import sd.raise.response.ObjectResponse;

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
