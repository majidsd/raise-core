/**
 * 
 */
package sd.majid.serviceImp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sd.majid.dto.OrganizationDto;
import sd.majid.model.Organization;
import sd.majid.repo.OrganizationRepository;
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

	@Override
	public ObjectResponse<OrganizationDto> addOrganization(Organization organization) {
		ObjectResponse<OrganizationDto> response;
		try {
			organization.setStatus(OrganizationStatus.NEW);
			organization.setCreatedAt(new Date());
			organization.setUpdatedAt(new Date());
			Organization org = organizationRepository.save(organization); // savedOrg
			if(org != null) {
				OrganizationDto dto = new OrganizationDto();
				dto.setId(org.getId());
				dto.setName(org.getName());
				dto.setStatus(org.getStatus());
				dto.setDescription(org.getDescription());
				dto.setCreatedAt(org.getCreatedAt());
				dto.setUpdatedAt(org.getUpdatedAt());
				if(org.getCreatedBy() != null)
					dto.setCreatedBy(org.getCreatedBy().getId());
				if(org.getUpdatedBy() != null)
					dto.setUpdatedBy(org.getUpdatedBy().getId());
				response = new ObjectResponse<OrganizationDto>(ResponseEnum.SUCCESS, dto);
			} else {
				response = new ObjectResponse<OrganizationDto>(ResponseEnum.TRY_AGAIN, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new ObjectResponse<OrganizationDto>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}
	
	@Override
	public ObjectResponse<OrganizationDto> activateOrganization(Organization organization) {
		ObjectResponse<OrganizationDto> response;
		try {
			organization.setStatus(OrganizationStatus.ACTIVE);
			organization.setUpdatedAt(new Date());
			Organization org = organizationRepository.save(organization); // updatedOrg
			if(org != null) {
				OrganizationDto dto = new OrganizationDto();
				dto.setId(org.getId());
				dto.setName(org.getName());
				dto.setStatus(org.getStatus());
				dto.setDescription(org.getDescription());
				dto.setCreatedAt(org.getCreatedAt());
				dto.setUpdatedAt(org.getUpdatedAt());
				if(org.getCreatedBy() != null)
					dto.setCreatedBy(org.getCreatedBy().getId());
				if(org.getUpdatedBy() != null)
					dto.setUpdatedBy(org.getUpdatedBy().getId());
				response = new ObjectResponse<OrganizationDto>(ResponseEnum.SUCCESS, dto);
			} else {
				response = new ObjectResponse<OrganizationDto>(ResponseEnum.TRY_AGAIN, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new ObjectResponse<OrganizationDto>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}
	
	@Override
	public ObjectResponse<OrganizationDto> declineOrganization(Organization organization) {
		ObjectResponse<OrganizationDto> response;
		try {
			organization.setStatus(OrganizationStatus.DECLINED);
			organization.setUpdatedAt(new Date());
			Organization org = organizationRepository.save(organization); // declinedOrg
			if(org != null) {
				OrganizationDto dto = new OrganizationDto();
				dto.setId(org.getId());
				dto.setName(org.getName());
				dto.setStatus(org.getStatus());
				dto.setDescription(org.getDescription());
				dto.setCreatedAt(org.getCreatedAt());
				dto.setUpdatedAt(org.getUpdatedAt());
				if(org.getCreatedBy() != null)
					dto.setCreatedBy(org.getCreatedBy().getId());
				if(org.getUpdatedBy() != null)
					dto.setUpdatedBy(org.getUpdatedBy().getId());
				response = new ObjectResponse<OrganizationDto>(ResponseEnum.SUCCESS, dto);
			} else {
				response = new ObjectResponse<OrganizationDto>(ResponseEnum.TRY_AGAIN, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new ObjectResponse<OrganizationDto>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}

	@Override
	public ObjectResponse<OrganizationDto> getOrganizationById(Long id) {
		ObjectResponse<OrganizationDto> response;
		try {
			Organization org = organizationRepository.getOne(id);
			if(org != null) {
				OrganizationDto dto = new OrganizationDto();
				dto.setId(org.getId());
				dto.setName(org.getName());
				dto.setStatus(org.getStatus());
				dto.setDescription(org.getDescription());
				dto.setCreatedAt(org.getCreatedAt());
				dto.setUpdatedAt(org.getUpdatedAt());
				if(org.getCreatedBy() != null)
					dto.setCreatedBy(org.getCreatedBy().getId());
				if(org.getUpdatedBy() != null)
					dto.setUpdatedBy(org.getUpdatedBy().getId());					
				response = new ObjectResponse<OrganizationDto>(ResponseEnum.SUCCESS, dto);
			} else {
				response = new ObjectResponse<OrganizationDto>(ResponseEnum.ITEM_NOT_FOUND, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new ObjectResponse<OrganizationDto>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}
	
	@Override
	public ObjectResponse<Organization> getOrganizationObjectById(Long id) {
		ObjectResponse<Organization> response;
		Organization organization;
		try {
			organization = organizationRepository.getOne(id);
			if(organization != null) {
				response = new ObjectResponse<Organization>(ResponseEnum.SUCCESS, organization);
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
	public ListResponse<OrganizationDto> getAllActiveOrganizations() {
		ListResponse<OrganizationDto> response;
		try {
			List<Organization> orgs = organizationRepository.getOrganizationsByStatus(OrganizationStatus.ACTIVE);
			if(orgs != null) {
				List<OrganizationDto> orgDtos = new ArrayList<OrganizationDto>();
				for(Organization org : orgs) {
					OrganizationDto dto = new OrganizationDto();
					dto.setId(org.getId());
					dto.setName(org.getName());
					dto.setStatus(org.getStatus());
					dto.setDescription(org.getDescription());
					dto.setCreatedAt(org.getCreatedAt());
					dto.setUpdatedAt(org.getUpdatedAt());
					if(org.getCreatedBy() != null)
						dto.setCreatedBy(org.getCreatedBy().getId());
					if(org.getUpdatedBy() != null)
						dto.setUpdatedBy(org.getUpdatedBy().getId());					
					orgDtos.add(dto);
				}
				response = new ListResponse<OrganizationDto>(ResponseEnum.SUCCESS, orgDtos);
			} else {
				response = new ListResponse<OrganizationDto>(ResponseEnum.SUCCESS, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new ListResponse<OrganizationDto>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}

	@Override
	public ListResponse<OrganizationDto> getAllDeclinedOrganizations() {
		ListResponse<OrganizationDto> response;
		try {
			List<Organization> orgs = organizationRepository.getOrganizationsByStatus(OrganizationStatus.DECLINED);
			if(orgs != null) {
				List<OrganizationDto> orgDtos = new ArrayList<OrganizationDto>();
				for(Organization org : orgs) {
					OrganizationDto dto = new OrganizationDto();
					dto.setId(org.getId());
					dto.setName(org.getName());
					dto.setStatus(org.getStatus());
					dto.setDescription(org.getDescription());
					dto.setCreatedAt(org.getCreatedAt());
					dto.setUpdatedAt(org.getUpdatedAt());
					if(org.getCreatedBy() != null)
						dto.setCreatedBy(org.getCreatedBy().getId());
					if(org.getUpdatedBy() != null)
						dto.setUpdatedBy(org.getUpdatedBy().getId());					
					orgDtos.add(dto);
				}
				response = new ListResponse<OrganizationDto>(ResponseEnum.SUCCESS, orgDtos);
			} else {
				response = new ListResponse<OrganizationDto>(ResponseEnum.SUCCESS, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new ListResponse<OrganizationDto>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}
	
	@Override
	public ListResponse<OrganizationDto> getAllOrganizations() {
		ListResponse<OrganizationDto> response;
		try {
			List<Organization> orgs = organizationRepository.findAll();
			if(orgs != null) {
				List<OrganizationDto> orgDtos = new ArrayList<OrganizationDto>();
				for(Organization org : orgs) {
					OrganizationDto dto = new OrganizationDto();
					dto.setId(org.getId());
					dto.setName(org.getName());
					dto.setStatus(org.getStatus());
					dto.setDescription(org.getDescription());
					dto.setCreatedAt(org.getCreatedAt());
					dto.setUpdatedAt(org.getUpdatedAt());
					if(org.getCreatedBy() != null)
						dto.setCreatedBy(org.getCreatedBy().getId());
					if(org.getUpdatedBy() != null)
						dto.setUpdatedBy(org.getUpdatedBy().getId());					
					orgDtos.add(dto);
				}
				response = new ListResponse<OrganizationDto>(ResponseEnum.SUCCESS, orgDtos);
			} else {
				response = new ListResponse<OrganizationDto>(ResponseEnum.SUCCESS, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new ListResponse<OrganizationDto>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}

}
