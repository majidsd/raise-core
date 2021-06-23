/**
 * 
 */
package sd.raise.response;

/**
 * @author MaJiD
 *
 */
public class BaseResponse {
	private Integer responseCode;
	private String responseMessage;
	/**
	 * @return the responseCode
	 */
	public Integer getResponseCode() {
		return responseCode;
	}
	/**
	 * @param responseCode the responseCode to set
	 */
	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}
	/**
	 * @return the responseMessage
	 */
	public String getResponseMessage() {
		return responseMessage;
	}
	/**
	 * @param responseMessage the responseMessage to set
	 */
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	@Override
	public String toString() {
		return "BaseResponse [responseCode=" + responseCode + ", responseMessage=" + responseMessage + "]";
	}
	
	public BaseResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BaseResponse(Integer responseCode, String responseMessage) {
		super();
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
	}
	
	public BaseResponse(ResponseEnum responseEnum) {
		super();
		this.responseCode = responseEnum.getResponseCode();
		this.responseMessage = responseEnum.getResponseMessage();
	}

}
