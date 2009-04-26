package com.wesabe.xmlson;

import com.google.gson.JsonEscaper;

/**
 * An XMLSON string.
 * 
 * @author coda
 */
@SuppressWarnings("deprecation")
public class XmlsonString extends XmlsonPrimitive<String> {
	private static final JsonEscaper ESCAPER = new JsonEscaper(false);
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
		return ESCAPER.escapeJsonString(value);
	}
}
