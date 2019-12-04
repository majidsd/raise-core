/**
 * 
 */
package sd.majid.service;

import java.util.List;

import sd.majid.model.Raise;

/**
 * @author majid
 *
 */
public interface IRaiseService {
	
	public Boolean addRaise(Raise raise);
	
	public List<Raise> getAllRaises();
	
	public Raise getRaiseById(Long Id);
	
	public List<Raise> getNotDoneRaise();
	
	public List<Raise> getInProgressRaise();
	
	public List<Raise> getDoneRaise();
	
	public List<Raise> getNewRaise();
	
	public Raise updateRaise(Raise raise);

}
