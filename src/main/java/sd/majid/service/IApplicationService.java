/**
 * 
 */
package sd.majid.service;

import sd.majid.model.Application;
import sd.majid.response.ObjectResponse;

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
