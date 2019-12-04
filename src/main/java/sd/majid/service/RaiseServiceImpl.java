package sd.majid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import sd.majid.model.Raise;
import sd.majid.repo.ClinetRaiseRepository;
import sd.majid.util.RaiseStatus;

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
	public Raise getRaiseById(Long Id) {
		return clinetRaiseRepository.findById(Id).get();
	}

	@Override
	public List<Raise> getNotDoneRaise() {
		return clinetRaiseRepository.getNotDoneRaise(RaiseStatus.DONE);
	}

	@Override
	public List<Raise> getInProgressRaise() {
		return clinetRaiseRepository.getInProgressRaise(RaiseStatus.IN_PROGRESS);
	}

	@Override
	public List<Raise> getDoneRaise() {
		return clinetRaiseRepository.getDoneRaise(RaiseStatus.DONE);
	}

	@Override
	public List<Raise> getNewRaise() {
		return clinetRaiseRepository.getNewRaise(RaiseStatus.NEW);
	}

}
