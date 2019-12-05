package sd.majid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sd.majid.model.User;
import sd.majid.repo.UserRaiseRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRaiseRepository userRaiseRepository;
	
	@Override
	public Boolean addUser(User user) {
		try {
			userRaiseRepository.save(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<User> getAllUsers() {
		return userRaiseRepository.findAll();
	}

	@Override
	public User getUserById(Long id) {
		return userRaiseRepository.findById(id).get();
	}

	@Override
	public User updateUser(User user) {
		return userRaiseRepository.save(user);
	}

	@Override
	public Boolean deleteUser(User user) {
		try {
			userRaiseRepository.delete(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
