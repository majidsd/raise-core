/**
 * 
 */
package sd.majid.util;

/**
 * @author MaJiD
 *
 */
public enum UserType {
	
	ADMIN("Admin", (byte) 0),
	NGO_MANAGEMENT("NGO_Management", (byte) 1),
	NGO_PICKUP("NGO_PickUp", (byte) 2),
	NGO_FULL("NGO_Full", (byte) 3),
	RAISER("Raiser", (byte) 4),
	VISITOR("Visitor", (byte) 5);
	
	private String name;
	private Byte value;
	
	private UserType(String name, Byte value) {
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
