/**
 * 
 */
package sd.majid.repo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sd.majid.model.Application;
import sd.majid.util.ApplicationStatus;

/**
 * @author MaJiD
 *
 */
@SpringBootTest
public class ApplicationRepositoryUnitTests {
	
	@Autowired
	private ApplicationRepository applicationRepository;
	
	@Test
	public void testAddApplication() {
		// Assess
		String appId = "abc";
		String hashkey = "ffdfjdklfjeoioruweiruerewk";
		Application application = new Application();
		application.setAppId(appId);
		application.setHashkey(hashkey);
		application.setStatus(ApplicationStatus.ACTIVE);
		
		// Act
		Application savedApplication = applicationRepository.save(application);
		
		// Assert
		System.out.println(savedApplication.getAppId() + " - " + savedApplication.getHashkey());
	}
	
	@Test
	public void testGetApplicationById() {
		// Act
		Application application = applicationRepository.getOne(1);
		
		// Assert
		System.out.println(application.getAppId() + " - " + application.getHashkey());
	}
	
	@Test
	public void testGetApplicationByAppId() {
		// Assess
		String appId = "abc";
		
		// Act
		Application application = applicationRepository.getApplicationByAppId(appId);
		
		// Assert
		System.out.println(application.getAppId() + " - " + application.getHashkey());
	}
}
