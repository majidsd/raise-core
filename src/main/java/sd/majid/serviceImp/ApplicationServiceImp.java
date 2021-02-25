/**
 * 
 */
package sd.majid.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sd.majid.model.Application;
import sd.majid.repo.ApplicationRepository;
import sd.majid.response.ObjectResponse;
import sd.majid.response.ResponseEnum;
import sd.majid.service.IApplicationService;
import sd.majid.util.ApplicationStatus;

/**
 * @author MaJiD
 *
 */
@Service
public class ApplicationServiceImp implements IApplicationService {
	
	@Autowired
	private ApplicationRepository applicationRepository;
	
	@Override
	public ObjectResponse<Application> addApplication(Application application) {
		ObjectResponse<Application> response;
		application.setStatus(ApplicationStatus.ACTIVE);
		Application savedApplication = applicationRepository.save(application);
		if(savedApplication != null) {
			response = new ObjectResponse<Application>(ResponseEnum.SUCCESS, savedApplication);
		} else {
			response = new ObjectResponse<Application>(ResponseEnum.ITEM_NOT_FOUND, null);
		}
		return response;
	}
	
	@Override
	public ObjectResponse<Application> declineApplication(Application application) {
		ObjectResponse<Application> response;
		application.setStatus(ApplicationStatus.DECLINED);
		Application savedApplication = applicationRepository.save(application);
		if(savedApplication != null) {
			response = new ObjectResponse<Application>(ResponseEnum.SUCCESS, savedApplication);
		} else {
			response = new ObjectResponse<Application>(ResponseEnum.ITEM_NOT_FOUND, null);
		}
		return response;
	}
	
	@Override
	public ObjectResponse<Application> getApplicationById(Integer id) {
		ObjectResponse<Application> response;
		Application application = applicationRepository.getOne(id);
		if(application != null) {
			response = new ObjectResponse<Application>(ResponseEnum.SUCCESS, application);
		} else {
			response = new ObjectResponse<Application>(ResponseEnum.ITEM_NOT_FOUND, null);
		}
		return response;
	}

	@Override
	public ObjectResponse<Application> getApplicationByAppId(String appId) {
		ObjectResponse<Application> response;
		Application application = applicationRepository.getApplicationByAppId(appId);
		if(application != null) {
			response = new ObjectResponse<Application>(ResponseEnum.SUCCESS, application);
		} else {
			response = new ObjectResponse<Application>(ResponseEnum.ITEM_NOT_FOUND, null);
		}
		return response;
	}

}
