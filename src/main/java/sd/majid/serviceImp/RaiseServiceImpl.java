package sd.majid.serviceImp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sd.majid.dto.OrganizationDto;
import sd.majid.dto.PickUpUserDto;
import sd.majid.dto.RaiseDto;
import sd.majid.model.Organization;
import sd.majid.model.Raise;
import sd.majid.model.User;
import sd.majid.repo.RaiseRepository;
import sd.majid.response.ListResponse;
import sd.majid.response.ObjectResponse;
import sd.majid.response.ResponseEnum;
import sd.majid.service.IRaiseService;
import sd.majid.util.RaiseStatus;

@Service
public class RaiseServiceImpl implements IRaiseService {

	@Autowired
	private RaiseRepository raiseRepository;

	@Override
	public ObjectResponse<RaiseDto> addRaise(Raise raise) {
		ObjectResponse<RaiseDto> response;
		try {
			raise.setStatus(RaiseStatus.NEW);
			raise.setCreatedAt(new Date());
			raise.setUpdatedAt(new Date());
			
			Raise savedRaise = raiseRepository.save(raise);
			if(savedRaise != null) {
				RaiseDto raiseDto = new RaiseDto();
				raiseDto.setId(savedRaise.getId());
				raiseDto.setName(savedRaise.getName());
				raiseDto.setDescription(savedRaise.getDescription());
				raiseDto.setLatitude(savedRaise.getLatitude());
				raiseDto.setLongitude(savedRaise.getLongitude());
				raiseDto.setPhone(savedRaise.getPhone());
				raiseDto.setStatus(savedRaise.getStatus());
				raiseDto.setCreatedAt(savedRaise.getCreatedAt());
				raiseDto.setUpdatedAt(savedRaise.getUpdatedAt());
				raiseDto.setCreatedById(savedRaise.getCreatedBy().getId());
				response = new ObjectResponse<RaiseDto>(ResponseEnum.SUCCESS, raiseDto);
			} else {
				response = new ObjectResponse<RaiseDto>(ResponseEnum.TRY_AGAIN, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new ObjectResponse<RaiseDto>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}
	
	@Override
	public ObjectResponse<RaiseDto> inProgressRaise(Raise raise) {
		ObjectResponse<RaiseDto> response;
		try {
			raise.setStatus(RaiseStatus.IN_PROGRESS);
			raise.setUpdatedAt(new Date());
			
			Raise savedRaise = raiseRepository.save(raise);
			if(savedRaise != null) {
				RaiseDto raiseDto = new RaiseDto();
				raiseDto.setId(savedRaise.getId());
				raiseDto.setName(savedRaise.getName());
				raiseDto.setDescription(savedRaise.getDescription());
				raiseDto.setLatitude(savedRaise.getLatitude());
				raiseDto.setLongitude(savedRaise.getLongitude());
				raiseDto.setPhone(savedRaise.getPhone());
				raiseDto.setStatus(savedRaise.getStatus());
				raiseDto.setCreatedAt(savedRaise.getCreatedAt());
				raiseDto.setUpdatedAt(savedRaise.getUpdatedAt());
				if(savedRaise.getCreatedBy() != null) {
					raiseDto.setCreatedById(savedRaise.getCreatedBy().getId());
				}
				if(savedRaise.getOrganization() != null) {
					OrganizationDto org = new OrganizationDto();
					org.setId(savedRaise.getId());
					org.setName(savedRaise.getName());
					org.setDescription(savedRaise.getDescription());
					org.setStatus(savedRaise.getOrganization().getStatus());
					org.setCreatedAt(savedRaise.getCreatedAt());
					org.setUpdatedAt(savedRaise.getUpdatedAt());
					raiseDto.setOrganization(org);
				}
				response = new ObjectResponse<RaiseDto>(ResponseEnum.SUCCESS, raiseDto);
			} else {
				response = new ObjectResponse<RaiseDto>(ResponseEnum.TRY_AGAIN, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new ObjectResponse<RaiseDto>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}
	
	@Override
	public ObjectResponse<RaiseDto> assignRaise(Raise raise) {
		ObjectResponse<RaiseDto> response;
		try {
			raise.setUpdatedAt(new Date());
			
			Raise savedRaise = raiseRepository.save(raise);
			if(savedRaise != null) {
				RaiseDto raiseDto = new RaiseDto();
				raiseDto.setId(savedRaise.getId());
				raiseDto.setName(savedRaise.getName());
				raiseDto.setDescription(savedRaise.getDescription());
				raiseDto.setLatitude(savedRaise.getLatitude());
				raiseDto.setLongitude(savedRaise.getLongitude());
				raiseDto.setPhone(savedRaise.getPhone());
				raiseDto.setStatus(savedRaise.getStatus());
				raiseDto.setCreatedAt(savedRaise.getCreatedAt());
				raiseDto.setUpdatedAt(savedRaise.getUpdatedAt());
				if(savedRaise.getCreatedBy() != null) {
					raiseDto.setCreatedById(savedRaise.getCreatedBy().getId());
				}
				if(savedRaise.getOrganization() != null) {
					OrganizationDto org = new OrganizationDto();
					org.setId(savedRaise.getId());
					org.setName(savedRaise.getName());
					org.setDescription(savedRaise.getDescription());
					org.setStatus(savedRaise.getOrganization().getStatus());
					org.setCreatedAt(savedRaise.getCreatedAt());
					org.setUpdatedAt(savedRaise.getUpdatedAt());
					raiseDto.setOrganization(org);
				}
				response = new ObjectResponse<RaiseDto>(ResponseEnum.SUCCESS, raiseDto);
			} else {
				response = new ObjectResponse<RaiseDto>(ResponseEnum.ITEM_NOT_FOUND, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new ObjectResponse<RaiseDto>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}

	@Override
	public ObjectResponse<RaiseDto> completeRaise(Raise raise) {
		ObjectResponse<RaiseDto> response;
		try {
			raise.setStatus(RaiseStatus.DONE);
			raise.setCreatedAt(new Date());;
			
			Raise savedRaise = raiseRepository.save(raise);
			if(savedRaise != null) {
				RaiseDto raiseDto = new RaiseDto();
				raiseDto.setId(savedRaise.getId());
				raiseDto.setName(savedRaise.getName());
				raiseDto.setDescription(savedRaise.getDescription());
				raiseDto.setLatitude(savedRaise.getLatitude());
				raiseDto.setLongitude(savedRaise.getLongitude());
				raiseDto.setPhone(savedRaise.getPhone());
				raiseDto.setStatus(savedRaise.getStatus());
				raiseDto.setCreatedAt(savedRaise.getCreatedAt());
				raiseDto.setUpdatedAt(savedRaise.getUpdatedAt());
				if(savedRaise.getCreatedBy() != null) {
					raiseDto.setCreatedById(savedRaise.getCreatedBy().getId());
				}
				if(savedRaise.getOrganization() != null) {
					OrganizationDto org = new OrganizationDto();
					org.setId(savedRaise.getId());
					org.setName(savedRaise.getName());
					org.setDescription(savedRaise.getDescription());
					org.setStatus(savedRaise.getOrganization().getStatus());
					org.setCreatedAt(savedRaise.getCreatedAt());
					org.setUpdatedAt(savedRaise.getUpdatedAt());
					raiseDto.setOrganization(org);
				}
				response = new ObjectResponse<RaiseDto>(ResponseEnum.SUCCESS, raiseDto);
			} else {
				response = new ObjectResponse<RaiseDto>(ResponseEnum.TRY_AGAIN, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new ObjectResponse<RaiseDto>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}
	
	@Override
	public ObjectResponse<RaiseDto> cancelRaise(Raise raise) {
		ObjectResponse<RaiseDto> response;
		try {
			raise.setStatus(RaiseStatus.CANCELED);
			raise.setCreatedAt(new Date());
			
			Raise savedRaise = raiseRepository.save(raise);
			if(savedRaise != null) {
				RaiseDto raiseDto = new RaiseDto();
				raiseDto.setId(savedRaise.getId());
				raiseDto.setName(savedRaise.getName());
				raiseDto.setDescription(savedRaise.getDescription());
				raiseDto.setLatitude(savedRaise.getLatitude());
				raiseDto.setLongitude(savedRaise.getLongitude());
				raiseDto.setPhone(savedRaise.getPhone());
				raiseDto.setStatus(savedRaise.getStatus());
				raiseDto.setCreatedAt(savedRaise.getCreatedAt());
				raiseDto.setUpdatedAt(savedRaise.getUpdatedAt());
				if(savedRaise.getCreatedBy() != null) {
					raiseDto.setCreatedById(savedRaise.getCreatedBy().getId());
				}
				if(savedRaise.getOrganization() != null) {
					OrganizationDto org = new OrganizationDto();
					org.setId(savedRaise.getId());
					org.setName(savedRaise.getName());
					org.setDescription(savedRaise.getDescription());
					org.setStatus(savedRaise.getOrganization().getStatus());
					org.setCreatedAt(savedRaise.getCreatedAt());
					org.setUpdatedAt(savedRaise.getUpdatedAt());
					raiseDto.setOrganization(org);
				}
				response = new ObjectResponse<RaiseDto>(ResponseEnum.SUCCESS, raiseDto);
			} else {
				response = new ObjectResponse<RaiseDto>(ResponseEnum.TRY_AGAIN, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new ObjectResponse<RaiseDto>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}
	
	
	@Override
	public ObjectResponse<RaiseDto> getRaiseById(Long id) {
		ObjectResponse<RaiseDto> response;
		try {
			Raise savedRaise = raiseRepository.getOne(id);
			if(savedRaise != null) {
				RaiseDto raiseDto = new RaiseDto();
				raiseDto.setId(savedRaise.getId());
				raiseDto.setName(savedRaise.getName());
				raiseDto.setDescription(savedRaise.getDescription());
				raiseDto.setLatitude(savedRaise.getLatitude());
				raiseDto.setLongitude(savedRaise.getLongitude());
				raiseDto.setPhone(savedRaise.getPhone());
				raiseDto.setStatus(savedRaise.getStatus());
				raiseDto.setCreatedAt(savedRaise.getCreatedAt());
				raiseDto.setUpdatedAt(savedRaise.getUpdatedAt());
				if(savedRaise.getCreatedBy() != null) {
					raiseDto.setCreatedById(savedRaise.getCreatedBy().getId());
				}
				if(savedRaise.getOrganization() != null) {
					OrganizationDto org = new OrganizationDto();
					org.setId(savedRaise.getId());
					org.setName(savedRaise.getName());
					org.setDescription(savedRaise.getDescription());
					org.setStatus(savedRaise.getOrganization().getStatus());
					org.setCreatedAt(savedRaise.getCreatedAt());
					org.setUpdatedAt(savedRaise.getUpdatedAt());
					raiseDto.setOrganization(org);
				}
				if(savedRaise.getPickUp() != null) {
					PickUpUserDto pickUp = new PickUpUserDto();
					pickUp.setId(savedRaise.getPickUp().getId());
					pickUp.setName(savedRaise.getPickUp().getName());
					pickUp.setPhone(savedRaise.getPickUp().getPhone());
					if(savedRaise.getPickUp().getOrganization() != null) {
						pickUp.setOrganization(savedRaise.getPickUp().getOrganization().getName());
					}
					raiseDto.setPickUpUser(pickUp);
				}
				response = new ObjectResponse<RaiseDto>(ResponseEnum.SUCCESS, raiseDto);
			} else {
				response = new ObjectResponse<RaiseDto>(ResponseEnum.ITEM_NOT_FOUND, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new ObjectResponse<RaiseDto>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}
	
	
	@Override
	public ObjectResponse<Raise> getRaiseObjectById(Long id) {
		ObjectResponse<Raise> response;
		try {
			Raise savedRaise = raiseRepository.getOne(id);
			if(savedRaise != null) {
				response = new ObjectResponse<Raise>(ResponseEnum.SUCCESS, savedRaise);
			} else {
				response = new ObjectResponse<Raise>(ResponseEnum.ITEM_NOT_FOUND, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new ObjectResponse<Raise>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}
	
	@Override
	public ListResponse<RaiseDto> getOrganizationInProgressRaises(Organization organization) {
		ListResponse<RaiseDto> response;
		try {
			List<Raise> savedRaises = raiseRepository.getOrganizationRaiseByStatus(organization, RaiseStatus.IN_PROGRESS);
			if(savedRaises != null) {
				List<RaiseDto> raiseDtos = new ArrayList<RaiseDto>();
				for(Raise savedRaise : savedRaises) {
					RaiseDto raiseDto = new RaiseDto();
					raiseDto.setId(savedRaise.getId());
					raiseDto.setName(savedRaise.getName());
					raiseDto.setDescription(savedRaise.getDescription());
					raiseDto.setLatitude(savedRaise.getLatitude());
					raiseDto.setLongitude(savedRaise.getLongitude());
					raiseDto.setPhone(savedRaise.getPhone());
					raiseDto.setStatus(savedRaise.getStatus());
					raiseDto.setCreatedAt(savedRaise.getCreatedAt());
					raiseDto.setUpdatedAt(savedRaise.getUpdatedAt());
					if(savedRaise.getCreatedBy() != null) {
						raiseDto.setCreatedById(savedRaise.getCreatedBy().getId());
					}
					if(savedRaise.getOrganization() != null) {
						OrganizationDto org = new OrganizationDto();
						org.setId(savedRaise.getId());
						org.setName(savedRaise.getName());
						org.setDescription(savedRaise.getDescription());
						org.setStatus(savedRaise.getOrganization().getStatus());
						org.setCreatedAt(savedRaise.getCreatedAt());
						org.setUpdatedAt(savedRaise.getUpdatedAt());
						raiseDto.setOrganization(org);
					}
					if(savedRaise.getPickUp() != null) {
						PickUpUserDto pickUp = new PickUpUserDto();
						pickUp.setId(savedRaise.getPickUp().getId());
						pickUp.setName(savedRaise.getPickUp().getName());
						pickUp.setPhone(savedRaise.getPickUp().getPhone());
						if(savedRaise.getPickUp().getOrganization() != null) {
							pickUp.setOrganization(savedRaise.getPickUp().getOrganization().getName());
						}
						raiseDto.setPickUpUser(pickUp);
					}
					raiseDtos.add(raiseDto);
				}
				response = new ListResponse<RaiseDto>(ResponseEnum.SUCCESS, raiseDtos);
			} else {
				response = new ListResponse<RaiseDto>(ResponseEnum.SUCCESS, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new ListResponse<RaiseDto>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}

	@Override
	public ListResponse<RaiseDto> getOrganizationDoneRaises(Organization organization) {
		ListResponse<RaiseDto> response;
		try {
			List<Raise> savedRaises = raiseRepository.getOrganizationRaiseByStatus(organization, RaiseStatus.DONE);
			if(savedRaises != null) {
				List<RaiseDto> raiseDtos = new ArrayList<RaiseDto>();
				for(Raise savedRaise : savedRaises) {
					RaiseDto raiseDto = new RaiseDto();
					raiseDto.setId(savedRaise.getId());
					raiseDto.setName(savedRaise.getName());
					raiseDto.setDescription(savedRaise.getDescription());
					raiseDto.setLatitude(savedRaise.getLatitude());
					raiseDto.setLongitude(savedRaise.getLongitude());
					raiseDto.setPhone(savedRaise.getPhone());
					raiseDto.setStatus(savedRaise.getStatus());
					raiseDto.setCreatedAt(savedRaise.getCreatedAt());
					raiseDto.setUpdatedAt(savedRaise.getUpdatedAt());
					if(savedRaise.getCreatedBy() != null) {
						raiseDto.setCreatedById(savedRaise.getCreatedBy().getId());
					}
					if(savedRaise.getOrganization() != null) {
						OrganizationDto org = new OrganizationDto();
						org.setId(savedRaise.getId());
						org.setName(savedRaise.getName());
						org.setDescription(savedRaise.getDescription());
						org.setStatus(savedRaise.getOrganization().getStatus());
						org.setCreatedAt(savedRaise.getCreatedAt());
						org.setUpdatedAt(savedRaise.getUpdatedAt());
						raiseDto.setOrganization(org);
					}
					if(savedRaise.getPickUp() != null) {
						PickUpUserDto pickUp = new PickUpUserDto();
						pickUp.setId(savedRaise.getPickUp().getId());
						pickUp.setName(savedRaise.getPickUp().getName());
						pickUp.setPhone(savedRaise.getPickUp().getPhone());
						if(savedRaise.getPickUp().getOrganization() != null) {
							pickUp.setOrganization(savedRaise.getPickUp().getOrganization().getName());
						}
						raiseDto.setPickUpUser(pickUp);
					}
					raiseDtos.add(raiseDto);
				}
				response = new ListResponse<RaiseDto>(ResponseEnum.SUCCESS, raiseDtos);
			} else {
				response = new ListResponse<RaiseDto>(ResponseEnum.SUCCESS, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new ListResponse<RaiseDto>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}
	
	@Override
	public ListResponse<RaiseDto> getOrganizationCanceledRaises(Organization organization) {
		ListResponse<RaiseDto> response;
		try {
			List<Raise> savedRaises = raiseRepository.getOrganizationRaiseByStatus(organization, RaiseStatus.CANCELED);
			if(savedRaises != null) {
				List<RaiseDto> raiseDtos = new ArrayList<RaiseDto>();
				for(Raise savedRaise : savedRaises) {
					RaiseDto raiseDto = new RaiseDto();
					raiseDto.setId(savedRaise.getId());
					raiseDto.setName(savedRaise.getName());
					raiseDto.setDescription(savedRaise.getDescription());
					raiseDto.setLatitude(savedRaise.getLatitude());
					raiseDto.setLongitude(savedRaise.getLongitude());
					raiseDto.setPhone(savedRaise.getPhone());
					raiseDto.setStatus(savedRaise.getStatus());
					raiseDto.setCreatedAt(savedRaise.getCreatedAt());
					raiseDto.setUpdatedAt(savedRaise.getUpdatedAt());
					if(savedRaise.getCreatedBy() != null) {
						raiseDto.setCreatedById(savedRaise.getCreatedBy().getId());
					}
					if(savedRaise.getOrganization() != null) {
						OrganizationDto org = new OrganizationDto();
						org.setId(savedRaise.getId());
						org.setName(savedRaise.getName());
						org.setDescription(savedRaise.getDescription());
						org.setStatus(savedRaise.getOrganization().getStatus());
						org.setCreatedAt(savedRaise.getCreatedAt());
						org.setUpdatedAt(savedRaise.getUpdatedAt());
						raiseDto.setOrganization(org);
					}
					if(savedRaise.getPickUp() != null) {
						PickUpUserDto pickUp = new PickUpUserDto();
						pickUp.setId(savedRaise.getPickUp().getId());
						pickUp.setName(savedRaise.getPickUp().getName());
						pickUp.setPhone(savedRaise.getPickUp().getPhone());
						if(savedRaise.getPickUp().getOrganization() != null) {
							pickUp.setOrganization(savedRaise.getPickUp().getOrganization().getName());
						}
						raiseDto.setPickUpUser(pickUp);
					}
					raiseDtos.add(raiseDto);
				}
				response = new ListResponse<RaiseDto>(ResponseEnum.SUCCESS, raiseDtos);
			} else {
				response = new ListResponse<RaiseDto>(ResponseEnum.SUCCESS, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new ListResponse<RaiseDto>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}
	
	@Override
	public ListResponse<RaiseDto> getOrganizationNotDoneRaises(Organization organization) {
		ListResponse<RaiseDto> response;
		try {
			List<Raise> savedRaises = raiseRepository.getOrganizationRaiseByNotStatus(organization, RaiseStatus.DONE);
			if(savedRaises != null) {
				List<RaiseDto> raiseDtos = new ArrayList<RaiseDto>();
				for(Raise savedRaise : savedRaises) {
					RaiseDto raiseDto = new RaiseDto();
					raiseDto.setId(savedRaise.getId());
					raiseDto.setName(savedRaise.getName());
					raiseDto.setDescription(savedRaise.getDescription());
					raiseDto.setLatitude(savedRaise.getLatitude());
					raiseDto.setLongitude(savedRaise.getLongitude());
					raiseDto.setPhone(savedRaise.getPhone());
					raiseDto.setStatus(savedRaise.getStatus());
					raiseDto.setCreatedAt(savedRaise.getCreatedAt());
					raiseDto.setUpdatedAt(savedRaise.getUpdatedAt());
					if(savedRaise.getCreatedBy() != null) {
						raiseDto.setCreatedById(savedRaise.getCreatedBy().getId());
					}
					if(savedRaise.getOrganization() != null) {
						OrganizationDto org = new OrganizationDto();
						org.setId(savedRaise.getId());
						org.setName(savedRaise.getName());
						org.setDescription(savedRaise.getDescription());
						org.setStatus(savedRaise.getOrganization().getStatus());
						org.setCreatedAt(savedRaise.getCreatedAt());
						org.setUpdatedAt(savedRaise.getUpdatedAt());
						raiseDto.setOrganization(org);
					}
					if(savedRaise.getPickUp() != null) {
						PickUpUserDto pickUp = new PickUpUserDto();
						pickUp.setId(savedRaise.getPickUp().getId());
						pickUp.setName(savedRaise.getPickUp().getName());
						pickUp.setPhone(savedRaise.getPickUp().getPhone());
						if(savedRaise.getPickUp().getOrganization() != null) {
							pickUp.setOrganization(savedRaise.getPickUp().getOrganization().getName());
						}
						raiseDto.setPickUpUser(pickUp);
					}
					raiseDtos.add(raiseDto);
				}
				response = new ListResponse<RaiseDto>(ResponseEnum.SUCCESS, raiseDtos);
			} else {
				response = new ListResponse<RaiseDto>(ResponseEnum.SUCCESS, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new ListResponse<RaiseDto>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}
	
	@Override
	public ListResponse<RaiseDto> getOrganizationAllRaises(Organization organization) {
		ListResponse<RaiseDto> response;
		try {
			List<Raise> savedRaises = raiseRepository.getOrganizationRaises(organization);
			if(savedRaises != null) {
				List<RaiseDto> raiseDtos = new ArrayList<RaiseDto>();
				for(Raise savedRaise : savedRaises) {
					RaiseDto raiseDto = new RaiseDto();
					raiseDto.setId(savedRaise.getId());
					raiseDto.setName(savedRaise.getName());
					raiseDto.setDescription(savedRaise.getDescription());
					raiseDto.setLatitude(savedRaise.getLatitude());
					raiseDto.setLongitude(savedRaise.getLongitude());
					raiseDto.setPhone(savedRaise.getPhone());
					raiseDto.setStatus(savedRaise.getStatus());
					raiseDto.setCreatedAt(savedRaise.getCreatedAt());
					raiseDto.setUpdatedAt(savedRaise.getUpdatedAt());
					if(savedRaise.getCreatedBy() != null) {
						raiseDto.setCreatedById(savedRaise.getCreatedBy().getId());
					}
					if(savedRaise.getOrganization() != null) {
						OrganizationDto org = new OrganizationDto();
						org.setId(savedRaise.getId());
						org.setName(savedRaise.getName());
						org.setDescription(savedRaise.getDescription());
						org.setStatus(savedRaise.getOrganization().getStatus());
						org.setCreatedAt(savedRaise.getCreatedAt());
						org.setUpdatedAt(savedRaise.getUpdatedAt());
						raiseDto.setOrganization(org);
					}
					if(savedRaise.getPickUp() != null) {
						PickUpUserDto pickUp = new PickUpUserDto();
						pickUp.setId(savedRaise.getPickUp().getId());
						pickUp.setName(savedRaise.getPickUp().getName());
						pickUp.setPhone(savedRaise.getPickUp().getPhone());
						if(savedRaise.getPickUp().getOrganization() != null) {
							pickUp.setOrganization(savedRaise.getPickUp().getOrganization().getName());
						}
						raiseDto.setPickUpUser(pickUp);
					}
					raiseDtos.add(raiseDto);
				}
				response = new ListResponse<RaiseDto>(ResponseEnum.SUCCESS, raiseDtos);
			} else {
				response = new ListResponse<RaiseDto>(ResponseEnum.SUCCESS, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new ListResponse<RaiseDto>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}

	
	@Override
	public ListResponse<RaiseDto> getUserNewRaises(User user) {
		ListResponse<RaiseDto> response;
		try {
			List<Raise> savedRaises = raiseRepository.getUserRaisesByStatus(user, RaiseStatus.NEW);
			if(savedRaises != null) {
				List<RaiseDto> raiseDtos = new ArrayList<RaiseDto>();
				for(Raise savedRaise : savedRaises) {
					RaiseDto raiseDto = new RaiseDto();
					raiseDto.setId(savedRaise.getId());
					raiseDto.setName(savedRaise.getName());
					raiseDto.setDescription(savedRaise.getDescription());
					raiseDto.setLatitude(savedRaise.getLatitude());
					raiseDto.setLongitude(savedRaise.getLongitude());
					raiseDto.setPhone(savedRaise.getPhone());
					raiseDto.setStatus(savedRaise.getStatus());
					raiseDto.setCreatedAt(savedRaise.getCreatedAt());
					raiseDto.setUpdatedAt(savedRaise.getUpdatedAt());
					if(savedRaise.getCreatedBy() != null) {
						raiseDto.setCreatedById(savedRaise.getCreatedBy().getId());
					}
					if(savedRaise.getOrganization() != null) {
						OrganizationDto org = new OrganizationDto();
						org.setId(savedRaise.getId());
						org.setName(savedRaise.getName());
						org.setDescription(savedRaise.getDescription());
						org.setStatus(savedRaise.getOrganization().getStatus());
						org.setCreatedAt(savedRaise.getCreatedAt());
						org.setUpdatedAt(savedRaise.getUpdatedAt());
						raiseDto.setOrganization(org);
					}
					if(savedRaise.getPickUp() != null) {
						PickUpUserDto pickUp = new PickUpUserDto();
						pickUp.setId(savedRaise.getPickUp().getId());
						pickUp.setName(savedRaise.getPickUp().getName());
						pickUp.setPhone(savedRaise.getPickUp().getPhone());
						if(savedRaise.getPickUp().getOrganization() != null) {
							pickUp.setOrganization(savedRaise.getPickUp().getOrganization().getName());
						}
						raiseDto.setPickUpUser(pickUp);
					}
					raiseDtos.add(raiseDto);
				}
				response = new ListResponse<RaiseDto>(ResponseEnum.SUCCESS, raiseDtos);
			} else {
				response = new ListResponse<RaiseDto>(ResponseEnum.SUCCESS, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new ListResponse<RaiseDto>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}
	
	@Override
	public ListResponse<RaiseDto> getUserInProgressRaises(User user) {
		ListResponse<RaiseDto> response;
		try {
			List<Raise> savedRaises = raiseRepository.getUserRaisesByStatus(user, RaiseStatus.IN_PROGRESS);
			if(savedRaises != null) {
				List<RaiseDto> raiseDtos = new ArrayList<RaiseDto>();
				for(Raise savedRaise : savedRaises) {
					RaiseDto raiseDto = new RaiseDto();
					raiseDto.setId(savedRaise.getId());
					raiseDto.setName(savedRaise.getName());
					raiseDto.setDescription(savedRaise.getDescription());
					raiseDto.setLatitude(savedRaise.getLatitude());
					raiseDto.setLongitude(savedRaise.getLongitude());
					raiseDto.setPhone(savedRaise.getPhone());
					raiseDto.setStatus(savedRaise.getStatus());
					raiseDto.setCreatedAt(savedRaise.getCreatedAt());
					raiseDto.setUpdatedAt(savedRaise.getUpdatedAt());
					if(savedRaise.getCreatedBy() != null) {
						raiseDto.setCreatedById(savedRaise.getCreatedBy().getId());
					}
					if(savedRaise.getOrganization() != null) {
						OrganizationDto org = new OrganizationDto();
						org.setId(savedRaise.getId());
						org.setName(savedRaise.getName());
						org.setDescription(savedRaise.getDescription());
						org.setStatus(savedRaise.getOrganization().getStatus());
						org.setCreatedAt(savedRaise.getCreatedAt());
						org.setUpdatedAt(savedRaise.getUpdatedAt());
						raiseDto.setOrganization(org);
					}
					if(savedRaise.getPickUp() != null) {
						PickUpUserDto pickUp = new PickUpUserDto();
						pickUp.setId(savedRaise.getPickUp().getId());
						pickUp.setName(savedRaise.getPickUp().getName());
						pickUp.setPhone(savedRaise.getPickUp().getPhone());
						if(savedRaise.getPickUp().getOrganization() != null) {
							pickUp.setOrganization(savedRaise.getPickUp().getOrganization().getName());
						}
						raiseDto.setPickUpUser(pickUp);
					}
					raiseDtos.add(raiseDto);
				}
				response = new ListResponse<RaiseDto>(ResponseEnum.SUCCESS, raiseDtos);
			} else {
				response = new ListResponse<RaiseDto>(ResponseEnum.SUCCESS, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new ListResponse<RaiseDto>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}

	@Override
	public ListResponse<RaiseDto> getUserDoneRaises(User user) {
		ListResponse<RaiseDto> response;
		try {
			List<Raise> savedRaises = raiseRepository.getUserRaisesByStatus(user, RaiseStatus.DONE);
			if(savedRaises != null) {
				List<RaiseDto> raiseDtos = new ArrayList<RaiseDto>();
				for(Raise savedRaise : savedRaises) {
					RaiseDto raiseDto = new RaiseDto();
					raiseDto.setId(savedRaise.getId());
					raiseDto.setName(savedRaise.getName());
					raiseDto.setDescription(savedRaise.getDescription());
					raiseDto.setLatitude(savedRaise.getLatitude());
					raiseDto.setLongitude(savedRaise.getLongitude());
					raiseDto.setPhone(savedRaise.getPhone());
					raiseDto.setStatus(savedRaise.getStatus());
					raiseDto.setCreatedAt(savedRaise.getCreatedAt());
					raiseDto.setUpdatedAt(savedRaise.getUpdatedAt());
					if(savedRaise.getCreatedBy() != null) {
						raiseDto.setCreatedById(savedRaise.getCreatedBy().getId());
					}
					if(savedRaise.getOrganization() != null) {
						OrganizationDto org = new OrganizationDto();
						org.setId(savedRaise.getId());
						org.setName(savedRaise.getName());
						org.setDescription(savedRaise.getDescription());
						org.setStatus(savedRaise.getOrganization().getStatus());
						org.setCreatedAt(savedRaise.getCreatedAt());
						org.setUpdatedAt(savedRaise.getUpdatedAt());
						raiseDto.setOrganization(org);
					}
					if(savedRaise.getPickUp() != null) {
						PickUpUserDto pickUp = new PickUpUserDto();
						pickUp.setId(savedRaise.getPickUp().getId());
						pickUp.setName(savedRaise.getPickUp().getName());
						pickUp.setPhone(savedRaise.getPickUp().getPhone());
						if(savedRaise.getPickUp().getOrganization() != null) {
							pickUp.setOrganization(savedRaise.getPickUp().getOrganization().getName());
						}
						raiseDto.setPickUpUser(pickUp);
					}
					raiseDtos.add(raiseDto);
				}
				response = new ListResponse<RaiseDto>(ResponseEnum.SUCCESS, raiseDtos);
			} else {
				response = new ListResponse<RaiseDto>(ResponseEnum.SUCCESS, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new ListResponse<RaiseDto>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}
	
	@Override
	public ListResponse<RaiseDto> getUserCanceledRaises(User user) {
		ListResponse<RaiseDto> response;
		try {
			List<Raise> savedRaises = raiseRepository.getUserRaisesByStatus(user, RaiseStatus.CANCELED);
			if(savedRaises != null) {
				List<RaiseDto> raiseDtos = new ArrayList<RaiseDto>();
				for(Raise savedRaise : savedRaises) {
					RaiseDto raiseDto = new RaiseDto();
					raiseDto.setId(savedRaise.getId());
					raiseDto.setName(savedRaise.getName());
					raiseDto.setDescription(savedRaise.getDescription());
					raiseDto.setLatitude(savedRaise.getLatitude());
					raiseDto.setLongitude(savedRaise.getLongitude());
					raiseDto.setPhone(savedRaise.getPhone());
					raiseDto.setStatus(savedRaise.getStatus());
					raiseDto.setCreatedAt(savedRaise.getCreatedAt());
					raiseDto.setUpdatedAt(savedRaise.getUpdatedAt());
					if(savedRaise.getCreatedBy() != null) {
						raiseDto.setCreatedById(savedRaise.getCreatedBy().getId());
					}
					if(savedRaise.getOrganization() != null) {
						OrganizationDto org = new OrganizationDto();
						org.setId(savedRaise.getId());
						org.setName(savedRaise.getName());
						org.setDescription(savedRaise.getDescription());
						org.setStatus(savedRaise.getOrganization().getStatus());
						org.setCreatedAt(savedRaise.getCreatedAt());
						org.setUpdatedAt(savedRaise.getUpdatedAt());
						raiseDto.setOrganization(org);
					}
					if(savedRaise.getPickUp() != null) {
						PickUpUserDto pickUp = new PickUpUserDto();
						pickUp.setId(savedRaise.getPickUp().getId());
						pickUp.setName(savedRaise.getPickUp().getName());
						pickUp.setPhone(savedRaise.getPickUp().getPhone());
						if(savedRaise.getPickUp().getOrganization() != null) {
							pickUp.setOrganization(savedRaise.getPickUp().getOrganization().getName());
						}
						raiseDto.setPickUpUser(pickUp);
					}
					raiseDtos.add(raiseDto);
				}
				response = new ListResponse<RaiseDto>(ResponseEnum.SUCCESS, raiseDtos);
			} else {
				response = new ListResponse<RaiseDto>(ResponseEnum.SUCCESS, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new ListResponse<RaiseDto>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}
	
	@Override
	public ListResponse<RaiseDto> getUserNotDoneRaises(User user) {
		ListResponse<RaiseDto> response;
		try {
			List<Raise> savedRaises = raiseRepository.getUserRaisesByNotStatus(user, RaiseStatus.DONE);
			if(savedRaises != null) {
				List<RaiseDto> raiseDtos = new ArrayList<RaiseDto>();
				for(Raise savedRaise : savedRaises) {
					RaiseDto raiseDto = new RaiseDto();
					raiseDto.setId(savedRaise.getId());
					raiseDto.setName(savedRaise.getName());
					raiseDto.setDescription(savedRaise.getDescription());
					raiseDto.setLatitude(savedRaise.getLatitude());
					raiseDto.setLongitude(savedRaise.getLongitude());
					raiseDto.setPhone(savedRaise.getPhone());
					raiseDto.setStatus(savedRaise.getStatus());
					raiseDto.setCreatedAt(savedRaise.getCreatedAt());
					raiseDto.setUpdatedAt(savedRaise.getUpdatedAt());
					if(savedRaise.getCreatedBy() != null) {
						raiseDto.setCreatedById(savedRaise.getCreatedBy().getId());
					}
					if(savedRaise.getOrganization() != null) {
						OrganizationDto org = new OrganizationDto();
						org.setId(savedRaise.getId());
						org.setName(savedRaise.getName());
						org.setDescription(savedRaise.getDescription());
						org.setStatus(savedRaise.getOrganization().getStatus());
						org.setCreatedAt(savedRaise.getCreatedAt());
						org.setUpdatedAt(savedRaise.getUpdatedAt());
						raiseDto.setOrganization(org);
					}
					if(savedRaise.getPickUp() != null) {
						PickUpUserDto pickUp = new PickUpUserDto();
						pickUp.setId(savedRaise.getPickUp().getId());
						pickUp.setName(savedRaise.getPickUp().getName());
						pickUp.setPhone(savedRaise.getPickUp().getPhone());
						if(savedRaise.getPickUp().getOrganization() != null) {
							pickUp.setOrganization(savedRaise.getPickUp().getOrganization().getName());
						}
						raiseDto.setPickUpUser(pickUp);
					}
					raiseDtos.add(raiseDto);
				}
				response = new ListResponse<RaiseDto>(ResponseEnum.SUCCESS, raiseDtos);
			} else {
				response = new ListResponse<RaiseDto>(ResponseEnum.SUCCESS, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new ListResponse<RaiseDto>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}
	
	@Override
	public ListResponse<RaiseDto> getUserAllRaises(User user) {
		ListResponse<RaiseDto> response;
		try {
			List<Raise> savedRaises = raiseRepository.getUserRaises(user);
			if(savedRaises != null) {
				List<RaiseDto> raiseDtos = new ArrayList<RaiseDto>();
				for(Raise savedRaise : savedRaises) {
					RaiseDto raiseDto = new RaiseDto();
					raiseDto.setId(savedRaise.getId());
					raiseDto.setName(savedRaise.getName());
					raiseDto.setDescription(savedRaise.getDescription());
					raiseDto.setLatitude(savedRaise.getLatitude());
					raiseDto.setLongitude(savedRaise.getLongitude());
					raiseDto.setPhone(savedRaise.getPhone());
					raiseDto.setStatus(savedRaise.getStatus());
					raiseDto.setCreatedAt(savedRaise.getCreatedAt());
					raiseDto.setUpdatedAt(savedRaise.getUpdatedAt());
					if(savedRaise.getCreatedBy() != null) {
						raiseDto.setCreatedById(savedRaise.getCreatedBy().getId());
					}
					if(savedRaise.getOrganization() != null) {
						OrganizationDto org = new OrganizationDto();
						org.setId(savedRaise.getId());
						org.setName(savedRaise.getName());
						org.setDescription(savedRaise.getDescription());
						org.setStatus(savedRaise.getOrganization().getStatus());
						org.setCreatedAt(savedRaise.getCreatedAt());
						org.setUpdatedAt(savedRaise.getUpdatedAt());
						raiseDto.setOrganization(org);
					}
					if(savedRaise.getPickUp() != null) {
						PickUpUserDto pickUp = new PickUpUserDto();
						pickUp.setId(savedRaise.getPickUp().getId());
						pickUp.setName(savedRaise.getPickUp().getName());
						pickUp.setPhone(savedRaise.getPickUp().getPhone());
						if(savedRaise.getPickUp().getOrganization() != null) {
							pickUp.setOrganization(savedRaise.getPickUp().getOrganization().getName());
						}
						raiseDto.setPickUpUser(pickUp);
					}
					raiseDtos.add(raiseDto);
				}
				response = new ListResponse<RaiseDto>(ResponseEnum.SUCCESS, raiseDtos);
			} else {
				response = new ListResponse<RaiseDto>(ResponseEnum.SUCCESS, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new ListResponse<RaiseDto>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}
	
	
	@Override
	public ListResponse<RaiseDto> getAllNewRaises() {
		ListResponse<RaiseDto> response;
		try {
			List<Raise> savedRaises = raiseRepository.getRaiseByStatus(RaiseStatus.NEW);
			if(savedRaises != null) {
				List<RaiseDto> raiseDtos = new ArrayList<RaiseDto>();
				for(Raise savedRaise : savedRaises) {
					RaiseDto raiseDto = new RaiseDto();
					raiseDto.setId(savedRaise.getId());
					raiseDto.setName(savedRaise.getName());
					raiseDto.setDescription(savedRaise.getDescription());
					raiseDto.setLatitude(savedRaise.getLatitude());
					raiseDto.setLongitude(savedRaise.getLongitude());
					raiseDto.setPhone(savedRaise.getPhone());
					raiseDto.setStatus(savedRaise.getStatus());
					raiseDto.setCreatedAt(savedRaise.getCreatedAt());
					raiseDto.setUpdatedAt(savedRaise.getUpdatedAt());
					if(savedRaise.getCreatedBy() != null) {
						raiseDto.setCreatedById(savedRaise.getCreatedBy().getId());
					}
					if(savedRaise.getOrganization() != null) {
						OrganizationDto org = new OrganizationDto();
						org.setId(savedRaise.getId());
						org.setName(savedRaise.getName());
						org.setDescription(savedRaise.getDescription());
						org.setStatus(savedRaise.getOrganization().getStatus());
						org.setCreatedAt(savedRaise.getCreatedAt());
						org.setUpdatedAt(savedRaise.getUpdatedAt());
						raiseDto.setOrganization(org);
					}
					if(savedRaise.getPickUp() != null) {
						PickUpUserDto pickUp = new PickUpUserDto();
						pickUp.setId(savedRaise.getPickUp().getId());
						pickUp.setName(savedRaise.getPickUp().getName());
						pickUp.setPhone(savedRaise.getPickUp().getPhone());
						if(savedRaise.getPickUp().getOrganization() != null) {
							pickUp.setOrganization(savedRaise.getPickUp().getOrganization().getName());
						}
						raiseDto.setPickUpUser(pickUp);
					}
					raiseDtos.add(raiseDto);
				}
				response = new ListResponse<RaiseDto>(ResponseEnum.SUCCESS, raiseDtos);
			} else {
				response = new ListResponse<RaiseDto>(ResponseEnum.SUCCESS, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new ListResponse<RaiseDto>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}
	
	@Override
	public ListResponse<RaiseDto> getAllInProgressRaises() {
		ListResponse<RaiseDto> response;
		try {
			List<Raise> savedRaises = raiseRepository.getRaiseByStatus(RaiseStatus.IN_PROGRESS);
			if(savedRaises != null) {
				List<RaiseDto> raiseDtos = new ArrayList<RaiseDto>();
				for(Raise savedRaise : savedRaises) {
					RaiseDto raiseDto = new RaiseDto();
					raiseDto.setId(savedRaise.getId());
					raiseDto.setName(savedRaise.getName());
					raiseDto.setDescription(savedRaise.getDescription());
					raiseDto.setLatitude(savedRaise.getLatitude());
					raiseDto.setLongitude(savedRaise.getLongitude());
					raiseDto.setPhone(savedRaise.getPhone());
					raiseDto.setStatus(savedRaise.getStatus());
					raiseDto.setCreatedAt(savedRaise.getCreatedAt());
					raiseDto.setUpdatedAt(savedRaise.getUpdatedAt());
					if(savedRaise.getCreatedBy() != null) {
						raiseDto.setCreatedById(savedRaise.getCreatedBy().getId());
					}
					if(savedRaise.getOrganization() != null) {
						OrganizationDto org = new OrganizationDto();
						org.setId(savedRaise.getId());
						org.setName(savedRaise.getName());
						org.setDescription(savedRaise.getDescription());
						org.setStatus(savedRaise.getOrganization().getStatus());
						org.setCreatedAt(savedRaise.getCreatedAt());
						org.setUpdatedAt(savedRaise.getUpdatedAt());
						raiseDto.setOrganization(org);
					}
					if(savedRaise.getPickUp() != null) {
						PickUpUserDto pickUp = new PickUpUserDto();
						pickUp.setId(savedRaise.getPickUp().getId());
						pickUp.setName(savedRaise.getPickUp().getName());
						pickUp.setPhone(savedRaise.getPickUp().getPhone());
						if(savedRaise.getPickUp().getOrganization() != null) {
							pickUp.setOrganization(savedRaise.getPickUp().getOrganization().getName());
						}
						raiseDto.setPickUpUser(pickUp);
					}
					raiseDtos.add(raiseDto);
				}
				response = new ListResponse<RaiseDto>(ResponseEnum.SUCCESS, raiseDtos);
			} else {
				response = new ListResponse<RaiseDto>(ResponseEnum.SUCCESS, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new ListResponse<RaiseDto>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}

	@Override
	public ListResponse<RaiseDto> getAllDoneRaises() {
		ListResponse<RaiseDto> response;
		try {
			List<Raise> savedRaises = raiseRepository.getRaiseByStatus(RaiseStatus.DONE);
			if(savedRaises != null) {
				List<RaiseDto> raiseDtos = new ArrayList<RaiseDto>();
				for(Raise savedRaise : savedRaises) {
					RaiseDto raiseDto = new RaiseDto();
					raiseDto.setId(savedRaise.getId());
					raiseDto.setName(savedRaise.getName());
					raiseDto.setDescription(savedRaise.getDescription());
					raiseDto.setLatitude(savedRaise.getLatitude());
					raiseDto.setLongitude(savedRaise.getLongitude());
					raiseDto.setPhone(savedRaise.getPhone());
					raiseDto.setStatus(savedRaise.getStatus());
					raiseDto.setCreatedAt(savedRaise.getCreatedAt());
					raiseDto.setUpdatedAt(savedRaise.getUpdatedAt());
					if(savedRaise.getCreatedBy() != null) {
						raiseDto.setCreatedById(savedRaise.getCreatedBy().getId());
					}
					if(savedRaise.getOrganization() != null) {
						OrganizationDto org = new OrganizationDto();
						org.setId(savedRaise.getId());
						org.setName(savedRaise.getName());
						org.setDescription(savedRaise.getDescription());
						org.setStatus(savedRaise.getOrganization().getStatus());
						org.setCreatedAt(savedRaise.getCreatedAt());
						org.setUpdatedAt(savedRaise.getUpdatedAt());
						raiseDto.setOrganization(org);
					}
					if(savedRaise.getPickUp() != null) {
						PickUpUserDto pickUp = new PickUpUserDto();
						pickUp.setId(savedRaise.getPickUp().getId());
						pickUp.setName(savedRaise.getPickUp().getName());
						pickUp.setPhone(savedRaise.getPickUp().getPhone());
						if(savedRaise.getPickUp().getOrganization() != null) {
							pickUp.setOrganization(savedRaise.getPickUp().getOrganization().getName());
						}
						raiseDto.setPickUpUser(pickUp);
					}
					raiseDtos.add(raiseDto);
				}
				response = new ListResponse<RaiseDto>(ResponseEnum.SUCCESS, raiseDtos);
			} else {
				response = new ListResponse<RaiseDto>(ResponseEnum.SUCCESS, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new ListResponse<RaiseDto>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}
	
	@Override
	public ListResponse<RaiseDto> getAllCanceledRaises() {
		ListResponse<RaiseDto> response;
		try {
			List<Raise> savedRaises = raiseRepository.getRaiseByStatus(RaiseStatus.CANCELED);
			if(savedRaises != null) {
				List<RaiseDto> raiseDtos = new ArrayList<RaiseDto>();
				for(Raise savedRaise : savedRaises) {
					RaiseDto raiseDto = new RaiseDto();
					raiseDto.setId(savedRaise.getId());
					raiseDto.setName(savedRaise.getName());
					raiseDto.setDescription(savedRaise.getDescription());
					raiseDto.setLatitude(savedRaise.getLatitude());
					raiseDto.setLongitude(savedRaise.getLongitude());
					raiseDto.setPhone(savedRaise.getPhone());
					raiseDto.setStatus(savedRaise.getStatus());
					raiseDto.setCreatedAt(savedRaise.getCreatedAt());
					raiseDto.setUpdatedAt(savedRaise.getUpdatedAt());
					if(savedRaise.getCreatedBy() != null) {
						raiseDto.setCreatedById(savedRaise.getCreatedBy().getId());
					}
					if(savedRaise.getOrganization() != null) {
						OrganizationDto org = new OrganizationDto();
						org.setId(savedRaise.getId());
						org.setName(savedRaise.getName());
						org.setDescription(savedRaise.getDescription());
						org.setStatus(savedRaise.getOrganization().getStatus());
						org.setCreatedAt(savedRaise.getCreatedAt());
						org.setUpdatedAt(savedRaise.getUpdatedAt());
						raiseDto.setOrganization(org);
					}
					if(savedRaise.getPickUp() != null) {
						PickUpUserDto pickUp = new PickUpUserDto();
						pickUp.setId(savedRaise.getPickUp().getId());
						pickUp.setName(savedRaise.getPickUp().getName());
						pickUp.setPhone(savedRaise.getPickUp().getPhone());
						if(savedRaise.getPickUp().getOrganization() != null) {
							pickUp.setOrganization(savedRaise.getPickUp().getOrganization().getName());
						}
						raiseDto.setPickUpUser(pickUp);
					}
					raiseDtos.add(raiseDto);
				}
				response = new ListResponse<RaiseDto>(ResponseEnum.SUCCESS, raiseDtos);
			} else {
				response = new ListResponse<RaiseDto>(ResponseEnum.SUCCESS, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new ListResponse<RaiseDto>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}
	
	@Override
	public ListResponse<RaiseDto> getAllNotDoneRaises() {
		ListResponse<RaiseDto> response;
		try {
			List<Raise> savedRaises = raiseRepository.getRaiseByNotStatus(RaiseStatus.DONE);
			if(savedRaises != null) {
				List<RaiseDto> raiseDtos = new ArrayList<RaiseDto>();
				for(Raise savedRaise : savedRaises) {
					RaiseDto raiseDto = new RaiseDto();
					raiseDto.setId(savedRaise.getId());
					raiseDto.setName(savedRaise.getName());
					raiseDto.setDescription(savedRaise.getDescription());
					raiseDto.setLatitude(savedRaise.getLatitude());
					raiseDto.setLongitude(savedRaise.getLongitude());
					raiseDto.setPhone(savedRaise.getPhone());
					raiseDto.setStatus(savedRaise.getStatus());
					raiseDto.setCreatedAt(savedRaise.getCreatedAt());
					raiseDto.setUpdatedAt(savedRaise.getUpdatedAt());
					if(savedRaise.getCreatedBy() != null) {
						raiseDto.setCreatedById(savedRaise.getCreatedBy().getId());
					}
					if(savedRaise.getOrganization() != null) {
						OrganizationDto org = new OrganizationDto();
						org.setId(savedRaise.getId());
						org.setName(savedRaise.getName());
						org.setDescription(savedRaise.getDescription());
						org.setStatus(savedRaise.getOrganization().getStatus());
						org.setCreatedAt(savedRaise.getCreatedAt());
						org.setUpdatedAt(savedRaise.getUpdatedAt());
						raiseDto.setOrganization(org);
					}
					if(savedRaise.getPickUp() != null) {
						PickUpUserDto pickUp = new PickUpUserDto();
						pickUp.setId(savedRaise.getPickUp().getId());
						pickUp.setName(savedRaise.getPickUp().getName());
						pickUp.setPhone(savedRaise.getPickUp().getPhone());
						if(savedRaise.getPickUp().getOrganization() != null) {
							pickUp.setOrganization(savedRaise.getPickUp().getOrganization().getName());
						}
						raiseDto.setPickUpUser(pickUp);
					}
					raiseDtos.add(raiseDto);
				}
				response = new ListResponse<RaiseDto>(ResponseEnum.SUCCESS, raiseDtos);
			} else {
				response = new ListResponse<RaiseDto>(ResponseEnum.SUCCESS, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new ListResponse<RaiseDto>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}

	
	@Override
	public ListResponse<RaiseDto> getAllRaises() {
		ListResponse<RaiseDto> response;
		try {
			List<Raise> savedRaises = raiseRepository.findAll();
			if(savedRaises != null) {
				List<RaiseDto> raiseDtos = new ArrayList<RaiseDto>();
				for(Raise savedRaise : savedRaises) {
					RaiseDto raiseDto = new RaiseDto();
					raiseDto.setId(savedRaise.getId());
					raiseDto.setName(savedRaise.getName());
					raiseDto.setDescription(savedRaise.getDescription());
					raiseDto.setLatitude(savedRaise.getLatitude());
					raiseDto.setLongitude(savedRaise.getLongitude());
					raiseDto.setPhone(savedRaise.getPhone());
					raiseDto.setStatus(savedRaise.getStatus());
					raiseDto.setCreatedAt(savedRaise.getCreatedAt());
					raiseDto.setUpdatedAt(savedRaise.getUpdatedAt());
					if(savedRaise.getCreatedBy() != null) {
						raiseDto.setCreatedById(savedRaise.getCreatedBy().getId());
					}
					if(savedRaise.getOrganization() != null) {
						OrganizationDto org = new OrganizationDto();
						org.setId(savedRaise.getId());
						org.setName(savedRaise.getName());
						org.setDescription(savedRaise.getDescription());
						org.setStatus(savedRaise.getOrganization().getStatus());
						org.setCreatedAt(savedRaise.getCreatedAt());
						org.setUpdatedAt(savedRaise.getUpdatedAt());
						raiseDto.setOrganization(org);
					}
					if(savedRaise.getPickUp() != null) {
						PickUpUserDto pickUp = new PickUpUserDto();
						pickUp.setId(savedRaise.getPickUp().getId());
						pickUp.setName(savedRaise.getPickUp().getName());
						pickUp.setPhone(savedRaise.getPickUp().getPhone());
						if(savedRaise.getPickUp().getOrganization() != null) {
							pickUp.setOrganization(savedRaise.getPickUp().getOrganization().getName());
						}
						raiseDto.setPickUpUser(pickUp);
					}
					raiseDtos.add(raiseDto);
				}
				response = new ListResponse<RaiseDto>(ResponseEnum.SUCCESS, raiseDtos);
			} else {
				response = new ListResponse<RaiseDto>(ResponseEnum.SUCCESS, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new ListResponse<RaiseDto>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}
	
}
