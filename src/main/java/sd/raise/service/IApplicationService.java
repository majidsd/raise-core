/**
 * 
 */
package sd.raise.service;

import sd.raise.model.Application;
import sd.raise.response.ObjectResponse;

/**
 * @author MaJiD
 *
 */
public interface IApplicationService {
	
	public ObjectResponse<Application> addApplication(Application application);
	public ObjectResponse<Application> declineApplication(Application application);
	
	public ObjectResponse<Application> getApplicationById(Integer id);
	public ObjectResponse<Application> getApplicationByAppId(String appId);

}
