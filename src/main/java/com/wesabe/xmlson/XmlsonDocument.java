package com.wesabe.xmlson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * An XMLSON document containing a list of {@link XmlsonMember}s.
 * 
 * @author coda
 */
public class XmlsonDocument {
	private final String name;
	private final List<XmlsonMember> members = new ArrayList<XmlsonMember>();

	/**
	 * Creates a new XMLSON document with a given name.
	 * 
	 * @param name
	 *            the name of the document's root element
	 */
	public XmlsonDocument(String name) {
		this.name = name;
	}

	/**
	 * Returns the document's name.
	 * 
	 * @return the document's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Adds an {@link XmlsonMember} to the document.
	 * 
	 * @param member
	 *            an {@link XmlsonMember}
	 * @return {@code this}, for chaining purposes
	 */
	public XmlsonDocument add(XmlsonMember member) {
		members.add(member);
		return this;
	}

	/**
	 * Returns a list of the document's members.
	 * 
	 * @return the document's members
	 */
	public List<XmlsonMember> getMembers() {
		return Collections.unmodifiableList(members);
	}
}
