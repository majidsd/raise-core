/**
 * 
 */
package sd.raise.response;

import java.util.List;

/**
 * @author MaJiD
 *
 */
public class ListResponse<T> extends BaseResponse {
	
	private List<T> dtos;

	/**
	 * @return the dtos
	 */
	public List<T> getDtos() {
		return dtos;
	}

	/**
	 * @param dtos the dtos to set
	 */
	public void setDtos(List<T> dtos) {
		this.dtos = dtos;
	}
	
	public ListResponse() {
		super();
	}
	
	public ListResponse(Integer responseCode, String responseMessage, List<T> dtos) {
		super(responseCode, responseMessage);
		this.dtos = dtos;
	}

	public ListResponse(ResponseEnum responseEnum) {
		super(responseEnum);
	}

	public ListResponse(ResponseEnum responseEnum, List<T> dtos) {
		this(responseEnum);
		this.dtos = dtos;
	}

	@Override
	public String toString() {
		return "ListResponse [dtos=" + dtos + "]";
	}
	
}
