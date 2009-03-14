package com.wesabe.xmlson;

/**
 * An XMLSON string.
 * 
 * @author coda
 */
public class XmlsonString extends XmlsonPrimitive<String> {
	private final String value;

	/**
	 * Creates a new {@link XmlsonString} with a given value.
	 * 
	 * @param value
	 *            the given value
	 */
	public XmlsonString(String value) {
		this.value = value;
	}

	/* (non-Javadoc)
	 * @see com.wesabe.xmlson.XmlsonPrimitive#getValue()
	 */
	@Override
	public String getValue() {
		return value;
	}
}
