package com.wesabe.xmlson;

/**
 * An XMLSON boolean value.
 * 
 * @author coda
 */
public class XmlsonBoolean extends XmlsonPrimitive<Boolean> {
	private final Boolean value;

	/**
	 * Creates a new {@link XmlsonBoolean} with a given value.
	 * 
	 * @param value
	 *            the primitive value
	 */
	public XmlsonBoolean(Boolean value) {
		this.value = value;
	}

	/* (non-Javadoc)
	 * @see com.wesabe.xmlson.XmlsonPrimitive#getValue()
	 */
	@Override
	public Boolean getValue() {
		return value;
	}

}
