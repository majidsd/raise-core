/**
 * 
 */
package sd.majid.serviceImp;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sd.majid.dto.OrganizationDto;
import sd.majid.model.Organization;
import sd.majid.model.User;
import sd.majid.repo.OrganizationRepository;
import sd.majid.repo.UserRepository;
import sd.majid.response.ListResponse;
import sd.majid.response.ObjectResponse;
import sd.majid.response.ResponseEnum;
import sd.majid.service.IOrganizationService;
import sd.majid.util.OrganizationStatus;

/**
 * @author MaJiD
 *
 */
@Service
public class OrganizationServiceImp implements IOrganizationService {
	
	@Autowired
	private OrganizationRepository organizationRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public ObjectResponse<Organization> addOrganization(OrganizationDto organizationDto) {
		ObjectResponse<Organization> response;
		Organization organization;
		User user;
		try {
			organization = new Organization();
			user = userRepository.getOne(organizationDto.getCreater_id());
			if(user != null) {
				organization.setName(organizationDto.getName());
				organization.setDescription(organizationDto.getDescription());
				organization.setStatus(OrganizationStatus.ACTIVE.getValue());
				organization.setCreatedAt(new Date());
				organization.setUpdatedAt(new Date());
				organization.setCreatedBy(user);
				organization.setUpdatedBy(user);
				response = new ObjectResponse<Organization>(ResponseEnum.SUCCESS, organizationRepository.save(organization));
			} else {
				response = new ObjectResponse<Organization>(ResponseEnum.ITEM_NOT_FOUND, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new ObjectResponse<Organization>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}

	@Override
	public ObjectResponse<Organization> getOrganizationById(OrganizationDto organizationDto) {
		ObjectResponse<Organization> response;
		Organization organization;
		try {
			organization = organizationRepository.getOne(organizationDto.getId());
			if(organization != null) {
				response = new ObjectResponse<Organization>(ResponseEnum.SUCCESS, organizationRepository.getOne(organizationDto.getId()));
			} else {
				response = new ObjectResponse<Organization>(ResponseEnum.ITEM_NOT_FOUND, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new ObjectResponse<Organization>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}

	@Override
	public ObjectResponse<Organization> declineOrganization(OrganizationDto organizationDto) {
		ObjectResponse<Organization> response;
		Organization organization;
		try {
			organization = organizationRepository.getOne(organizationDto.getId());
			if(organization != null && organization.getStatus() == OrganizationStatus.ACTIVE.getValue()) {
				organization.setStatus(OrganizationStatus.DECLINED.getValue());
				organization.setUpdatedAt(new Date());
				organization.setUpdatedBy(userRepository.getOne(organizationDto.getCreater_id()));
				response = new ObjectResponse<Organization>(ResponseEnum.SUCCESS, organizationRepository.save(organization));
			} else {
				response = new ObjectResponse<Organization>(ResponseEnum.ITEM_NOT_FOUND, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new ObjectResponse<Organization>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}

	@Override
	public ObjectResponse<Organization> activateOrganization(OrganizationDto organizationDto) {
		ObjectResponse<Organization> response;
		Organization organization;
		try {
			organization = organizationRepository.getOne(organizationDto.getId());
			if(organization != null && organization.getStatus() == OrganizationStatus.DECLINED.getValue()) {
				organization.setStatus(OrganizationStatus.ACTIVE.getValue());
				organization.setUpdatedAt(new Date());
				organization.setUpdatedBy(userRepository.getOne(organizationDto.getCreater_id()));
				response = new ObjectResponse<Organization>(ResponseEnum.SUCCESS, organizationRepository.save(organization));
			} else {
				response = new ObjectResponse<Organization>(ResponseEnum.ITEM_NOT_FOUND, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new ObjectResponse<Organization>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}

	@Override
	public ListResponse<Organization> getAllOrganization() {
		ListResponse<Organization> response;
		try {
			response = new ListResponse<Organization>(ResponseEnum.SUCCESS, organizationRepository.findAll());
		} catch (Exception e) {
			e.printStackTrace();
			response = new ListResponse<Organization>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}

	@Override
	public ListResponse<Organization> getAllActiveOrganization() {
		ListResponse<Organization> response;
		try {
			response = new ListResponse<Organization>(ResponseEnum.SUCCESS, organizationRepository.getOrganizationByStatus(OrganizationStatus.ACTIVE.getValue()));
		} catch (Exception e) {
			e.printStackTrace();
			response = new ListResponse<Organization>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}

	@Override
	public ListResponse<Organization> getAllDeclineOrganization() {
		ListResponse<Organization> response;
		try {
			response = new ListResponse<Organization>(ResponseEnum.SUCCESS, organizationRepository.getOrganizationByStatus(OrganizationStatus.DECLINED.getValue()));
		} catch (Exception e) {
			e.printStackTrace();
			response = new ListResponse<Organization>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}

}
