/**
 * 
 */
package sd.raise.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import sd.raise.util.ApplicationStatus;

/**
 * @author MaJiD
 *
 */
@Entity
@Table(name = "application")
public class Application {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "appId", nullable = false, unique = true)
	private String appId;
	
	@Column(name = "hashkey", nullable = false, unique = false)
	private String hashkey;
	
	@Column(name = "status", nullable = false, unique = false)
	private ApplicationStatus status;
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the appId
	 */
	public String getAppId() {
		return appId;
	}
	/**
	 * @param appId the appId to set
	 */
	public void setAppId(String appId) {
		this.appId = appId;
	}
	/**
	 * @return the hashkey
	 */
	public String getHashkey() {
		return hashkey;
	}
	/**
	 * @param key the hashkey to set
	 */
	public void setHashkey(String hashkey) {
		this.hashkey = hashkey;
	}
	/**
	 * @return the status
	 */
	public ApplicationStatus getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(ApplicationStatus status) {
		this.status = status;
	}
}
