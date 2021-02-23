/**
 * 
 */
package sd.majid.repo;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sd.majid.model.Organization;
import sd.majid.model.Raise;
import sd.majid.model.User;
import sd.majid.util.RaiseStatus;

/**
 * @author MaJiD
 *
 */

@SpringBootTest
public class RaiseRepositoryUnitTests {
	
	@Autowired
	private RaiseRepository raiseRepository;
	
	@Test
	public void testAddRaise() {
		Raise raise = new Raise();
		raise.setName("Abdalmajid Abdalla");
		raise.setPhone("0123456789");
		raise.setDescription("We have some food for you can help 50 persons.");
		raise.setLatitude("12");
		raise.setLongitude("21");
		raise.setStatus(RaiseStatus.NEW);
		raise.setCreatedAt(new Date());
		raise.setUpdatedAt(new Date());
		raiseRepository.save(raise);
	}
	
	@Test
	public void testUpdateRaise() {
		Raise raiseToUpdate = raiseRepository.getOne(1L);
		
		raiseToUpdate.setStatus(RaiseStatus.IN_PROGRESS);
		
		Organization org = new Organization();
		org.setId(1L);
		raiseToUpdate.setOrganization(org);
		
		User updateUser = new User();
		updateUser.setId(1L);
		raiseToUpdate.setUpdateBy(updateUser);
		raiseToUpdate.setUpdatedAt(new Date());
		
		Raise raise = raiseRepository.save(raiseToUpdate);
		System.out.println(raise.getName() + " - " + raise.getDescription() + " - " + raise.getPhone());
	}
	
	@Test
	public void testGetRaiseById() {
		Raise raise = raiseRepository.getOne(1L);
		System.out.println(raise.getName() + " - " + raise.getDescription() + " - " + raise.getPhone());
	}
	
	
	@Test
	public void testGetRaises() {
		List<Raise> raises = raiseRepository.findAll();
		for(Raise raise : raises) {
			System.out.println(raise.getName() + " - " + raise.getDescription() + " - " + raise.getPhone());
		}
	}
}
