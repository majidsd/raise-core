package sd.majid.util;

public enum RaiseStatus {
	
	NEW("New", (byte) 0),
	IN_PROGRESS("In Progress", (byte) 1),
	DONE("Done", (byte) 2),
	CANCELED("Canceled", (byte) -1);
	
	private String name;
	private Byte value;
	
	private RaiseStatus(String name, Byte value) {
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
