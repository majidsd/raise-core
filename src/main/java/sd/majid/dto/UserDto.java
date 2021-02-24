/**
 * 
 */
package sd.majid.dto;

import java.util.Date;

import sd.majid.util.UserStatus;
import sd.majid.util.UserType;

/**
 * @author MaJiD
 *
 */
public class UserDto {
	private Long id;
	private String name;
	private String phone;
	private String email;
	private String userName;
	private Date createdAt;
	private Date updatedAt;
	private UserStatus status;
	private UserType type;
	private Long organization;
	
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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
	 * @return the status
	 */
	public UserStatus getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(UserStatus status) {
		this.status = status;
	}
	/**
	 * @return the type
	 */
	public UserType getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(UserType type) {
		this.type = type;
	}
	/**
	 * @return the organization
	 */
	public Long getOrganization() {
		return organization;
	}
	/**
	 * @param organization the organization to set
	 */
	public void setOrganization(Long organization) {
		this.organization = organization;
	}
	@Override
	public String toString() {
		return "UserDto [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + ", userName="
				+ userName + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", status=" + status + ", type="
				+ type + ", organization=" + organization + "]";
	}
}
