/**
 * 
 */
package sd.majid.service;

import sd.majid.dto.RaiseDto;
import sd.majid.model.Raise;
import sd.majid.response.ListResponse;
import sd.majid.response.ObjectResponse;

/**
 * @author majid
 *
 */
public interface IRaiseService {
	
	public ObjectResponse<Raise> addRaise(RaiseDto raiseDto);
	public ObjectResponse<Raise> getRaiseById(RaiseDto raiseDto);
	public ObjectResponse<Raise> cancelRaise(RaiseDto raiseDto);
	public ObjectResponse<Raise> inProgressRaise(RaiseDto raiseDto);
	public ObjectResponse<Raise> completeRaise(RaiseDto raiseDto);
	public ListResponse<Raise> getAllRaises();
	public ListResponse<Raise> getNewRaise();
	public ListResponse<Raise> getDoneRaise();
	public ListResponse<Raise> getNotDoneRaise();
	public ListResponse<Raise> getInProgressRaise();
	public ListResponse<Raise> getMyAllRaises(RaiseDto raiseDto);
	public ListResponse<Raise> getMyNotDoneRaise(RaiseDto raiseDto);
	public ListResponse<Raise> getMyInProgressRaise(RaiseDto raiseDto);
	public ListResponse<Raise> getMyDoneRaise(RaiseDto raiseDto);
	public ListResponse<Raise> getMyNewRaise(RaiseDto raiseDto);

}
