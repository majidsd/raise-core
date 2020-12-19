package sd.majid.serviceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sd.majid.dto.UserDto;
import sd.majid.model.User;
import sd.majid.repo.UserRepository;
import sd.majid.response.ListResponse;
import sd.majid.response.ObjectResponse;
import sd.majid.response.ResponseEnum;
import sd.majid.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public ObjectResponse<UserDto> addUser(UserDto userDto) {
		// TODO Auto-generated method stub
		return null;
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
				userDto.setCreatedAt(user.getCreatedAt());
				userDto.setUpdatedAt(user.getUpdatedAt());
				userDto.setStatus(user.getStatus());
				usersDtos.add(userDto);
			}
			response = new ListResponse<UserDto>(ResponseEnum.SUCCESS, usersDtos);
		} catch (Exception e) {
			response = new ListResponse<UserDto>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}

	@Override
	public ObjectResponse<UserDto> getUserById(Long userId) {
		ObjectResponse<UserDto> response;
		try {
			User user = userRepository.getOne(userId);
			UserDto userDto = new UserDto();
			userDto.setId(user.getId());
			userDto.setName(user.getName());
			userDto.setPhone(user.getPhone());
			userDto.setEmail(user.getEmail());
			userDto.setCreatedAt(user.getCreatedAt());
			userDto.setUpdatedAt(user.getUpdatedAt());
			userDto.setStatus(user.getStatus());
			userDto.setName(user.getName());
			response = new ObjectResponse<UserDto>(ResponseEnum.SUCCESS, userDto);
		} catch (Exception e) {
			e.printStackTrace();
			response = new ObjectResponse<UserDto>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}

	@Override
	public ObjectResponse<UserDto> activateUser(UserDto userDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObjectResponse<Boolean> revokeUser(UserDto userDto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
