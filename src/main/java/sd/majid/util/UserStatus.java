package sd.majid.util;

public enum UserStatus {
	NEW("New", (byte) 0),
	ACTIVE("Active", (byte) 1),
	REVOKED("Revoked", (byte) 2),
	DELETED("Deleted", (byte) 3);
	
	private String name;
	private Byte value;
	
	private UserStatus(String name, Byte value) {
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
