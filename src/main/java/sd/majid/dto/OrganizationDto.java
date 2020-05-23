/**
 * 
 */
package sd.majid.dto;

/**
 * @author MaJiD
 *
 */
public class OrganizationDto {
	private Long id;
	private String name;
	private String description;
	private Byte status;
	private Long creater_id;
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
	/**
	 * @return the creater_id
	 */
	public Long getCreater_id() {
		return creater_id;
	}
	/**
	 * @param creater_id the creater_id to set
	 */
	public void setCreater_id(Long creater_id) {
		this.creater_id = creater_id;
	}
}
