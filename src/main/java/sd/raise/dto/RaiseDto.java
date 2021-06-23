/**
 * 
 */
package sd.raise.dto;

import java.util.Date;

import sd.raise.util.RaiseStatus;

/**
 * @author MaJiD
 *
 */
public class RaiseDto {
	
	private Long id;
	private Long createdById;
	private String name;
	private String phone;
	private String description;
	private String longitude;
	private String latitude;
	private OrganizationDto organization;
	private RaiseStatus status;
	private Date createdAt;
	private Date updatedAt;
	private PickUpUserDto pickUpUser;
	private Long updateBy;
	
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
	 * @return the createdById
	 */
	public Long getCreatedById() {
		return createdById;
	}
	/**
	 * @param createdById the createdById to set
	 */
	public void setCreatedById(Long createdById) {
		this.createdById = createdById;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}
	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	/**
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}
	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	/**
	 * @return the organization_id
	 */
	public OrganizationDto getOrganization() {
		return organization;
	}
	/**
	 * @param organization_id the organization_id to set
	 */
	public void setOrganization(OrganizationDto organization) {
		this.organization = organization;
	}
	/**
	 * @return the status
	 */
	public RaiseStatus getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(RaiseStatus status) {
		this.status = status;
	}
	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}
	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	/**
	 * @return the updatedAt
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}
	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	/**
	 * @return the pickUpUser
	 */
	public PickUpUserDto getPickUpUser() {
		return pickUpUser;
	}
	/**
	 * @param pickUpUser the pickUpUser to set
	 */
	public void setPickUpUser(PickUpUserDto pickUpUser) {
		this.pickUpUser = pickUpUser;
	}
	/**
	 * @return the updateBy
	 */
	public Long getUpdateBy() {
		return updateBy;
	}
	/**
	 * @param updateBy the updateBy to set
	 */
	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}
	@Override
	public String toString() {
		return "RaiseDto [id=" + id + ", createdById=" + createdById + ", name=" + name + ", phone=" + phone
				+ ", description=" + description + ", longitude=" + longitude + ", latitude=" + latitude
				+ ", organization=" + organization + ", status=" + status + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + ", pickUpUser=" + pickUpUser + ", updateBy=" + updateBy + "]";
	}
}
