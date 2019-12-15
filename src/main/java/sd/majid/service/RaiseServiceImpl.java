package sd.majid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sd.majid.model.Raise;
import sd.majid.model.User;
import sd.majid.repo.ClinetRaiseRepository;
import sd.majid.util.RaiseStatus;

@Service
public class RaiseServiceImpl implements IRaiseService {

	@Autowired
	private ClinetRaiseRepository clinetRaiseRepository;
	
	@Override
	public Boolean addRaise(Raise raise) {
		try {
			clinetRaiseRepository.save(raise);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Raise> getAllRaises() {
		return clinetRaiseRepository.findAll();
	}
	
	@Override
	public List<Raise> getMyAllRaises(User user) {
		return clinetRaiseRepository.getMyAllRaises(user);
	}
	
	@Override
	public Raise getRaiseById(Long Id) {
		return clinetRaiseRepository.findById(Id).get();
	}

	@Override
	public List<Raise> getNotDoneRaise() {
		return clinetRaiseRepository.getNotDoneRaise(RaiseStatus.DONE);
	}
	
	@Override
	public List<Raise> getMyNotDoneRaise(Long id) {
		return clinetRaiseRepository.getMyNotDoneRaise(RaiseStatus.DONE, id);
	}

	@Override
	public List<Raise> getInProgressRaise() {
		return clinetRaiseRepository.getInProgressRaise(RaiseStatus.IN_PROGRESS);
	}
	
	@Override
	public List<Raise> getMyInProgressRaise(Long id) {
		return clinetRaiseRepository.getMyInProgressRaise(RaiseStatus.IN_PROGRESS, id);
	}

	@Override
	public List<Raise> getDoneRaise() {
		return clinetRaiseRepository.getDoneRaise(RaiseStatus.DONE);
	}
	
	@Override
	public List<Raise> getMyDoneRaise(Long id) {
		return clinetRaiseRepository.getMyDoneRaise(RaiseStatus.DONE, id);
	}

	@Override
	public List<Raise> getNewRaise() {
		return clinetRaiseRepository.getNewRaise(RaiseStatus.NEW);
	}
	
	@Override
	public List<Raise> getMyNewRaise(Long id) {
		return clinetRaiseRepository.getMyNewRaise(RaiseStatus.NEW, id);
	}

	@Override
	public Raise updateRaise(Raise raise) {
		return clinetRaiseRepository.save(raise);
	}

}
