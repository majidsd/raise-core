/**
 * 
 */
package sd.majid.response;

/**
 * @author MaJiD
 *
 */
public class ObjectResponse<T> extends BaseResponse {
	
	private T dto;

	/**
	 * @return the dto
	 */
	public T getDto() {
		return dto;
	}

	/**
	 * @param dto the dto to set
	 */
	public void setDto(T dto) {
		this.dto = dto;
	}
	
	public ObjectResponse() {
		super();
	}

	public ObjectResponse(Integer responseCode, String responseMessage, T dto) {
		super(responseCode, responseMessage);
		this.dto = dto;
	}

	public ObjectResponse(ResponseEnum responseEnum) {
		super(responseEnum);
	}

	public ObjectResponse(ResponseEnum responseEnum, T dto) {
		this(responseEnum);
		this.dto = dto;
	}

	@Override
	public String toString() {
		return "ObjectResponse [dto=" + dto + ", toString()=" + super.toString() + "]";
	}

}
