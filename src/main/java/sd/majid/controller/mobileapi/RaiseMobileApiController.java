/**
 * 
 */
package sd.majid.controller.mobileapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sd.majid.dto.RaiseDto;
import sd.majid.model.Raise;
import sd.majid.model.User;
import sd.majid.request.RaiseRequest;
import sd.majid.response.ListResponse;
import sd.majid.response.ObjectResponse;
import sd.majid.service.IRaiseService;

/**
 * @author MaJiD
 *
 */
@RestController
@RequestMapping("/api/mobile/raise")
public class RaiseMobileApiController {
	@Autowired
	private IRaiseService raiseService;
	
	@PostMapping("/addRaise")
	public ObjectResponse<RaiseDto> addRaise(@RequestBody RaiseRequest raiseRequest){
		Raise raise = new Raise();
		raise.setName(raiseRequest.getName());
		raise.setPhone(raiseRequest.getPhone());
		raise.setDescription(raiseRequest.getDescription());
		raise.setLongitude(raiseRequest.getLongitude());
		raise.setLatitude(raiseRequest.getLatitude());
		ObjectResponse<RaiseDto> response = raiseService.addRaise(raise);
		return response;
	}
	
	@GetMapping("/getRaise")
	public ObjectResponse<RaiseDto> getRaise(@RequestParam("raiseId") Long raiseId){
		ObjectResponse<RaiseDto> response;
		response = raiseService.getRaiseById(raiseId);
		return response;
	}
	
	@GetMapping("/getAssignedRaise")
	public ObjectResponse<RaiseDto> getAssignedRaise(@RequestParam("raiseId") Long raiseId){
		ObjectResponse<RaiseDto> response;
		response = raiseService.getRaiseById(raiseId);
		return response;
	}
	
	@GetMapping("/getAssignedRaises")
	public ListResponse<RaiseDto> getAssignedRaises(@RequestParam("userId") Long userId){
		ListResponse<RaiseDto> response;
		User user = new User();
		user.setId(userId);
		response = raiseService.getAssignedRaisesByPickUpUser(user);
		return response;
	}
}
