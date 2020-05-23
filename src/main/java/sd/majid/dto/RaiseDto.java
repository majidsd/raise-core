/**
 * 
 */
package sd.majid.dto;

/**
 * @author MaJiD
 *
 */
public class RaiseDto {
	
	private Long id;
	private Long user_id;
	private String name;
	private String phone;
	private String description;
	private String longitude;
	private String latitude;
	private Long organization_id;
	private Byte status;
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
	 * @return the user_id
	 */
	public Long getUser_id() {
		return user_id;
	}
	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
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
	public Long getOrganization_id() {
		return organization_id;
	}
	/**
	 * @param organization_id the organization_id to set
	 */
	public void setOrganization_id(Long organization_id) {
		this.organization_id = organization_id;
	}
	/**
	 * @return the status
	 */
	public Byte getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Byte status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "RaiseDto [id=" + id + ", user_id=" + user_id + ", name=" + name + ", phone=" + phone + ", description="
				+ description + ", longitude=" + longitude + ", latitude=" + latitude + ", organization_id="
				+ organization_id + ", status=" + status + "]";
	}

}
