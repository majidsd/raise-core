/**
 * 
 */
package sd.raise.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sd.raise.model.Application;
import sd.raise.repo.ApplicationRepository;
import sd.raise.response.ObjectResponse;
import sd.raise.response.ResponseEnum;
import sd.raise.service.IApplicationService;
import sd.raise.util.ApplicationStatus;

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
