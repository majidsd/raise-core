package sd.majid.serviceImp;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sd.majid.dto.RaiseDto;
import sd.majid.model.Organization;
import sd.majid.model.Raise;
import sd.majid.model.User;
import sd.majid.repo.OrganizationRepository;
import sd.majid.repo.RaiseRepository;
import sd.majid.repo.UserRepository;
import sd.majid.response.ListResponse;
import sd.majid.response.ObjectResponse;
import sd.majid.response.ResponseEnum;
import sd.majid.service.IRaiseService;
import sd.majid.util.RaiseStatus;

@Service
public class RaiseServiceImpl implements IRaiseService {

	@Autowired
	private RaiseRepository raiseRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrganizationRepository organizationRepository;

	@Override
	public ObjectResponse<Raise> addRaise(RaiseDto raiseDto) {
		ObjectResponse<Raise> response;
		User user;
		Raise raise;
		try {
			user = userRepository.getOne(raiseDto.getUser_id());
			if(user != null) {
				raise = new Raise();
				raise.setName(raiseDto.getName());
				raise.setPhone(raiseDto.getPhone());
				raise.setStatus(RaiseStatus.NEW.getValue());
				raise.setDescription(raiseDto.getDescription());
				raise.setLatitude(raiseDto.getLatitude());
				raise.setLongitude(raiseDto.getLongitude());
				raise.setCreatedAt(new Date());
				raise.setUpdatedAt(new Date());
				raise.setUser(user);
				response = new ObjectResponse<Raise>(ResponseEnum.SUCCESS, raiseRepository.save(raise));
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
	public ObjectResponse<Raise> getRaiseById(RaiseDto raiseDto) {
		ObjectResponse<Raise> response;
		try {
			response = new ObjectResponse<Raise>(ResponseEnum.SUCCESS, raiseRepository.getOne(raiseDto.getId()));
		} catch (Exception e) {
			e.printStackTrace();
			response = new ObjectResponse<Raise>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}

	@Override
	public ObjectResponse<Raise> cancelRaise(RaiseDto raiseDto) {
		ObjectResponse<Raise> response;
		Raise raise;
		try {
			raise = raiseRepository.getOne(raiseDto.getId());
			if(raise != null) {
				raise.setStatus(RaiseStatus.CANCELED.getValue());
				raise.setUpdatedAt(new Date());
				response = new ObjectResponse<Raise>(ResponseEnum.SUCCESS, raiseRepository.save(raise));
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
	public ObjectResponse<Raise> inProgressRaise(RaiseDto raiseDto) {
		ObjectResponse<Raise> response;
		Raise raise;
		Organization organization;
		try {
			organization = organizationRepository.getOne(raiseDto.getOrganization_id());
			raise = raiseRepository.getOne(raiseDto.getId());
			if(raise != null && organization != null) {
				raise.setStatus(RaiseStatus.IN_PROGRESS.getValue());
				raise.setUpdatedAt(new Date());
				raise.setOrganization(organization);
				response = new ObjectResponse<Raise>(ResponseEnum.SUCCESS, raiseRepository.save(raise));
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
	public ObjectResponse<Raise> completeRaise(RaiseDto raiseDto) {
		ObjectResponse<Raise> response;
		Raise raise;
		try {
			raise = raiseRepository.getOne(raiseDto.getId());
			if(raise != null) {
				raise.setStatus(RaiseStatus.DONE.getValue());
				raise.setUpdatedAt(new Date());
				response = new ObjectResponse<Raise>(ResponseEnum.SUCCESS, raiseRepository.save(raise));
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
	public ListResponse<Raise> getAllRaises() {
		ListResponse<Raise> response;
		try {
			response = new ListResponse<Raise>(ResponseEnum.SUCCESS, raiseRepository.findAll());
		} catch (Exception e) {
			e.printStackTrace();
			response = new ListResponse<Raise>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}

	@Override
	public ListResponse<Raise> getNewRaise() {
		ListResponse<Raise> response;
		try {
			response = new ListResponse<Raise>(ResponseEnum.SUCCESS, raiseRepository.getRaiseByStatus(RaiseStatus.NEW.getValue()));
		} catch (Exception e) {
			e.printStackTrace();
			response = new ListResponse<Raise>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}

	@Override
	public ListResponse<Raise> getDoneRaise() {
		ListResponse<Raise> response;
		try {
			response = new ListResponse<Raise>(ResponseEnum.SUCCESS, raiseRepository.getRaiseByStatus(RaiseStatus.DONE.getValue()));
		} catch (Exception e) {
			e.printStackTrace();
			response = new ListResponse<Raise>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}

	@Override
	public ListResponse<Raise> getNotDoneRaise() {
		ListResponse<Raise> response;
		try {
			response = new ListResponse<Raise>(ResponseEnum.SUCCESS, raiseRepository.getRaiseByNotStatus(RaiseStatus.DONE.getValue()));
		} catch (Exception e) {
			e.printStackTrace();
			response = new ListResponse<Raise>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}

	@Override
	public ListResponse<Raise> getInProgressRaise() {
		ListResponse<Raise> response;
		try {
			response = new ListResponse<Raise>(ResponseEnum.SUCCESS, raiseRepository.getRaiseByStatus(RaiseStatus.IN_PROGRESS.getValue()));
		} catch (Exception e) {
			e.printStackTrace();
			response = new ListResponse<Raise>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}

	@Override
	public ListResponse<Raise> getMyAllRaises(RaiseDto raiseDto) {
		ListResponse<Raise> response;
		User user;
		try {
			user = userRepository.getOne(raiseDto.getUser_id());
			response = new ListResponse<Raise>(ResponseEnum.SUCCESS, raiseRepository.getMyAllRaises(user));
		} catch (Exception e) {
			e.printStackTrace();
			response = new ListResponse<Raise>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}

	@Override
	public ListResponse<Raise> getMyNotDoneRaise(RaiseDto raiseDto) {
		ListResponse<Raise> response;
		User user;
		try {
			user = userRepository.getOne(raiseDto.getUser_id());
			response = new ListResponse<Raise>(ResponseEnum.SUCCESS, raiseRepository.getRaiseByUserAndNotStatus(user, RaiseStatus.DONE.getValue()));
		} catch (Exception e) {
			e.printStackTrace();
			response = new ListResponse<Raise>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}

	@Override
	public ListResponse<Raise> getMyInProgressRaise(RaiseDto raiseDto) {
		ListResponse<Raise> response;
		User user;
		try {
			user = userRepository.getOne(raiseDto.getUser_id());
			response = new ListResponse<Raise>(ResponseEnum.SUCCESS, raiseRepository.getRaiseByUserAndStatus(user, RaiseStatus.IN_PROGRESS.getValue()));
		} catch (Exception e) {
			e.printStackTrace();
			response = new ListResponse<Raise>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}

	@Override
	public ListResponse<Raise> getMyDoneRaise(RaiseDto raiseDto) {
		ListResponse<Raise> response;
		User user;
		try {
			user = userRepository.getOne(raiseDto.getUser_id());
			response = new ListResponse<Raise>(ResponseEnum.SUCCESS, raiseRepository.getRaiseByUserAndStatus(user, RaiseStatus.DONE.getValue()));
		} catch (Exception e) {
			e.printStackTrace();
			response = new ListResponse<Raise>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}

	@Override
	public ListResponse<Raise> getMyNewRaise(RaiseDto raiseDto) {
		ListResponse<Raise> response;
		User user;
		try {
			user = userRepository.getOne(raiseDto.getUser_id());
			response = new ListResponse<Raise>(ResponseEnum.SUCCESS, raiseRepository.getRaiseByUserAndStatus(user, RaiseStatus.NEW.getValue()));
		} catch (Exception e) {
			e.printStackTrace();
			response = new ListResponse<Raise>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}
	

}
