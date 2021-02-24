package sd.majid.serviceImp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sd.majid.dto.UserDto;
import sd.majid.model.Organization;
import sd.majid.model.User;
import sd.majid.repo.UserRepository;
import sd.majid.response.ListResponse;
import sd.majid.response.ObjectResponse;
import sd.majid.response.ResponseEnum;
import sd.majid.service.IUserService;
import sd.majid.util.UserStatus;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public ObjectResponse<UserDto> addUser(User user) {
		ObjectResponse<UserDto> response;
		try {
			user.setCreatedAt(new Date());
			user.setUpdatedAt(new Date());
			user.setStatus(UserStatus.NEW);
			User savedUser = userRepository.save(user);
			if(savedUser != null) {
				UserDto userDto = new UserDto();
				userDto.setId(savedUser.getId());
				userDto.setName(savedUser.getName());
				userDto.setPhone(savedUser.getPhone());
				userDto.setEmail(savedUser.getEmail());
				userDto.setUserName(savedUser.getUserName());
				userDto.setCreatedAt(savedUser.getCreatedAt());
				userDto.setUpdatedAt(savedUser.getUpdatedAt());
				userDto.setStatus(savedUser.getStatus());
				userDto.setType(savedUser.getType());
				if(savedUser.getOrganization() != null)
					userDto.setOrganization(savedUser.getOrganization().getId());
				response = new ObjectResponse<UserDto>(ResponseEnum.SUCCESS, userDto);
			} else {
				response = new ObjectResponse<UserDto>(ResponseEnum.TRY_AGAIN, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new ObjectResponse<UserDto>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}
	
	
	@Override
	public ObjectResponse<UserDto> activateUser(User user) {
		ObjectResponse<UserDto> response;
		try {
			user.setUpdatedAt(new Date());
			user.setStatus(UserStatus.ACTIVE);
			User savedUser = userRepository.save(user);
			if(savedUser != null) {
				UserDto userDto = new UserDto();
				userDto.setId(savedUser.getId());
				userDto.setName(savedUser.getName());
				userDto.setPhone(savedUser.getPhone());
				userDto.setEmail(savedUser.getEmail());
				userDto.setUserName(savedUser.getUserName());
				userDto.setCreatedAt(savedUser.getCreatedAt());
				userDto.setUpdatedAt(savedUser.getUpdatedAt());
				userDto.setStatus(savedUser.getStatus());
				userDto.setType(savedUser.getType());
				if(savedUser.getOrganization() != null)
					userDto.setOrganization(savedUser.getOrganization().getId());
				response = new ObjectResponse<UserDto>(ResponseEnum.SUCCESS, userDto);
			} else {
				response = new ObjectResponse<UserDto>(ResponseEnum.TRY_AGAIN, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new ObjectResponse<UserDto>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}
	
	
	@Override
	public ObjectResponse<UserDto> revokeUser(User user) {
		ObjectResponse<UserDto> response;
		try {
			user.setUpdatedAt(new Date());
			user.setStatus(UserStatus.REVOKED);
			User savedUser = userRepository.save(user);
			if(savedUser != null) {
				UserDto userDto = new UserDto();
				userDto.setId(savedUser.getId());
				userDto.setName(savedUser.getName());
				userDto.setPhone(savedUser.getPhone());
				userDto.setEmail(savedUser.getEmail());
				userDto.setUserName(savedUser.getUserName());
				userDto.setCreatedAt(savedUser.getCreatedAt());
				userDto.setUpdatedAt(savedUser.getUpdatedAt());
				userDto.setStatus(savedUser.getStatus());
				userDto.setType(savedUser.getType());
				if(savedUser.getOrganization() != null)
					userDto.setOrganization(savedUser.getOrganization().getId());
				response = new ObjectResponse<UserDto>(ResponseEnum.SUCCESS, userDto);
			} else {
				response = new ObjectResponse<UserDto>(ResponseEnum.TRY_AGAIN, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new ObjectResponse<UserDto>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}
	
	
	@Override
	public ObjectResponse<UserDto> deleteUser(User user) {
		ObjectResponse<UserDto> response;
		try {
			user.setUpdatedAt(new Date());
			user.setStatus(UserStatus.DELETED);
			User savedUser = userRepository.save(user);
			if(savedUser != null) {
				UserDto userDto = new UserDto();
				userDto.setId(savedUser.getId());
				userDto.setName(savedUser.getName());
				userDto.setPhone(savedUser.getPhone());
				userDto.setEmail(savedUser.getEmail());
				userDto.setUserName(savedUser.getUserName());
				userDto.setCreatedAt(savedUser.getCreatedAt());
				userDto.setUpdatedAt(savedUser.getUpdatedAt());
				userDto.setStatus(savedUser.getStatus());
				userDto.setType(savedUser.getType());
				if(savedUser.getOrganization() != null)
					userDto.setOrganization(savedUser.getOrganization().getId());
				response = new ObjectResponse<UserDto>(ResponseEnum.SUCCESS, userDto);
			} else {
				response = new ObjectResponse<UserDto>(ResponseEnum.TRY_AGAIN, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new ObjectResponse<UserDto>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}
	
	
	@Override
	public ObjectResponse<UserDto> updateUserData(User user) {
		ObjectResponse<UserDto> response;
		try {
			user.setUpdatedAt(new Date());
			User savedUser = userRepository.save(user);
			if(savedUser != null) {
				UserDto userDto = new UserDto();
				userDto.setId(savedUser.getId());
				userDto.setName(savedUser.getName());
				userDto.setPhone(savedUser.getPhone());
				userDto.setEmail(savedUser.getEmail());
				userDto.setUserName(savedUser.getUserName());
				userDto.setCreatedAt(savedUser.getCreatedAt());
				userDto.setUpdatedAt(savedUser.getUpdatedAt());
				userDto.setStatus(savedUser.getStatus());
				userDto.setType(savedUser.getType());
				if(savedUser.getOrganization() != null)
					userDto.setOrganization(savedUser.getOrganization().getId());
				response = new ObjectResponse<UserDto>(ResponseEnum.SUCCESS, userDto);
			} else {
				response = new ObjectResponse<UserDto>(ResponseEnum.TRY_AGAIN, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new ObjectResponse<UserDto>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}

	
	@Override
	public ObjectResponse<UserDto> getUserById(Long id) {
		ObjectResponse<UserDto> response;
		try {
			User savedUser = userRepository.getOne(id);
			if(savedUser != null) {
				UserDto userDto = new UserDto();
				userDto.setId(savedUser.getId());
				userDto.setName(savedUser.getName());
				userDto.setPhone(savedUser.getPhone());
				userDto.setEmail(savedUser.getEmail());
				userDto.setUserName(savedUser.getUserName());
				userDto.setCreatedAt(savedUser.getCreatedAt());
				userDto.setUpdatedAt(savedUser.getUpdatedAt());
				userDto.setStatus(savedUser.getStatus());
				userDto.setType(savedUser.getType());
				if(savedUser.getOrganization() != null)
					userDto.setOrganization(savedUser.getOrganization().getId());
				response = new ObjectResponse<UserDto>(ResponseEnum.SUCCESS, userDto);
			} else {
				response = new ObjectResponse<UserDto>(ResponseEnum.ITEM_NOT_FOUND, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new ObjectResponse<UserDto>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}
	
	
	@Override
	public ObjectResponse<User> getUserObjectById(Long id) {
		ObjectResponse<User> response;
		try {
			User savedUser = userRepository.getOne(id);
			if(savedUser != null) {
				response = new ObjectResponse<User>(ResponseEnum.SUCCESS, savedUser);
			} else {
				response = new ObjectResponse<User>(ResponseEnum.ITEM_NOT_FOUND, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new ObjectResponse<User>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}
	
	
	@Override
	public ListResponse<UserDto> getAllActivateUsers() {
		ListResponse<UserDto> response;
		try {
			List<User> users = userRepository.getUsersByStatus(UserStatus.ACTIVE);
			List<UserDto> usersDtos = new ArrayList<UserDto>();
			for (User user : users) {
				UserDto userDto = new UserDto();
				userDto.setId(user.getId());
				userDto.setName(user.getName());
				userDto.setPhone(user.getPhone());
				userDto.setEmail(user.getEmail());
				userDto.setUserName(user.getUserName());
				userDto.setCreatedAt(user.getCreatedAt());
				userDto.setUpdatedAt(user.getUpdatedAt());
				userDto.setStatus(user.getStatus());
				userDto.setType(user.getType());
				if(user.getOrganization() != null)
					userDto.setOrganization(user.getOrganization().getId());
				usersDtos.add(userDto);
			}
			response = new ListResponse<UserDto>(ResponseEnum.SUCCESS, usersDtos);
		} catch (Exception e) {
			response = new ListResponse<UserDto>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}
	
	
	@Override
	public ListResponse<UserDto> getAllDeclinedUsers() {
		ListResponse<UserDto> response;
		try {
			List<User> users = userRepository.getUsersByStatus(UserStatus.DELETED);
			List<UserDto> usersDtos = new ArrayList<UserDto>();
			for (User user : users) {
				UserDto userDto = new UserDto();
				userDto.setId(user.getId());
				userDto.setName(user.getName());
				userDto.setPhone(user.getPhone());
				userDto.setEmail(user.getEmail());
				userDto.setUserName(user.getUserName());
				userDto.setCreatedAt(user.getCreatedAt());
				userDto.setUpdatedAt(user.getUpdatedAt());
				userDto.setStatus(user.getStatus());
				userDto.setType(user.getType());
				if(user.getOrganization() != null)
					userDto.setOrganization(user.getOrganization().getId());
				usersDtos.add(userDto);
			}
			response = new ListResponse<UserDto>(ResponseEnum.SUCCESS, usersDtos);
		} catch (Exception e) {
			response = new ListResponse<UserDto>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}
	
	
	@Override
	public ListResponse<UserDto> getOrganizationUsers(Organization organization) {
		ListResponse<UserDto> response;
		try {
			List<User> users = userRepository.getOrganizationUsers(organization);
			List<UserDto> usersDtos = new ArrayList<UserDto>();
			for (User user : users) {
				UserDto userDto = new UserDto();
				userDto.setId(user.getId());
				userDto.setName(user.getName());
				userDto.setPhone(user.getPhone());
				userDto.setEmail(user.getEmail());
				userDto.setUserName(user.getUserName());
				userDto.setCreatedAt(user.getCreatedAt());
				userDto.setUpdatedAt(user.getUpdatedAt());
				userDto.setStatus(user.getStatus());
				userDto.setType(user.getType());
				if(user.getOrganization() != null)
					userDto.setOrganization(user.getOrganization().getId());
				usersDtos.add(userDto);
			}
			response = new ListResponse<UserDto>(ResponseEnum.SUCCESS, usersDtos);
		} catch (Exception e) {
			response = new ListResponse<UserDto>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}
	
	@Override
	public ListResponse<UserDto> getAllUsers() {
		ListResponse<UserDto> response;
		try {
			List<User> users = userRepository.findAll();
			List<UserDto> usersDtos = new ArrayList<UserDto>();
			for (User user : users) {
				UserDto userDto = new UserDto();
				userDto.setId(user.getId());
				userDto.setName(user.getName());
				userDto.setPhone(user.getPhone());
				userDto.setEmail(user.getEmail());
				userDto.setUserName(user.getUserName());
				userDto.setCreatedAt(user.getCreatedAt());
				userDto.setUpdatedAt(user.getUpdatedAt());
				userDto.setStatus(user.getStatus());
				userDto.setType(user.getType());
				if(user.getOrganization() != null)
					userDto.setOrganization(user.getOrganization().getId());
				usersDtos.add(userDto);
			}
			response = new ListResponse<UserDto>(ResponseEnum.SUCCESS, usersDtos);
		} catch (Exception e) {
			response = new ListResponse<UserDto>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}
}
