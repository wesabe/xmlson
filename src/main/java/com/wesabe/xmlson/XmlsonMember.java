package com.wesabe.xmlson;

/**
 * A named XMLSON element.
 * 
 * @author coda
 */
public abstract class XmlsonMember extends XmlsonElement {
	private final String name;

	/**
	 * Create a new {@link XmlsonMember} with the given name.
	 * 
	 * @param name
	 *            the member's name
	 */
	public XmlsonMember(String name) {
		this.name = name;
	}

	/**
	 * Returns the member's name.
	 * 
	 * @return the member's name
	 */
	public String getName() {
		return name;
	}
}
