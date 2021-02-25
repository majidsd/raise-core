package sd.majid.util;

public enum ApplicationStatus {
	
	ACTIVE("Active", (byte) 0),
	DECLINED("Declined", (byte) 1);
	
	private String name;
	private Byte value;
	
	private ApplicationStatus(String name, Byte value) {
		this.name = name;
		this.value = value;
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
	 * @return the value
	 */
	public Byte getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(Byte value) {
		this.value = value;
	}

}
