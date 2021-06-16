/**
 * 
 */
package sd.majid.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sd.majid.model.Application;
import sd.majid.response.ObjectResponse;

/**
 * @author MaJiD
 *
 */
@SpringBootTest
public class ApplicationServiceUnitTests {
	
	@Autowired
	private IApplicationService applicationService;
	
	@Test
	public void testAddApplication() {
		// Assess
		String appId = "abcd";
		String hashkey = "ffdfjdklfjeoioruweiruerewkd";
		Application application = new Application();
		application.setAppId(appId);
		application.setHashkey(hashkey);
		
		// Act
		ObjectResponse<Application> savedApplication = applicationService.addApplication(application);
		
		// Assert
		System.out.println(savedApplication.getDto().getAppId() + " - " + savedApplication.getDto().getHashkey());
	}
	
	@Test
	public void testDeclineApplication() {
		// Assess
		Application application = applicationService.getApplicationById(1).getDto();
		
		// Act
		ObjectResponse<Application> savedApplication = applicationService.declineApplication(application);
		
		// Assert
		System.out.println(savedApplication.getDto().getAppId() + " - " + savedApplication.getDto().getHashkey());
	}
	
	@Test
	public void testGetApplicationById() {
		// Act
		Application application = applicationService.getApplicationById(1).getDto();
		
		// Assert
		System.out.println(application.getAppId() + " - " + application.getHashkey());
	}
	
	@Test
	public void testGetApplicationByAppId() {
		// Assess
		String appId = "abc";
		
		// Act
		Application application = applicationService.getApplicationByAppId(appId).getDto();
		
		// Assert
		System.out.println(application.getAppId() + " - " + application.getHashkey());
	}

}