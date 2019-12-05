package sd.majid.service;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sd.majid.model.Raise;
import sd.majid.util.RaiseStatus;

@SpringBootTest
public class RaiseFoodApplicationTestsRaiseService {
	
	@Autowired
	private IRaiseService raiseService;
	
	@Test
	public void testAddRaise() {
		Raise raise = new Raise();
		raise.setName("Abdalmajid Abdalla");
		raise.setPhone("0123456788");
		raise.setStatus(RaiseStatus.NEW);
		raise.setLongitude("16");
		raise.setLatitude("20");
		raise.setDescription("The food is here, come to take it.");
		raise.setCreatedAt(new Date());
		System.out.println(raiseService.addRaise(raise));
	}
	
	@Test
	public void testGetAllRaises() {
		List<Raise> raises = raiseService.getAllRaises();
		for(Raise ra : raises) {
			System.out.println(ra.toString());
		}
	}
	
	@Test
	public void testGetRaiseById() {
		Raise ra = raiseService.getRaiseById(1L);
		System.out.println(ra.toString());
	}
	
	@Test
	public void testGetNotDoneRaise() {
		List<Raise> raises = raiseService.getNotDoneRaise();
		for(Raise ra : raises) {
			System.out.println(ra.toString());
		}
	}
	
	@Test
	public void testGetInProgressRaise() {
		List<Raise> raises = raiseService.getInProgressRaise();
		for(Raise ra : raises) {
			System.out.println(ra.toString());
		}
	}
	
	@Test
	public void testGetDoneRaise() {
		List<Raise> raises = raiseService.getDoneRaise();
		for(Raise ra : raises) {
			System.out.println(ra.toString());
		}
	}
	
	@Test
	public void testGetNewRaise() {
		List<Raise> raises = raiseService.getNewRaise();
		for(Raise ra : raises) {
			System.out.println(ra.toString());
		}
	}
	
	@Test
	public void testUpdateRaise() {
		Raise raise = raiseService.getRaiseById(1L);
		raise.setStatus(RaiseStatus.IN_PROGRESS);
		System.out.println(raiseService.updateRaise(raise).toString());
	}
	
}
