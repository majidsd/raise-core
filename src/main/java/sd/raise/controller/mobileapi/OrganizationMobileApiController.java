/**
 * 
 */
package sd.raise.controller.mobileapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sd.raise.service.IOrganizationService;

/**
 * @author MaJiD
 *
 */
@RestController
@RequestMapping("/api/mobile/organization")
public class OrganizationMobileApiController {
	@Autowired
	private IOrganizationService organizationService;
	
}
