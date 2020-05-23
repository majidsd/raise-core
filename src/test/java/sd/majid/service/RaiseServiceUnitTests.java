package sd.majid.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sd.majid.dto.RaiseDto;
import sd.majid.model.Raise;
import sd.majid.response.ListResponse;
import sd.majid.response.ObjectResponse;

@SpringBootTest
public class RaiseServiceUnitTests {
	
	@Autowired
	private IRaiseService raiseService;
	
	@Test
	public void testAddRaiseUnitTest() {
		RaiseDto raiseDto = new RaiseDto();
		raiseDto.setName("Abdalmajid Abdalla");
		raiseDto.setPhone("0912134212");
		raiseDto.setLatitude("30");
		raiseDto.setLongitude("30");
		raiseDto.setDescription("I have food for you.");
		raiseDto.setUser_id(1L);
		
		ObjectResponse<Raise> response = raiseService.addRaise(raiseDto);
		System.out.println(response);
	}
	
	@Test
	public void getRaiseByIdUnitTest() {
		RaiseDto raiseDto = new RaiseDto();
		raiseDto.setId(1L);
		ObjectResponse<Raise> response = raiseService.getRaiseById(raiseDto);
		System.out.println(response.getResponseMessage());
	}
	
	@Test
	public void cancelRaiseUnitTest() {
		RaiseDto raiseDto = new RaiseDto();
		raiseDto.setId(2L);
		ObjectResponse<Raise> response = raiseService.cancelRaise(raiseDto);
		System.out.println(response.getResponseMessage());
	}
	
	@Test
	public void inProgressRaiseRaiseUnitTest() {
		RaiseDto raiseDto = new RaiseDto();
		raiseDto.setId(2L);
		raiseDto.setOrganization_id(1L);
		ObjectResponse<Raise> response = raiseService.inProgressRaise(raiseDto);
		System.out.println(response.getResponseMessage());
	}
	
	@Test
	public void completeRaiseRaiseRaiseUnitTest() {
		RaiseDto raiseDto = new RaiseDto();
		raiseDto.setId(3L);
		ObjectResponse<Raise> response = raiseService.completeRaise(raiseDto);
		System.out.println(response.getResponseMessage());
	}
	
	@Test
	public void testGetAllRaisesUnitTest() {
		ListResponse<Raise> response = raiseService.getAllRaises();
		System.out.println(response.getResponseMessage() + " - " + response.getDtos());
	}
	
	@Test
	public void getNewRaiseUnitTest() {
		ListResponse<Raise> response = raiseService.getNewRaise();
		System.out.println(response.getResponseMessage() + " - " + response.getDtos());
	}
	
	@Test
	public void getDoneRaiseUnitTest() {
		ListResponse<Raise> response = raiseService.getDoneRaise();
		System.out.println(response.getResponseMessage() + " - " + response.getDtos());
	}
	
	@Test
	public void getNotDoneRaiseUnitTest() {
		ListResponse<Raise> response = raiseService.getNotDoneRaise();
		System.out.println(response);
	}
	
	@Test
	public void getInProgressRaiseUnitTest() {
		ListResponse<Raise> response = raiseService.getInProgressRaise();
		System.out.println(response);
	}
	
	@Test
	public void getMyAllRaisesUnitTest() {
		RaiseDto raiseDto = new RaiseDto();
		raiseDto.setUser_id(1L);
		ListResponse<Raise> response = raiseService.getMyAllRaises(raiseDto);
		System.out.println(response.getResponseMessage());
	}
	
	@Test
	public void getMyNotDoneRaiseUnitTest() {
		RaiseDto raiseDto = new RaiseDto();
		raiseDto.setUser_id(1L);
		ListResponse<Raise> response = raiseService.getMyNotDoneRaise(raiseDto);
		System.out.println(response.getResponseMessage());
	}
	
	@Test
	public void getMyInProgressRaiseUnitTest() {
		RaiseDto raiseDto = new RaiseDto();
		raiseDto.setUser_id(1L);
		ListResponse<Raise> response = raiseService.getMyInProgressRaise(raiseDto);
		System.out.println(response.getResponseMessage());
	}
	
	@Test
	public void getMyDoneRaiseUnitTest() {
		RaiseDto raiseDto = new RaiseDto();
		raiseDto.setUser_id(1L);
		ListResponse<Raise> response = raiseService.getMyDoneRaise(raiseDto);
		System.out.println(response.getResponseMessage());
	}
	
	@Test
	public void getMyNewRaiseUnitTest() {
		RaiseDto raiseDto = new RaiseDto();
		raiseDto.setUser_id(1L);
		ListResponse<Raise> response = raiseService.getMyNewRaise(raiseDto);
		System.out.println(response.getResponseMessage());
	}
	
}
