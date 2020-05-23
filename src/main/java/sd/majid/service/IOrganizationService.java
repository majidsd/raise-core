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
	
	public ObjectResponse<Organization> addOrganization(OrganizationDto organizationDto);
	public ObjectResponse<Organization> getOrganizationById(OrganizationDto organizationDto);
	public ObjectResponse<Organization> declineOrganization(OrganizationDto organizationDto);
	public ObjectResponse<Organization> activateOrganization(OrganizationDto organizationDto);
	public ListResponse<Organization> getAllOrganization();
	public ListResponse<Organization> getAllActiveOrganization();
	public ListResponse<Organization> getAllDeclineOrganization();
}
