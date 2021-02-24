/**
 * 
 */
package sd.majid.dto;

/**
 * @author MaJiD
 *
 */
public class PickUpUserDto {
	
	private Long id;
	private String name;
	private String phone;
	private String Organization;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the organization
	 */
	public String getOrganization() {
		return Organization;
	}
	/**
	 * @param organization the organization to set
	 */
	public void setOrganization(String organization) {
		Organization = organization;
	}
}
