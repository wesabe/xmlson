package com.wesabe.xmlson;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * An ordered list of XMLSON members.
 * 
 * @author coda
 */
public class XmlsonArray extends XmlsonMember {
	private final List<XmlsonMember> members = new LinkedList<XmlsonMember>();

	/**
	 * Creates a named XMLSON array.
	 * 
	 * @param name
	 *            the array's name (usually the plural of the array member names)
	 */
	public XmlsonArray(String name) {
		super(name);
	}

	/**
	 * Adds an XMLSON member to the end of the array.
	 * 
	 * @param member
	 *            the member
	 * @return {@code this}, for chaining purposes
	 */
	public XmlsonArray add(XmlsonMember member) {
		if (member == this) {
			throw new IllegalArgumentException("can't add member to itself");
		} else if (member instanceof XmlsonDocument) {
			throw new IllegalArgumentException("can't add an XmlsonDocument as a member");
		}
		
		members.add(member);
		return this;
	}
	
	/**
	 * Returns an unmodifiable view of the array's members.
	 * 
	 * @return the array's members
	 */
	public List<XmlsonMember> getMembers() {
		return Collections.unmodifiableList(members);
	}
}
