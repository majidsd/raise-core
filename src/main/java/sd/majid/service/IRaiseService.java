/**
 * 
 */
package sd.majid.service;

import java.util.List;

import sd.majid.model.Raise;
import sd.majid.model.User;

/**
 * @author majid
 *
 */
public interface IRaiseService {
	
	public Boolean addRaise(Raise raise);
	
	public List<Raise> getAllRaises();
	
	public List<Raise> getMyAllRaises(User user);
	
	public Raise getRaiseById(Long Id);
	
	public List<Raise> getNotDoneRaise();
	
	public List<Raise> getMyNotDoneRaise(Long id);
	
	public List<Raise> getInProgressRaise();
	
	public List<Raise> getMyInProgressRaise(Long id);
	
	public List<Raise> getDoneRaise();
	
	public List<Raise> getMyDoneRaise(Long id);
	
	public List<Raise> getNewRaise();
	
	public List<Raise> getMyNewRaise(Long id);
	
	public Raise updateRaise(Raise raise);

}
