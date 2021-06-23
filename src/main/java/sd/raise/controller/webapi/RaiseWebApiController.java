/**
 * 
 */
package sd.raise.controller.webapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sd.raise.dto.RaiseDto;
import sd.raise.model.Organization;
import sd.raise.model.Raise;
import sd.raise.model.User;
import sd.raise.response.ListResponse;
import sd.raise.response.ObjectResponse;
import sd.raise.service.IRaiseService;

/**
 * @author MaJiD
 *
 */
@RestController
@RequestMapping("/api/web/raise")
public class RaiseWebApiController {
	
	@Autowired
	private IRaiseService raiseService;
	
	@GetMapping("/getRaise")
	public ObjectResponse<RaiseDto> getRaise(@RequestParam("raiseId") Long raiseId){
		ObjectResponse<RaiseDto> response;
		response = raiseService.getRaiseById(raiseId);
		return response;
	}
	
	@GetMapping("/takeRaise")
	public ObjectResponse<RaiseDto> takeRaise(@RequestParam("raiseId") Long raiseId){
		ObjectResponse<RaiseDto> response;
		Raise raise = raiseService.getRaiseObjectById(raiseId).getDto();
		Organization org = new Organization();
		org.setId(1L);
		raise.setOrganization(org);
		response = raiseService.assignRaise(raise);
		return response;
	}
	
	@GetMapping("/assignPickUp")
	public ObjectResponse<RaiseDto> assignPickUp(@RequestParam("raiseId") Long raiseId){
		ObjectResponse<RaiseDto> response;
		Raise raise = raiseService.getRaiseObjectById(raiseId).getDto();
		User user = new User();
		user.setId(1L);
		raise.setPickUp(user);
		response = raiseService.assignRaise(raise);
		return response;
	}
	
	@GetMapping("/getNewRaises")
	public ListResponse<RaiseDto> getNewRaises(){
		ListResponse<RaiseDto> response;
		response = raiseService.getAllNewRaises();
		return response;
	}
	
	@GetMapping("/getOrganizationInProgressRaises")
	public ListResponse<RaiseDto> getOrganizationInProgressRaises(){
		Organization org = new Organization();
		org.setId(1L);
		ListResponse<RaiseDto> response;
		response = raiseService.getOrganizationInProgressRaises(org);
		return response;
	}
	
	@GetMapping("/getOrganizationDoneRaises")
	public ListResponse<RaiseDto> getOrganizationDoneRaises(){
		Organization org = new Organization();
		org.setId(1L);
		ListResponse<RaiseDto> response;
		response = raiseService.getOrganizationDoneRaises(org);
		return response;
	}
	
	
	@GetMapping("/getOrganizationCanceledRaises")
	public ListResponse<RaiseDto> getOrganizationCanceledRaises(){
		Organization org = new Organization();
		org.setId(1L);
		ListResponse<RaiseDto> response;
		response = raiseService.getOrganizationCanceledRaises(org);
		return response;
	}
	
	@GetMapping("/getOrganizationRaises")
	public ListResponse<RaiseDto> getOrganizationRaises(){
		Organization org = new Organization();
		org.setId(1L);
		ListResponse<RaiseDto> response;
		response = raiseService.getOrganizationAllRaises(org);
		return response;
	}

}
