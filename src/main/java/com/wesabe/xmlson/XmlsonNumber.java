package com.wesabe.xmlson;

/**
 * An XMLSON number.
 * 
 * @author coda
 */
public class XmlsonNumber extends XmlsonPrimitive<Number> {
	private final Number value;

	/**
	 * Creates a new {@link XmlsonNumber} with a given value.
	 * 
	 * @param value
	 *            the given value
	 */
	public XmlsonNumber(Number value) {
		this.value = value;
	}

	/* (non-Javadoc)
	 * @see com.wesabe.xmlson.XmlsonPrimitive#getValue()
	 */
	@Override
	public Number getValue() {
		return value;
	}

}
