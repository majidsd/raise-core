package sd.majid.serviceImp;

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
	public ObjectResponse<User> addUser(UserDto userDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListResponse<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObjectResponse<User> getUserById(UserDto userDto) {
		ObjectResponse<User> response;
		try {
			response = new ObjectResponse<User>(ResponseEnum.SUCCESS, userRepository.getOne(userDto.getId()));
		} catch (Exception e) {
			response = new ObjectResponse<User>(ResponseEnum.TRY_AGAIN, null);
		}
		return response;
	}

	@Override
	public ObjectResponse<User> activateUser(UserDto userDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObjectResponse<Boolean> revokeUser(UserDto userDto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
