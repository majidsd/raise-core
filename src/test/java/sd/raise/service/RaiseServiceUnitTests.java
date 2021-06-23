package sd.raise.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sd.raise.dto.RaiseDto;
import sd.raise.model.Organization;
import sd.raise.model.Raise;
import sd.raise.model.User;
import sd.raise.response.ListResponse;
import sd.raise.response.ObjectResponse;
import sd.raise.service.IRaiseService;

@SpringBootTest
public class RaiseServiceUnitTests {
	
	@Autowired
	private IRaiseService raiseService;
	
	@Test
	public void testAddRaise() {
		
		// Arrange
		Raise raise = new Raise();
		User createdBy = new User();
		createdBy.setId(1L);
		
		raise.setName("Mohammed Salah");
		raise.setPhone("0123456712");
		raise.setLatitude("20");
		raise.setLongitude("30");
		raise.setDescription("I have food for 200 person in my home.");
		raise.setCreatedBy(createdBy);
		
		// Act
		ObjectResponse<RaiseDto> response = raiseService.addRaise(raise);
		
		// Assert
		System.out.println(response);
		System.out.println(response.getDto().getName() + " - " + response.getDto().getDescription() + " - " + response.getDto().getPhone() + " - " + response.getDto().getStatus());
	}
	
	@Test
	public void testInProgressRaise() {
		// Arrange
		Raise raise = raiseService.getRaiseObjectById(4L).getDto();
		
		Organization org = new Organization();
		org.setId(1L);
		raise.setOrganization(org);
		
		// Act
		ObjectResponse<RaiseDto> response = raiseService.inProgressRaise(raise);
		
		// Assert
		System.out.println(response);
		System.out.println(response.getDto().getName() + " - " + response.getDto().getDescription() + " - " + response.getDto().getPhone() + " - " + response.getDto().getStatus());
	}
	
	@Test
	public void testAssignRaise() {
		// Arrange
		Raise raise = raiseService.getRaiseObjectById(1L).getDto();
		
		User user = new User();
		user.setId(1L);
		raise.setPickUp(user);
		
		// Act
		ObjectResponse<RaiseDto> response = raiseService.assignRaise(raise);
		
		// Assert
		System.out.println(response);
		System.out.println(response.getDto().getName() + " - " + response.getDto().getDescription() + " - " + response.getDto().getPhone() + " - " + response.getDto().getStatus());
	}
	
	@Test
	public void testCompleteRaise() {
		// Arrange
		Raise raise = raiseService.getRaiseObjectById(1L).getDto();
		
		// Act
		ObjectResponse<RaiseDto> response = raiseService.completeRaise(raise);
		
		// Assert
		System.out.println(response);
		System.out.println(response.getDto().getName() + " - " + response.getDto().getDescription() + " - " + response.getDto().getPhone() + " - " + response.getDto().getStatus());
	}
	
	@Test
	public void testCancelRaise() {
		// Arrange
		Raise raise = raiseService.getRaiseObjectById(5L).getDto();
		
		// Act
		ObjectResponse<RaiseDto> response = raiseService.cancelRaise(raise);
		
		// Assert
		System.out.println(response);
		System.out.println(response.getDto().getName() + " - " + response.getDto().getDescription() + " - " + response.getDto().getPhone() + " - " + response.getDto().getStatus());
	}
	
	@Test
	public void testGetRaiseById() {
		// Act
		ObjectResponse<RaiseDto> response = raiseService.getRaiseById(1L);
		
		// Assert
		System.out.println(response);
		System.out.println(response.getDto().getName() + " - " + response.getDto().getDescription() + " - " + response.getDto().getPhone() + " - " + response.getDto().getStatus());
	}
	
	@Test
	public void testGetRaiseObjectById() {
		// Act
		ObjectResponse<Raise> response = raiseService.getRaiseObjectById(1L);
				
		// Assert
		System.out.println(response);
		System.out.println(response.getDto().getName() + " - " + response.getDto().getDescription() + " - " + response.getDto().getPhone() + " - " + response.getDto().getStatus());
	}
	
	@Test
	public void testGetOrganizationInProgressRaises() {
		// Arrange
		Organization organization = new Organization();
		organization.setId(1L);
		
		// Act
		ListResponse<RaiseDto> response = raiseService.getOrganizationInProgressRaises(organization);
		
		// Assert
		System.out.println(response);
		for(RaiseDto raiseDto : response.getDtos()) {
			System.out.println(raiseDto.getName() + " - "+ raiseDto.getDescription() + " - " + raiseDto.getPhone());
		}
	}
	
	@Test
	public void testGetOrganizationDoneRaises() {
		// Arrange
		Organization organization = new Organization();
		organization.setId(1L);
		
		// Act
		ListResponse<RaiseDto> response = raiseService.getOrganizationDoneRaises(organization);
		
		// Assert
		System.out.println(response);
		for(RaiseDto raiseDto : response.getDtos()) {
			System.out.println(raiseDto.getName() + " - "+ raiseDto.getDescription() + " - " + raiseDto.getPhone());
		}
	}
	
	@Test
	public void testGetOrganizationCanceledRaises() {
		// Arrange
		Organization organization = new Organization();
		organization.setId(1L);
		
		// Act
		ListResponse<RaiseDto> response = raiseService.getOrganizationCanceledRaises(organization);
		
		// Assert
		System.out.println(response);
		for(RaiseDto raiseDto : response.getDtos()) {
			System.out.println(raiseDto.getName() + " - "+ raiseDto.getDescription() + " - " + raiseDto.getPhone());
		}
	}
	
	@Test
	public void testGetOrganizationNotDoneRaises() {
		// Arrange
		Organization organization = new Organization();
		organization.setId(1L);
		
		// Act
		ListResponse<RaiseDto> response = raiseService.getOrganizationNotDoneRaises(organization);
		
		// Assert
		System.out.println(response);
		for(RaiseDto raiseDto : response.getDtos()) {
			System.out.println(raiseDto.getName() + " - "+ raiseDto.getDescription() + " - " + raiseDto.getPhone());
		}
	}
	
	@Test
	public void testGetOrganizationAllRaises() {
		// Arrange
		Organization organization = new Organization();
		organization.setId(1L);
		
		// Act
		ListResponse<RaiseDto> response = raiseService.getOrganizationAllRaises(organization);
		
		// Assert
		System.out.println(response);
		for(RaiseDto raiseDto : response.getDtos()) {
			System.out.println(raiseDto.getName() + " - "+ raiseDto.getDescription() + " - " + raiseDto.getPhone());
		}
	}
	
	@Test
	public void testGetUserNewRaises() {
		// Assert
		User user = new User();
		user.setId(1L);
		
		// Act
		ListResponse<RaiseDto> response = raiseService.getUserNewRaises(user);
		
		// Assert
		System.out.println(response);
		for(RaiseDto raiseDto : response.getDtos()) {
			System.out.println(raiseDto.getName() + " - "+ raiseDto.getDescription() + " - " + raiseDto.getPhone());
		}
	}
	
	@Test
	public void testGetUserInProgressRaises() {
		// Assert
		User user = new User();
		user.setId(1L);
		
		// Act
		ListResponse<RaiseDto> response = raiseService.getUserInProgressRaises(user);
		
		// Assert
		System.out.println(response);
		for(RaiseDto raiseDto : response.getDtos()) {
			System.out.println(raiseDto.getName() + " - "+ raiseDto.getDescription() + " - " + raiseDto.getPhone());
		}
	}
	
	@Test
	public void testGetUserDoneRaises() {
		// Assert
		User user = new User();
		user.setId(1L);
		
		// Act
		ListResponse<RaiseDto> response = raiseService.getUserDoneRaises(user);
		
		// Assert
		System.out.println(response);
		for(RaiseDto raiseDto : response.getDtos()) {
			System.out.println(raiseDto.getName() + " - "+ raiseDto.getDescription() + " - " + raiseDto.getPhone());
		}
	}
	
	@Test
	public void testGetUserCanceledRaises() {
		// Assert
		User user = new User();
		user.setId(1L);
		
		// Act
		ListResponse<RaiseDto> response = raiseService.getUserCanceledRaises(user);
		
		// Assert
		System.out.println(response);
		for(RaiseDto raiseDto : response.getDtos()) {
			System.out.println(raiseDto.getName() + " - "+ raiseDto.getDescription() + " - " + raiseDto.getPhone());
		}
	}
	
	@Test
	public void testGetUserNotDoneRaises() {
		// Assert
		User user = new User();
		user.setId(1L);
		
		// Act
		ListResponse<RaiseDto> response = raiseService.getUserNotDoneRaises(user);
		
		// Assert
		System.out.println(response);
		for(RaiseDto raiseDto : response.getDtos()) {
			System.out.println(raiseDto.getName() + " - "+ raiseDto.getDescription() + " - " + raiseDto.getPhone());
		}
	}
	
	@Test
	public void testGetUserAllRaisess() {
		// Assert
		User user = new User();
		user.setId(1L);
		
		// Act
		ListResponse<RaiseDto> response = raiseService.getUserAllRaises(user);
		
		// Assert
		System.out.println(response);
		for(RaiseDto raiseDto : response.getDtos()) {
			System.out.println(raiseDto.getName() + " - "+ raiseDto.getDescription() + " - " + raiseDto.getPhone());
		}
	}
	
	@Test
	public void testGetAllNewRaises() {
		// Act
		ListResponse<RaiseDto> response = raiseService.getAllNewRaises();
		
		// Assert
		System.out.println(response);
		for(RaiseDto raiseDto : response.getDtos()) {
			System.out.println(raiseDto.getName() + " - "+ raiseDto.getDescription() + " - " + raiseDto.getPhone());
		}
	}
	
	@Test
	public void testGetAllInProgressRaises() {
		// Act
		ListResponse<RaiseDto> response = raiseService.getAllInProgressRaises();
		
		// Assert
		System.out.println(response);
		for(RaiseDto raiseDto : response.getDtos()) {
			System.out.println(raiseDto.getName() + " - "+ raiseDto.getDescription() + " - " + raiseDto.getPhone());
		}
	}
	
	@Test
	public void testGetAllDoneRaises() {
		// Act
		ListResponse<RaiseDto> response = raiseService.getAllDoneRaises();
		
		// Assert
		System.out.println(response);
		for(RaiseDto raiseDto : response.getDtos()) {
			System.out.println(raiseDto.getName() + " - "+ raiseDto.getDescription() + " - " + raiseDto.getPhone());
		}
	}
	
	@Test
	public void testGetAllCanceledRaises() {
		// Act
		ListResponse<RaiseDto> response = raiseService.getAllCanceledRaises();
		
		// Assert
		System.out.println(response);
		for(RaiseDto raiseDto : response.getDtos()) {
			System.out.println(raiseDto.getName() + " - "+ raiseDto.getDescription() + " - " + raiseDto.getPhone());
		}
	}
	
	@Test
	public void testGetAllNotDoneRaises() {
		// Act
		ListResponse<RaiseDto> response = raiseService.getAllNotDoneRaises();
		
		// Assert
		System.out.println(response);
		for(RaiseDto raiseDto : response.getDtos()) {
			System.out.println(raiseDto.getName() + " - "+ raiseDto.getDescription() + " - " + raiseDto.getPhone());
		}
	}
	
	@Test
	public void testGetAllRaises() {
		// Act
		ListResponse<RaiseDto> response = raiseService.getAllRaises();
		
		// Assert
		System.out.println(response);
		for(RaiseDto raiseDto : response.getDtos()) {
			System.out.println(raiseDto.getName() + " - "+ raiseDto.getDescription() + " - " + raiseDto.getPhone());
		}
	}
}
